/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.CategoriaDAO;
import classe.entidade.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class CategoriaConverter implements Converter {

    private CategoriaDAO catDAO = new CategoriaDAO();

    public CategoriaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return catDAO.getCategoria(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Categoria cat = (Categoria) arg2;
        return String.valueOf(cat.getCatCodigo());
    }
}
