/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.FormaPagamentoDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.FormaPagamento;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */

public class FormaPagamentoFaces {
    private FormaPagamento selectedFormaPagamento;
    private FormaPagamentoDAO forPagDAO = new FormaPagamentoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<FormaPagamento> cachedFormaPagamento = null;

    /** Creates a new instance of FormaPagamentoFaces */
    public FormaPagamentoFaces() {
    }

    public void addFormaPagamento(){
        selectedFormaPagamento = new FormaPagamento();
        sesDAO.setaSession("id", "addFormaPagamento");
    }
    public void finishFormaPagamento(){
        forPagDAO.addFormaPagamento(selectedFormaPagamento);
        cachedFormaPagamento = null;
        sesDAO.setaSession("id", "formaPagamento");
    }
    public void updateFormaPagamento(){
        sesDAO.setaSession("id", "addFormaPagamento");
    }
    public void removeFormaPagamento(){
        forPagDAO.removeFormaPagamento(selectedFormaPagamento);
        cachedFormaPagamento = null;
        sesDAO.setaSession("id", "formaPagamento");
    }
    public void chamaFormaPagamento(){
        sesDAO.setaSession("id", "formaPagamento");
    }
    public List<FormaPagamento> getCachedFormaPagamento() {
        if(cachedFormaPagamento == null){
            cachedFormaPagamento = forPagDAO.getFormaPagamentos();
        }
        return cachedFormaPagamento;
    }

    public List<SelectItem> getFormaPagamento() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (FormaPagamento forPag : forPagDAO.getFormaPagamentos()) {
            toReturn.add(new SelectItem(forPag, forPag.getForPagDescricao()));
        }
        return toReturn;
    }

    public FormaPagamento getSelectedFormaPagamento() {
        return selectedFormaPagamento;
    }

    public void setSelectedFormaPagamento(FormaPagamento selectedFormaPagamento) {
        this.selectedFormaPagamento = selectedFormaPagamento;
    }


}
