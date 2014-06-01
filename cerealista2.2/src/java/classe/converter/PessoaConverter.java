/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.PessoaDAO;
import classe.entidade.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class PessoaConverter implements Converter {

    private PessoaDAO pesDAO = new PessoaDAO();

    public PessoaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return pesDAO.getPessoa(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Pessoa pes = (Pessoa) arg2;
        return String.valueOf(pes.getPesCodigo());
    }
}
