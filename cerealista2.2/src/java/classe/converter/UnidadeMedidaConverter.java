/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.UnidadeMedidaDAO;
import classe.entidade.UnidadeMedida;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class UnidadeMedidaConverter implements Converter {

    private UnidadeMedidaDAO uniMedDAO = new UnidadeMedidaDAO();

    public UnidadeMedidaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return uniMedDAO.getUnidadeMedida(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        UnidadeMedida uniMed = (UnidadeMedida) arg2;
        return String.valueOf(uniMed.getUniCodigo());
    }
}
