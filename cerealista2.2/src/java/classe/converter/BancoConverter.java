/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.BancoDAO;
import classe.entidade.Banco;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class BancoConverter implements Converter {

    private BancoDAO banDAO = new BancoDAO();

    public BancoConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return banDAO.getBanco(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Banco ban = (Banco) arg2;
        return String.valueOf(ban.getBanCodigo());
    }
}
