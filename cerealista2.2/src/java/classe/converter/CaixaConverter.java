/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.CaixaDAO;
import classe.entidade.Caixa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class CaixaConverter implements Converter {

    private CaixaDAO caiDAO = new CaixaDAO();

    public CaixaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return caiDAO.getCaixa(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Caixa cai = (Caixa) arg2;
        return String.valueOf(cai.getCaiCodigo());
    }
}
