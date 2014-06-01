/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.CategoriaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Categoria;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */

public class CategoriaFaces {

    private Categoria selectedCategoria;
    private CategoriaDAO catDAO = new CategoriaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Categoria> cachedCategoria = null;
    /** Creates a new instance of CategoriaFaces */
    public CategoriaFaces() {
    }

    public void addCategoria(){
        selectedCategoria = new Categoria();
        sesDAO.setaSession("id", "addCategoria");
    }
    public void finishAddCategoria(){
        catDAO.addCategoria(selectedCategoria);
        cachedCategoria = null;
        sesDAO.setaSession("id", "categoria");
    }
    public void updateCategoria(){
        sesDAO.setaSession("id", "addCategoria");
    }
    public void removeCategoria(){
        catDAO.removeCategoria(selectedCategoria);
        cachedCategoria = null;
        sesDAO.setaSession("id", "categoria");
    }
    public void chamaCategoria(){
        sesDAO.setaSession("id", "categoria");
    }
    public List<Categoria> getCachedCategoria() {

        if(cachedCategoria == null){
            cachedCategoria = catDAO.getCategorias();
        }
        return cachedCategoria;
    }

    public List<SelectItem> getCategoria(){
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for(Categoria cat : catDAO.getCategorias()){
            toReturn.add(new SelectItem(cat, cat.getCatDescricao()));
        }
        return toReturn;
    }
    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }


}
