/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.SaldoCaixaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.SaldoCaixa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eder
 */

public class SaldoCaixaFaces {
    private SaldoCaixa selectedSaldoCaixa;
    private List<SaldoCaixa> cachedSaldoCaixa = null;
    private SaldoCaixaDAO salCaiDAO = new SaldoCaixaDAO();
    private SessionDAO sesDAO = new SessionDAO();

    /** Creates a new instance of SaldoCaixaFaces */
    public SaldoCaixaFaces() {
    }

    public String addSaldoCaixa(){
        // não mostra tela alguma por que o sistema faz os calculos sozinho;
        Date data = new Date();
        selectedSaldoCaixa.setSalCaiData(data);
        salCaiDAO.addSaldoCaixa(selectedSaldoCaixa);
        return "";
    }
    public void removeSaldoCaixa(){
        salCaiDAO.removeSadoCaixa(selectedSaldoCaixa);
        sesDAO.setaSession("id", "saldoCaixa");
    }
    public List<SaldoCaixa> getCachedSaldoCaixa() {
        cachedSaldoCaixa = salCaiDAO.getSaldoCaixas();
        return cachedSaldoCaixa;
    }

    public SaldoCaixa getSelectedSaldoCaixa() {
        return selectedSaldoCaixa;
    }

    public void setSelectedSaldoCaixa(SaldoCaixa selectedSaldoCaixa) {
        this.selectedSaldoCaixa = selectedSaldoCaixa;
    }


}
