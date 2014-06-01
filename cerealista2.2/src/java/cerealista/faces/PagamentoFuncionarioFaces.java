/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.PagamentoFuncionarioDAO;
import cerealista.dao.PessoaCategoriaDAO;
import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.SessionDAO;
import cerealista.dao.UsuarioDAO;
import classe.entidade.PagamentoFuncionario;
import classe.entidade.SaldoCaixa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eder
 */
public class PagamentoFuncionarioFaces {

    private PagamentoFuncionario selectedPagamentoFuncionario = new PagamentoFuncionario();
    private SaldoCaixa selecetedSaldoCaixa;
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private PagamentoFuncionarioDAO pagFunDAO = new PagamentoFuncionarioDAO();
    private PessoaCategoriaDAO pesCatDAO = new PessoaCategoriaDAO();
    private UsuarioDAO usuDAO = new UsuarioDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<PagamentoFuncionario> cachedPagamentoFuncionario = null;
    private Integer codigo;
    private Integer pesCatId;
    private Double valor;
    private Double total;
    private Date dataInicial;
    private Date dataFinal;
    private String todos;

    /** Creates a new instance of PagamentoFuncionarioFaces */
    public PagamentoFuncionarioFaces() {
    }

    public void addPagamentoFuncionario() {
        selectedPagamentoFuncionario = new PagamentoFuncionario();
        codigo = 1;
        Date data = new Date();
        selectedPagamentoFuncionario.setPagFunData(data);
        valor = 0.0;
        sesDAO.setaSession("id", "addPagamentoFuncionario");
    }

    public void finishAddPagamentoFuncionario() {
        pagFunDAO.addPagamentoFuncionario(selectedPagamentoFuncionario);

        if (selectedPagamentoFuncionario.getPagFunValor() != valor.doubleValue()) {
            Date data = new Date();
            Double salCaiVlr = 0.0;
            selecetedSaldoCaixa = new SaldoCaixa();
            selecetedSaldoCaixa.setSalCaiData(data);
            salCaiVlr = salCaiDAO.getValor(salCaiVlr);
            if (codigo != 0) {
                selecetedSaldoCaixa.setSalCaiValor(salCaiVlr - selectedPagamentoFuncionario.getPagFunValor());
            } else {
                valor = valor - selectedPagamentoFuncionario.getPagFunValor();
                selecetedSaldoCaixa.setSalCaiValor(salCaiVlr + valor);
            }
            selecetedSaldoCaixa.setSalCaiTabela("Pag. Func. cod:" + selectedPagamentoFuncionario.getPagFunCodigo());
            salCaiDAO.addSaldoCaixa(selecetedSaldoCaixa);
        }
        cachedPagamentoFuncionario = null;
        sesDAO.setaSession("id", "pagamentoFuncionario");
    }

    public void updatePagamentoFuncionario() {
        codigo = 0;
        valor = selectedPagamentoFuncionario.getPagFunValor();
        sesDAO.setaSession("id", "addPagamentoFuncionario");
    }

    public void removePagamentoFuncionario() {
        pagFunDAO.removePagamentoFuncionario(selectedPagamentoFuncionario);

        Date data = new Date();
        Double salCaiVlr = 0.0;
        selecetedSaldoCaixa = new SaldoCaixa();

        selecetedSaldoCaixa.setSalCaiData(data);
        salCaiVlr = salCaiDAO.getValor(salCaiVlr);
        selecetedSaldoCaixa.setSalCaiValor(salCaiVlr + selectedPagamentoFuncionario.getPagFunValor());
        selecetedSaldoCaixa.setSalCaiTabela("Pag. Func. cod:" + selectedPagamentoFuncionario.getPagFunCodigo() + "Excluido");
        salCaiDAO.addSaldoCaixa(selecetedSaldoCaixa);

        cachedPagamentoFuncionario = null;
        sesDAO.setaSession("id", "pagamentoFuncionario");
    }
    public void chamaPagamentoFuncionario(){
        sesDAO.setaSession("id", "pagamentoFuncionario");
    }
    public List<PagamentoFuncionario> getCachedPagamentoFuncionario() {

        if (selectedPagamentoFuncionario.getPesCatCodigo() != null) {
            if (selectedPagamentoFuncionario.getPesCatCodigo().getPesCatCodigo() == 0) {
                total = 0.0;
                cachedPagamentoFuncionario = pagFunDAO.getPagamentoFuncionariosTodos();
                for (PagamentoFuncionario pagFun : cachedPagamentoFuncionario) {
                    total = total + pagFun.getPagFunValor();
                }
            } else if (selectedPagamentoFuncionario.getPesCatCodigo().getPesCatCodigo() > 0 && dataInicial != null && dataFinal != null) {
                total = 0.0;
                cachedPagamentoFuncionario = pagFunDAO.getPagamentoFuncionarios(selectedPagamentoFuncionario.getPesCatCodigo().getPesCatCodigo(), dataInicial, dataFinal);
                for (PagamentoFuncionario pagFun : cachedPagamentoFuncionario) {
                    total = total + pagFun.getPagFunValor();
                }
            } else if (selectedPagamentoFuncionario.getPesCatCodigo().getPesCatCodigo() > 0 && dataInicial == null && dataFinal == null) {
                total = 0.0;
                cachedPagamentoFuncionario = pagFunDAO.getPagamentoFuncionariosIdFun(selectedPagamentoFuncionario.getPesCatCodigo().getPesCatCodigo());
                for (PagamentoFuncionario pagFun : cachedPagamentoFuncionario) {
                    total = total + pagFun.getPagFunValor();
                }
            }
        }
        return cachedPagamentoFuncionario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public PagamentoFuncionario getSelectedPagamentoFuncionario() {
        return selectedPagamentoFuncionario;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setSelectedPagamentoFuncionario(PagamentoFuncionario selectedPagamentoFuncionario) {
        this.selectedPagamentoFuncionario = selectedPagamentoFuncionario;
    }

    public Integer getPesCatId() {
        return pesCatId;
    }

    public void setPesCatId(Integer pesCatId) {
        this.pesCatId = pesCatId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }
}
