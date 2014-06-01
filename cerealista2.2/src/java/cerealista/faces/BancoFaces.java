/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.BancoDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Banco;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */

public class BancoFaces {

    private Banco selectedBanco;
    private BancoDAO banDAO = new BancoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Banco> cachedBanco = null;
    /** Creates a new instance of BancoFaces */
    public BancoFaces() {
    }

    public void addBanco(){
        selectedBanco = new Banco();
        sesDAO.setaSession("id", "addBanco");
    }
    public void finishAddBanco(){
        banDAO.addBanco(selectedBanco);
        cachedBanco = null;

        sesDAO.setaSession("id", "banco");
    }
    public void updateBanco(){
        sesDAO.setaSession("id", "addBanco");
    }
    public void removeBanco(){
        banDAO.removeBanco(selectedBanco);
        cachedBanco = null;
        sesDAO.setaSession("id", "banco");
    }
    public void chamaBanco(){
        sesDAO.setaSession("id", "banco");
    }
    public List<Banco> getCachedBanco() {
        if(cachedBanco == null){
            cachedBanco = banDAO.getBancos();
        }
        return cachedBanco;
    }
       public List<SelectItem> getBancos(){
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for(Banco ban : banDAO.getBancos()){
            toReturn.add(new SelectItem(ban,ban.getBanNome()));
        }
        return toReturn;
    }

    public Banco getSelectedBanco() {
        return selectedBanco;
    }

    public void setSelectedBanco(Banco selectedBanco) {
        this.selectedBanco = selectedBanco;
    }


}
