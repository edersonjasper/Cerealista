/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO() {
    }

    public int addUsuario(Usuario usuario) {
        saveOrUpdatePojo(usuario);
        return usuario.getUsuCodigo();
    }

    public void removeUsuario(Usuario usuario) {
        removePojo(usuario);
    }

    public void setUsuario(Usuario usuario) {
        saveOrUpdatePojo(usuario);
    }

    public Usuario getUsuario(int usuarioId) {
        Usuario usuario = getPojo(Usuario.class, usuarioId);
        return usuario;
    }

//    public Integer getProximo(Integer max) {
//        Session ses = getSession();
//        List<Usuario> usu = ses.createQuery("from Usuario usu order by usuCodigo desc limit 1").list();
//        if (usu.size() != 0) {
//            max = usu.get(0).getUsuCodigo() + 1;
//            return max;
//        }
//        max = 1;
//        return max;
//    }
    public List<Usuario> getUsuarios(Integer usuId) {
        if (usuId == 1) {
            return getPureList(Usuario.class, "from Usuario usu order by usuNome asc");

        } else {
            return getPureList(Usuario.class, "from Usuario usu where usuCodigo = " + usuId + " order by usuNome asc");

        }
    }

    public Boolean getvalidaUsuario(String usuario, String senha) {
        boolean valid;
        Session ses = getSession();
        Query query = ses.createQuery("from Usuario usu where usu.usuUsuario = :user and usu.usuSenha = :pw and usuStatus = 'D' ");
        query.setString("user", usuario);
        query.setString("pw", senha);
        Usuario usu = (Usuario) query.uniqueResult();
        valid = (usu != null);
        ses.close();
        return valid;
        //return getPureList(Usuario.class, "from Usuario usu where usu.usuUsuario = :1 and usu.usuSenha = :2 and usuStatus = 'D' ", usuario, senha)!= null;
    }

    public Integer getUserId(String usuario, String senha) {
        Session ses = getSession();
        Query query = ses.createQuery("from Usuario usu where usu.usuUsuario = :user and usu.usuSenha = :pw and usuStatus = 'D' ");
        query.setString("user", usuario);
        query.setString("pw", senha);
        Usuario usu = (Usuario) query.uniqueResult();
        Integer userId = usu.getUsuCodigo();
        ses.close();
        return userId;
        //return getPureList(Usuario.class, "from Usuario usu where usu.usuUsuario = :1 and usu.usuSenha = :2 and usuStatus = 'D' ", usuario, senha)!= null;
    }
}
