/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.converter;

import cerealista.dao.UsuarioDAO;
import classe.entidade.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Eder
 */
public class UsuarioConverter implements Converter{


    private UsuarioDAO usuDAO = new UsuarioDAO();
    
    public UsuarioConverter(){
        
    }
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer codigo = Integer.parseInt(value);
        return usuDAO.getUsuario(codigo);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Usuario usu = (Usuario)value;
        return String.valueOf(usu.getUsuCodigo());
    }

}
