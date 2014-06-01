/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.OrdemDAO;
import classe.entidade.Ordem;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class OrdemConverter implements Converter {

    private OrdemDAO ordDAO = new OrdemDAO();

    public OrdemConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return ordDAO.getOrdem(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Ordem ord = (Ordem) arg2;
        return String.valueOf(ord.getOrdCodigo());
    }
}
