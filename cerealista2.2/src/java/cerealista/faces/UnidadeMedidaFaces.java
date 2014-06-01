package cerealista.faces;

import cerealista.dao.SessionDAO;
import cerealista.dao.UnidadeMedidaDAO;
import classe.entidade.UnidadeMedida;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eder
 */
public class UnidadeMedidaFaces {

    private UnidadeMedida selectedUniMed;
    private UnidadeMedidaDAO uniMedDAO = new UnidadeMedidaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<UnidadeMedida> cachedUniMed = null;

    /** Creates a new instance of UnidadeMedidaFaces */
    public UnidadeMedidaFaces() {
    }

    public void addUnidadeMedida() {
        selectedUniMed = new UnidadeMedida();
        sesDAO.setaSession("id", "addUnidadeMedida");
    }

    public void finishAddUnidadeMedida() {
        uniMedDAO.addUnidadeMedida(selectedUniMed);
        cachedUniMed = null;
        sesDAO.setaSession("id", "unidadeMedida");
    }

    public void updateUnidadeMedida() {
        sesDAO.setaSession("id", "addUnidadeMedida");
    }

    public void removeUnidadeMedida() {
        uniMedDAO.removeUnidadeMedida(selectedUniMed);
        cachedUniMed = null;
        sesDAO.setaSession("id", "unidadeMedida");
    }
    public void chamaUnidadeMedida(){
        sesDAO.setaSession("id", "unidadeMedida");
    }

    public List<UnidadeMedida> getCachedUniMed() {
        if (cachedUniMed == null) {
            cachedUniMed = uniMedDAO.getUnidadeMedidas();
        }
        return cachedUniMed;
    }

    public List<SelectItem> getUnidadeMedida() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (UnidadeMedida uniMed : uniMedDAO.getUnidadeMedidas()) {
            toReturn.add(new SelectItem(uniMed, uniMed.getUniDescricao()));
        }
        return toReturn;
    }

    public UnidadeMedida getSelectedUniMed() {
        return selectedUniMed;
    }

    public void setSelectedUniMed(UnidadeMedida selectedUniMed) {
        this.selectedUniMed = selectedUniMed;
    }
}
