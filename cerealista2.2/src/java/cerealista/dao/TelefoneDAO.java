/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Telefone;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class TelefoneDAO extends GenericDAO {

    public TelefoneDAO(){

    }
     public int addTelefone(Telefone telefone){
        saveOrUpdatePojo(telefone);
        return telefone.getTelCodigo();
    }
    public void removeTelefone(Telefone telefone){
        removePojo(telefone);
    }
    public void setTelefone(Telefone telefone){
        saveOrUpdatePojo(telefone);
    }
    public List<Telefone> getTelefone(Integer pesId){
        Session ses = getSession();
        List<Telefone> tel = ses.createQuery("from Telefone tel where pesCodigo = "+ pesId).list();
        return tel;
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Telefone> tel = ses.createQuery("from Telefone tel order by telCodigo desc limit 1").list();
                if(tel.size() != 0){
                    max = tel.get(0).getTelCodigo()+1;
                    return max;
                }
        max = 1;
        return max;
    }
    public List<Telefone> getTelefones(){
        return getPureList(Telefone.class, "from Telefone tel");
    }
}
