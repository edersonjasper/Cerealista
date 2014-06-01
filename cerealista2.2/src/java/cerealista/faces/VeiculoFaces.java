/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.SessionDAO;
import cerealista.dao.VeiculoDAO;
import classe.entidade.Veiculo;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */

public class VeiculoFaces {

    private Veiculo selectedVeiculo;
    private VeiculoDAO veiDAO = new VeiculoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Veiculo> cachedVeiculo = null;
    /** Creates a new instance of VeiculoFaces */
    public VeiculoFaces() {
    }

    public void addVeiculo(){
        selectedVeiculo = new Veiculo();
        sesDAO.setaSession("id", "addVeiculo");
    }
    public void finishAddVeiculo(){
        veiDAO.addVeiculo(selectedVeiculo);
        cachedVeiculo = null;
        sesDAO.setaSession("id", "veiculo");
    }
    public void updateVeiculo(){
        sesDAO.setaSession("id", "addVeiculo");
    }
    public void removeVeiculo(){
        veiDAO.removeVeiculo(selectedVeiculo);
        cachedVeiculo = null;
        sesDAO.setaSession("id", "veiculo");
    }
    public void chamaVeiculo(){
        sesDAO.setaSession("id", "veiculo");
    }
    public List<Veiculo> getCachedVeiculo() {
        if(cachedVeiculo == null){
            cachedVeiculo = veiDAO.getVeiculos();
        }
        return cachedVeiculo;
    }


    public List<SelectItem> getVeiculo() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (Veiculo vei : veiDAO.getVeiculos()) {
            toReturn.add(new SelectItem(vei, vei.getVeiPlaca() + " - " + vei.getVeiVeiculo()));
        }
        return toReturn;
    }
   

    public Veiculo getSelectedVeiculo() {
        return selectedVeiculo;
    }


    public void setSelectedVeiculo(Veiculo selectedVeiculo) {
        this.selectedVeiculo = selectedVeiculo;
    }


}
