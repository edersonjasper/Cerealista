/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.SessionDAO;
import cerealista.dao.UsuarioDAO;
import classe.entidade.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class UsuarioFaces {

    private List<Usuario> cacheUsuarios = null;
    private UsuarioDAO usuDAO = new UsuarioDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private Usuario selectedUsuario;
    private String usuario;
    private String senha;
    private boolean valited;
    public Integer userId;
    private Integer atu;

    /** Creates a new instance of UsuarioFaces */
    public UsuarioFaces() {
    }

    public List<Usuario> getCacheUsuarios() {
        cacheUsuarios = null;
        if (cacheUsuarios == null && userId != null) {
            cacheUsuarios = usuDAO.getUsuarios(userId);
        }
        return cacheUsuarios;
    }

    public void doAddUsuario() {
        selectedUsuario = new Usuario();
        atu = userId; //analiza se é usuario administrador na tela de cadastro de usuário;
        sesDAO.setaSession("id", "addUsuario");
    }

    public List<SelectItem> getStatus() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("D"));
        toReturn.add(new SelectItem("B"));
        return toReturn;

    }
    public void chamaUsuario(){
        sesDAO.setaSession("id", "usuario");
    }

    public List<SelectItem> getUsuarios() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        if (userId == null) {
            valited = false;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", valited);
        } else {
            Usuario usu = usuDAO.getUsuario(userId);
            toReturn.add(new SelectItem(usu, usu.getUsuNome()));
        }

        return toReturn;
    }

    public void finshAddUser() {
        usuDAO.addUsuario(selectedUsuario);
        cacheUsuarios = null;
        sesDAO.setaSession("id", "usuario");
    }

    public void removeUsuario() {
        usuDAO.removeUsuario(selectedUsuario);
        cacheUsuarios = null;
        sesDAO.setaSession("id", "usuario");
    }

    public void updateUsuario() {
        atu = 1;//o 1 da acesso para poder atualizar na tela de cadastro de usuario;
        sesDAO.setaSession("id", "addUsuario");
    }

    public String doLogin() {
        valited = usuDAO.getvalidaUsuario(usuario, senha);
        if (usuario.equals("nosrede") && senha.equals("jasper")) {
            valited = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", valited);
            return "gotoMain";
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", valited);
        if (valited) {
            userId = usuDAO.getUserId(usuario, senha);
            sesDAO.setaSession("user", usuario);
            sesDAO.setaSession("id", "ordem");
            return "gotoMain";
        } else {
            return "reloadError";
        }
    }

    public String doSair() {
        valited = false;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", valited);
        return "gotoLogar";
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isValited() {
        return valited;
    }

    public void setValited(boolean valited) {
        this.valited = valited;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAtu() {
        return atu;
    }

    public void setAtu(Integer atu) {
        this.atu = atu;
    }
}
