/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Banco;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class BancoDAO extends GenericDAO{

    public int addBanco (Banco banco){
        saveOrUpdatePojo(banco);
        return banco.getBanCodigo();
    }
    public void removeBanco(Banco banco){
        removePojo(banco);
    }
    public void setBanco(Banco banco){
        saveOrUpdatePojo(banco);
    }
    public Banco getBanco(int bancoId){
        Banco banco = getPojo(Banco.class, bancoId);
        return banco;
    }
    public List<Banco> getBancos(){
        return getPureList(Banco.class, "from Banco banco order by banNome asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Banco> ban = ses.createQuery("from Banco banco order by banCodigo desc limit 1").list();
        if(ban.size() != 0){
            max = ban.get(0).getBanCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
