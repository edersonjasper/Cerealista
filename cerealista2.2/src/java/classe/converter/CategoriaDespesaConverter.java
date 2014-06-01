/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.CategoriaDespesaDAO;
import classe.entidade.CategoriaDespesa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class CategoriaDespesaConverter implements Converter {

    private CategoriaDespesaDAO catDesDAO = new CategoriaDespesaDAO();

    public CategoriaDespesaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return catDesDAO.getCategoriaDespesa(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        CategoriaDespesa catDes = (CategoriaDespesa) arg2;
        return String.valueOf(catDes.getCatDesCodigo());
    }
}
