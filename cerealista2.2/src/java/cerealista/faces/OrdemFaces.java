/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.OrdemDAO;
import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Ordem;
import classe.entidade.SaldoCaixa;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class OrdemFaces {

    private Ordem selectedOrdem = new Ordem();
    private SaldoCaixa selectedSaldoCaixa;
    private OrdemDAO ordDAO = new OrdemDAO();
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Ordem> cachedOrdem = null;
    private List<Ordem> cachedPesqOrdem = null;
    private Integer codigo;
    private Double valor;
    private Double pesqTotal;
    private Double pesqPesoTotal;
    private Double pesqFunRuralTotal;
    private Double pesqDescontoTotal;
    private Double pesqRestanteTotal;
    private Double pesqAdiantamentoTotal;
    private String status;//se esta aberta a ordem
    private Date dataInicial;
    private Date dataFinal;
    private Date dataIniVen;
    private Date dataFinVen;
    private String todas = "T";
    private Integer pesId;
    private Integer pessoaCategoria;

    /** Creates a new instance of OrdemFaces */
    public OrdemFaces() {
    }

    public void addOrdem() {
        selectedOrdem = new Ordem();
        codigo = 1;
        selectedOrdem.setOrdPago("N");
        Date dt = new Date();
        selectedOrdem.setOrdData(dt);
        selectedOrdem.setOrdPesoTotal(0.0);
        valor = 0.0;
        sesDAO.setaSession("id", "addOrdem");
    }

    public void finishAddOrdem() throws SQLException {
        selectedOrdem.calculaOrdValorRestante();
        ordDAO.addOrdem(selectedOrdem);
        if (selectedOrdem.getOrdAdiantemento() != valor.doubleValue()) {
            Date dt = new Date();
            Double salCaiVlr = 0.0;
            selectedSaldoCaixa = new SaldoCaixa();
            selectedSaldoCaixa.setSalCaiData(dt);
            if (codigo != 0) {
                salCaiVlr = salCaiDAO.getValor(salCaiVlr);
                selectedSaldoCaixa.setSalCaiValor(salCaiVlr - selectedOrdem.getOrdAdiantemento());
                selectedSaldoCaixa.setSalCaiTabela("Ordem cod:"+selectedOrdem.getOrdCodigo());
            } else {
                salCaiVlr = salCaiDAO.getValor(salCaiVlr);
                valor = valor - selectedOrdem.getOrdAdiantemento();
                selectedSaldoCaixa.setSalCaiValor(valor + salCaiVlr);
                selectedSaldoCaixa.setSalCaiTabela("Ordem cod:"+selectedOrdem.getOrdCodigo());
            }
            salCaiDAO.addSaldoCaixa(selectedSaldoCaixa);
        }


        cachedOrdem = null;

        sesDAO.setaSession("id", "ordem");
    }

    public void updateOrdem() {
        codigo = 0;
        valor = selectedOrdem.getOrdAdiantemento();
        sesDAO.setaSession("id", "addOrdem");
    }

    public void removeOrdem() {
        ordDAO.removeOrdem(selectedOrdem);

        if (selectedOrdem.getOrdAdiantemento() > 0.0) {
            Integer id = 0;
            id = salCaiDAO.getProximo(id);
            Date data = new Date();
            Double salCaiVlr = 0.0;
            selectedSaldoCaixa = new SaldoCaixa();

            salCaiVlr = salCaiDAO.getValor(salCaiVlr);
            selectedSaldoCaixa.setSalCaiCodigo(id);
            selectedSaldoCaixa.setSalCaiData(data);
            selectedSaldoCaixa.setSalCaiValor(salCaiVlr + selectedOrdem.getOrdAdiantemento());
            salCaiDAO.addSaldoCaixa(selectedSaldoCaixa);
        }
        cachedOrdem = null;
        sesDAO.setaSession("id", "ordem");
    }
    public void chamaOrdem(){
        sesDAO.setaSession("id", "ordem");
    }
    public void chamaPesqOrdem(){
        sesDAO.setaSession("id", "pesqOrdem");
    }
    public List<SelectItem> getAberta() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("A"));
        toReturn.add(new SelectItem("F"));

        return toReturn;
    }

    public List<SelectItem> getPesqAberta() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("T"));
        toReturn.add(new SelectItem("A"));
        toReturn.add(new SelectItem("F"));

        return toReturn;
    }

    public List<Ordem> getCachedOrdem() {
        cachedOrdem = null;
        if (cachedOrdem == null) {
            cachedOrdem = ordDAO.getOrdems();
        }
        return cachedOrdem;
    }

    public List<Ordem> getCachedPesqOrdem() {

        cachedPesqOrdem = null;
        if (selectedOrdem.getPesCatCodigo() != null) {
            if (dataIniVen != null && dataFinVen != null) {
                dataInicial = null;
                dataFinal = null;
            } else {
                dataIniVen = null;
                dataFinVen = null;
            }

            pesqDescontoTotal = 0.0;
            pesqTotal = 0.0;
            pesqFunRuralTotal = 0.0;
            pesqPesoTotal = 0.0;
            pesqRestanteTotal = 0.0;
            pesqAdiantamentoTotal = 0.0;
            pesId = selectedOrdem.getPesCatCodigo().getPesCatCodigo();
            if (todas.equals("T")) {
                pesId = 0;
            }
            cachedPesqOrdem = ordDAO.getPesqOrdems(selectedOrdem.getOrdAberta(), pesId, dataInicial, dataFinal, dataIniVen, dataFinVen);
            for (Ordem ord : cachedPesqOrdem) {
                if (ord.getOrdDesconto() != null) {
                    pesqDescontoTotal = pesqDescontoTotal + ord.getOrdDesconto();
                }
                if (ord.getOrdValorTotal() != null) {
                    pesqTotal = pesqTotal + ord.getOrdValorTotal();
                }
                if (ord.getOrdFundoRural() != null) {
                    pesqFunRuralTotal = pesqFunRuralTotal + ord.getOrdFundoRural();
                }
                if (ord.getOrdPesoTotal() != null) {
                    pesqPesoTotal = pesqPesoTotal + ord.getOrdPesoTotal();
                }
                if (ord.getOrdValorRestante() != null) {
                    pesqRestanteTotal = pesqRestanteTotal + ord.getOrdValorRestante();
                }
                if (ord.getOrdAdiantemento() != null) {
                    pesqAdiantamentoTotal = pesqAdiantamentoTotal + ord.getOrdAdiantemento();
                }
            }
        }
        return cachedPesqOrdem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Ordem getSelectedOrdem() {
        return selectedOrdem;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setSelectedOrdem(Ordem selectedOrdem) {
        this.selectedOrdem = selectedOrdem;
    }

    public Date getDataFinVen() {
        return dataFinVen;
    }

    public void setDataFinVen(Date dataFinVen) {
        this.dataFinVen = dataFinVen;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataIniVen() {
        return dataIniVen;
    }

    public void setDataIniVen(Date dataIniVen) {
        this.dataIniVen = dataIniVen;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Double getPesqAdiantamentoTotal() {
        return pesqAdiantamentoTotal;
    }

    public void setPesqAdiantamentoTotal(Double pesqAdiantamentoTotal) {
        this.pesqAdiantamentoTotal = pesqAdiantamentoTotal;
    }

    public Double getPesqDescontoTotal() {
        return pesqDescontoTotal;
    }

    public void setPesqDescontoTotal(Double pesqDescontoTotal) {
        this.pesqDescontoTotal = pesqDescontoTotal;
    }

    public String getTodas() {
        return todas;
    }

    public void setTodas(String todas) {
        this.todas = todas;
    }

    public Double getPesqFunRuralTotal() {
        return pesqFunRuralTotal;
    }

    public void setPesqFunRuralTotal(Double pesqFunRuralTotal) {
        this.pesqFunRuralTotal = pesqFunRuralTotal;
    }

    public Double getPesqPesoTotal() {
        return pesqPesoTotal;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public void setPesqPesoTotal(Double pesqPesoTotal) {
        this.pesqPesoTotal = pesqPesoTotal;
    }

    public Double getPesqRestanteTotal() {
        return pesqRestanteTotal;
    }

    public void setPesqRestanteTotal(Double pesqRestanteTotal) {
        this.pesqRestanteTotal = pesqRestanteTotal;
    }

    public Double getPesqTotal() {
        return pesqTotal;
    }

    public void setPesqTotal(Double pesqTotal) {
        this.pesqTotal = pesqTotal;
    }

    public SaldoCaixaDAO getSalCaiDAO() {
        return salCaiDAO;
    }

    public void setSalCaiDAO(SaldoCaixaDAO salCaiDAO) {
        this.salCaiDAO = salCaiDAO;
    }

    public SaldoCaixa getSelectedSaldoCaixa() {
        return selectedSaldoCaixa;
    }

    public void setSelectedSaldoCaixa(SaldoCaixa selectedSaldoCaixa) {
        this.selectedSaldoCaixa = selectedSaldoCaixa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPessoaCategoria() {
        return pessoaCategoria;
    }

    public void setPessoaCategoria(Integer pessoaCategoria) {
        this.pessoaCategoria = pessoaCategoria;
    }
}
