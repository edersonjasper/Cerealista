/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ederson
 */
public class SessionDAO {

    private HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public void setaSession(String atributo, String valor) {
        session.setAttribute(atributo, valor);
    }
    public void setaSession(String atributo, Integer valor) {
        session.setAttribute(atributo, valor);
    }
}
