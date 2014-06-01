/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.DespesaDAO;
import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Despesa;
import classe.entidade.SaldoCaixa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eder
 */
public class DespesaFaces {

    private Despesa selectedDespesa;
    private DespesaDAO desDAO = new DespesaDAO();
    private SaldoCaixa selectedSaldoCaixa;
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Despesa> cachedDespesa = null;
    private Date dataIni;
    private Date dataFin;
    private Integer codigo;
    private Double valor;

    /** Creates a new instance of DespesaFaces */
    public DespesaFaces() {
    }

    public void addDespesa() {
        selectedDespesa = new Despesa();
        codigo = 1;
        Date data = new Date();
        selectedDespesa.setDesData(data);
        valor = 0.0;
        sesDAO.setaSession("id", "addDespesa");
    }

    public void finishAddDespesa() {
        desDAO.addDespesa(selectedDespesa);

        selectedSaldoCaixa = new SaldoCaixa();
        Double salCaiVlr = 0.0;
        Date data = new Date();

        salCaiVlr = salCaiDAO.getValor(valor);
        selectedSaldoCaixa.setSalCaiData(data);
        if (selectedDespesa.getDesValor() != valor.doubleValue()) {
            if (codigo != 0) {
                selectedSaldoCaixa.setSalCaiValor(salCaiVlr - selectedDespesa.getDesValor());
            } else {
                valor = valor - selectedDespesa.getDesValor();
                selectedSaldoCaixa.setSalCaiValor(salCaiVlr + valor);
            }
            selectedSaldoCaixa.setSalCaiTabela("Despesa cod:" + selectedDespesa.getDesCodigo());
            salCaiDAO.addSaldoCaixa(selectedSaldoCaixa);
        }
        cachedDespesa = null;
        sesDAO.setaSession("id", "despesa");
    }

    public void updateDespesa() {
        codigo = 0;
        valor = selectedDespesa.getDesValor();
        sesDAO.setaSession("id", "addDespesa");
    }

    public void removeDespesa() {
        desDAO.removeDespesa(selectedDespesa);

        selectedSaldoCaixa = new SaldoCaixa();
        Double salCaiVlr = 0.0;
        Date data = new Date();

        salCaiVlr = salCaiDAO.getValor(valor);
        selectedSaldoCaixa.setSalCaiData(data);
        selectedSaldoCaixa.setSalCaiValor(salCaiVlr + selectedDespesa.getDesValor());
        selectedSaldoCaixa.setSalCaiTabela("Despesa cod:" + selectedDespesa.getDesCodigo() +" Excluir");
        salCaiDAO.addSaldoCaixa(selectedSaldoCaixa);

        cachedDespesa = null;
        sesDAO.setaSession("id", "despesa");
    }
    public void chamaDespesa(){
        sesDAO.setaSession("id", "despesa");
    }
    public List<Despesa> getCachedDespesa() {
        cachedDespesa = null;
        if (cachedDespesa == null) {
            if (dataIni != null && dataFin != null) {
                cachedDespesa = desDAO.getDespesasData(dataIni, dataFin);
            } else {
                cachedDespesa = desDAO.getDespesas();
            }
        }
        return cachedDespesa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Despesa getSelectedDespesa() {
        return selectedDespesa;
    }

    public void setSelectedDespesa(Despesa selectedDespesa) {
        this.selectedDespesa = selectedDespesa;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }
}
