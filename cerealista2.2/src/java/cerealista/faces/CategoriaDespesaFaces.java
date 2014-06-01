/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.CategoriaDespesaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.CategoriaDespesa;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class CategoriaDespesaFaces {

    private CategoriaDespesa selectedCategoriaDespesa;
    private CategoriaDespesaDAO catDesDAO = new CategoriaDespesaDAO();
    public SessionDAO sesDAO = new SessionDAO();
    private List<CategoriaDespesa> cachedCategoriaDespesa = null;

    /** Creates a new instance of CategoriaDespesaFaces */
    public CategoriaDespesaFaces() {
    }

    public void addCategoriaDespesa() {
        selectedCategoriaDespesa = new CategoriaDespesa();
        sesDAO.setaSession("id", "addCategoriaDespesa");
    }
    public void finishAddCategoriaDespesa(){
        catDesDAO.addCategoriaDespesa(selectedCategoriaDespesa);
        cachedCategoriaDespesa = null;
        sesDAO.setaSession("id", "categoriaDespesa");
    }
    public void updateCategoriaDespesa(){
        sesDAO.setaSession("id", "addCategoriaDespesa");
    }
    public void removeCategoriaDespesa(){
        catDesDAO.removeCategoriaDespesa(selectedCategoriaDespesa);
        cachedCategoriaDespesa = null;
        sesDAO.setaSession("id", "categoriaDespesa");
    }
    public void chamaCategoriaDespesa(){
        sesDAO.setaSession("id", "categoriaDespesa");
    }
    public List<SelectItem> getCategoriaDespesa() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (CategoriaDespesa desCat : catDesDAO.getCategoriaDespesas()) {
            toReturn.add(new SelectItem(desCat, desCat.getCatDesDescricao()));
        }
        return toReturn;
    }

    public List<CategoriaDespesa> getCachedCategoriaDespesa() {
        if (cachedCategoriaDespesa == null) {
            cachedCategoriaDespesa = catDesDAO.getCategoriaDespesas();
        }
        return cachedCategoriaDespesa;
    }


    public CategoriaDespesa getSelectedCategoriaDespesa() {
        return selectedCategoriaDespesa;
    }

    public void setSelectedCategoriaDespesa(CategoriaDespesa selectedCategoriaDespesa) {
        this.selectedCategoriaDespesa = selectedCategoriaDespesa;
    }
}
