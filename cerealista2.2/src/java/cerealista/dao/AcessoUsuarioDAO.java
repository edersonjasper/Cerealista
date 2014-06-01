/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Acesso;
import classe.entidade.AcessoUsuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class AcessoUsuarioDAO extends GenericDAO{

    public AcessoUsuarioDAO() {
    }
     public int addAcessoUsuario(AcessoUsuario aceUsu){
        saveOrUpdatePojo(aceUsu);
        return aceUsu.getAceUsuCodigo();
    }
    public void removeAcessoUsuario(AcessoUsuario aceUsu){
        removePojo(aceUsu);
    }
    public void setAcessoUsuario(AcessoUsuario aceUsu){
        saveOrUpdatePojo(aceUsu);
    }
    public AcessoUsuario getAcessoUsuario(int aceUsuId){
        AcessoUsuario aceUsu = getPojo(AcessoUsuario.class, aceUsuId);
        return aceUsu;
    }
    public List<Acesso> getAcessoUsuarios(){
        return getPureList(Acesso.class, "from AcessoUsuario ace order by usuCodigo asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<AcessoUsuario> aceUsu = ses.createQuery("from AcessoUsuario aceUsu order by aceUsuCodigo desc limit 1").list();
        if(aceUsu.size() != 0){
            max = aceUsu.get(0).getAceUsuCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
