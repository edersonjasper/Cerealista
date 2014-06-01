/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.converter;

import cerealista.dao.VeiculoDAO;
import classe.entidade.Veiculo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ederson
 */
public class VeiculoConverter implements Converter {

    private VeiculoDAO veiDAO = new VeiculoDAO();

    public VeiculoConverter() {
    }

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Integer codigo = Integer.parseInt(arg2);

        return veiDAO.getVeiculo(codigo);

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Veiculo vei = (Veiculo) arg2;
        return String.valueOf(vei.getVeiCodigo());
    }
}
