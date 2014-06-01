/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.CidadeDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Cidade;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */


public class CidadeFaces {

    private List<Cidade> cacheCidade = null;
    private Cidade selectedCidade;
    private CidadeDAO cidDAO = new CidadeDAO();
    private SessionDAO sesDAO = new SessionDAO();
    /** Creates a new instance of CidadeFaces */
    public CidadeFaces() {
    }



    public List<Cidade> getCacheCidade() {
        if(cacheCidade == null){
            cacheCidade = cidDAO.getCidades();
        }
        return cacheCidade;
    }
    public void addCidade(){
        selectedCidade = new Cidade();       
        sesDAO.setaSession("id", "addCidade");
    }
    public List<SelectItem> getCidades() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (Cidade cid : cidDAO.getCidades()) {
            toReturn.add(new SelectItem(cid, cid.getCidNome()+'-'+cid.getCidUf()));
        }
        return toReturn;
    }
    public void finishAddCidade(){
        cidDAO.addCidade(selectedCidade);
        cacheCidade = null;
        sesDAO.setaSession("id", "cidade");
    }
    public void updateCidade(){
        sesDAO.setaSession("id", "addCidade");
    }
    public void removeCidade(){
        cidDAO.removeCidade(selectedCidade);
        cacheCidade = null;
        sesDAO.setaSession("id", "cidade");
    }
    public void chamaCidade(){
        sesDAO.setaSession("id", "cidade");
    }

    public Cidade getSelectedCidade() {
        return selectedCidade;
    }

    public void setSelectedCidade(Cidade selectedCidade) {
        this.selectedCidade = selectedCidade;
    }

}
