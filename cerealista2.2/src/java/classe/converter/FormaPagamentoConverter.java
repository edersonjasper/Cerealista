/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.FormaPagamentoDAO;
import classe.entidade.FormaPagamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class FormaPagamentoConverter implements Converter {

    private FormaPagamentoDAO forPagDAO = new FormaPagamentoDAO();

    public FormaPagamentoConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return forPagDAO.getFormaPagamento(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
      FormaPagamento forPag = (FormaPagamento) arg2;
        return String.valueOf(forPag.getForPagCodigo());
    }
}
