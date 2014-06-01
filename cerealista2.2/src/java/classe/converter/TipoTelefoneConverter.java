/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.TipoTelefoneDAO;
import classe.entidade.TipoTelefone;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class TipoTelefoneConverter implements Converter {

    private TipoTelefoneDAO tipTelDAO = new TipoTelefoneDAO();

    public TipoTelefoneConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return tipTelDAO.getTipoTelefone(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        TipoTelefone tipTel = (TipoTelefone) arg2;
        return String.valueOf(tipTel.getTipCodigo());
    }
}
