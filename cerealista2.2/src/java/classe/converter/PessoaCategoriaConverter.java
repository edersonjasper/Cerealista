/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.PessoaCategoriaDAO;
import classe.entidade.PessoaCategoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class PessoaCategoriaConverter implements Converter {

    private PessoaCategoriaDAO pesCatDAO = new PessoaCategoriaDAO();

    public PessoaCategoriaConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return pesCatDAO.getPessoaCategoria(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        PessoaCategoria pesCat = (PessoaCategoria) arg2;
        return String.valueOf(pesCat.getPesCatCodigo());
    }
}
