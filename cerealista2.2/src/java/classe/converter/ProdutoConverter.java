/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.ProdutoDAO;
import classe.entidade.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class ProdutoConverter implements Converter {

    private ProdutoDAO proDAO = new ProdutoDAO();

    public ProdutoConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return proDAO.getProduto(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Produto pro = (Produto) arg2;
        return String.valueOf(pro.getProCodigo());
    }
}
