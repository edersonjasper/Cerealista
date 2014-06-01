/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.SessionDAO;
import cerealista.dao.TipoTelefoneDAO;
import classe.entidade.TipoTelefone;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */

public class TipoTelefoneFaces {
    private TipoTelefoneDAO tipTelDAO = new TipoTelefoneDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private TipoTelefone selectedTipoTelefone;
    private List<TipoTelefone> cacheTipoTelefone = null;
    /** Creates a new instance of TipoTelefoneFaces */
    public TipoTelefoneFaces() {
    }

    public List<TipoTelefone> getCacheTipoTelefone() {
        if(cacheTipoTelefone == null){
            cacheTipoTelefone = tipTelDAO.getTipoTelefones();
        }
        return cacheTipoTelefone;
    }
    public void addTipoTelefone(){
        selectedTipoTelefone = new TipoTelefone();
        sesDAO.setaSession("id", "addTipoTelefone");
    }
    public void finishAddTipoTelefone(){
        tipTelDAO.addTipoTelefone(selectedTipoTelefone);
        cacheTipoTelefone = null;
        sesDAO.setaSession("id", "tipoTelefone");
    }
    public void updateTipoTelefone(){
        sesDAO.setaSession("id", "addTipoTelefone");
    }
    public void removeTipoTelefone(){
        tipTelDAO.removeTipoTelefone(selectedTipoTelefone);
        cacheTipoTelefone = null;
        sesDAO.setaSession("id", "tipoTelefone");
    }
    public void chamaTipoTelefone(){
        sesDAO.setaSession("id", "tipoTelefone");
    }
    public List<SelectItem> getTipoTelefones(){
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for(TipoTelefone tipTel : tipTelDAO.getTipoTelefones()){
            toReturn.add(new SelectItem(tipTel,tipTel.getTipDescricao()));
        }
        return toReturn;
    }

    public TipoTelefone getSelectedTipoTelefone() {
        return selectedTipoTelefone;
    }

    public void setSelectedTipoTelefone(TipoTelefone selectedTipoTelefone) {
        this.selectedTipoTelefone = selectedTipoTelefone;
    }

   
}
