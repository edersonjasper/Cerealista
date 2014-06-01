/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.CidadeDAO;
import classe.entidade.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class CidadeConverter implements Converter {

    private CidadeDAO cidDAO = new CidadeDAO();

    public CidadeConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return cidDAO.getCidade(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Cidade cid = (Cidade) arg2;
        return String.valueOf(cid.getCidCodigo());
    }
}
