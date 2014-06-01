/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.CaixaDAO;
import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Caixa;
import classe.entidade.SaldoCaixa;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class CaixaFaces {

    private Caixa selectedCaixa;
    private CaixaDAO caiDAO = new CaixaDAO();
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private SaldoCaixa salCai = new SaldoCaixa();
    private List<Caixa> cachedCaixa = null;
    private Integer codigo;
    private Double valor;
    private Double total;
    private Date dataIni = null;
    private Date dataFin = null;
    private String todos = "S";

    /** Creates a new instance of CaixaFaces */
    public CaixaFaces() {
    }

    public void addCaixa() {
        selectedCaixa = new Caixa();
        codigo = 1;
        Date data = new Date();
        selectedCaixa.setCaiData(data);
        valor = 0.0;
        sesDAO.setaSession("id", "addCaixa");
    }

    public void chamaCaixa() {
        sesDAO.setaSession("id", "caixa");
    }

    public void finishAddCaixa() {
        Date data = new Date();
        caiDAO.addCaixa(selectedCaixa);
        Double salCaiVlr = 0.0;
        if (selectedCaixa.getCaiValorDepositado() != valor.doubleValue()) {
            if (codigo == 0) {
                valor = selectedCaixa.getCaiValorDepositado() - valor;
                salCaiVlr = salCaiDAO.getValor(valor);
                salCai.setSalCaiData(data);
                salCai.setSalCaiValor(valor + salCaiVlr);
            } else {
                salCaiVlr = salCaiDAO.getValor(valor);
                salCai.setSalCaiData(data);
                salCai.setSalCaiValor(salCaiVlr + selectedCaixa.getCaiValorDepositado());
            }
            salCai.setSalCaiTabela("Depósito cod:" + selectedCaixa.getCaiCodigo());
            salCaiDAO.addSaldoCaixa(salCai);
        }
        cachedCaixa = null;
        sesDAO.setaSession("id", "caixa");
    }

    public void updateCaixa() {
        codigo = 0;
        valor = selectedCaixa.getCaiValorDepositado();
        sesDAO.setaSession("id", "addCaixa");
    }

    public void removeCaixa() {
        caiDAO.removeCaixa(selectedCaixa);
        Date data = new Date();
        Double salCaiVlr = 0.0;
        salCaiVlr = salCaiDAO.getValor(valor);
        salCai.setSalCaiData(data);
        salCai.setSalCaiValor(salCaiVlr - selectedCaixa.getCaiValorDepositado());
        salCai.setSalCaiTabela("Depósito cod:" + selectedCaixa.getCaiCodigo() + " Excluido");
        salCaiDAO.addSaldoCaixa(salCai);
        cachedCaixa = null;
        sesDAO.setaSession("id", "caixa");
    }

    public List<Caixa> getCachedCaixa() {
        cachedCaixa = null;
        if ( dataIni == null && dataFin == null) {
            cachedCaixa = caiDAO.getCaixas();
        } else if (dataIni != null && dataFin != null) {
            cachedCaixa = caiDAO.getCaixaDatas(dataIni, dataFin);
        } 
        total = 0.0;
        for (Caixa cai : cachedCaixa) {
            total += cai.getCaiValorDepositado();
        }
        return cachedCaixa;
    }

    public List<SelectItem> getTudo() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("S"));
        toReturn.add(new SelectItem("N"));
        return toReturn;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setSelectedCaixa(Caixa selectedCaixa) {
        this.selectedCaixa = selectedCaixa;
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

    public Caixa getSelectedCaixa() {
        return selectedCaixa;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }


}
