/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Conta;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class ContaDAO extends GenericDAO{

    public ContaDAO(){

    }
     public int addConta(Conta conta){
        saveOrUpdatePojo(conta);
        return conta.getConCodigo();
    }
    public void removeConta(Conta conta){
        removePojo(conta);
    }
    public void setConta(Conta conta){
        saveOrUpdatePojo(conta);
    }
    public List<Conta> getConta(int pesId){
       Session ses = getSession();
       List<Conta> con = ses.createQuery("from Conta con where pesCodigo = "+pesId+"order by conCodigo asc").list();
        return con;
    }
    public List<Conta> getContas(){
        return getPureList(Conta.class, "from Conta con");
    }

    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Conta> con = ses.createQuery("from Conta con order by conCodigo desc limit 1").list();
        if(con.size()!= 0){
            max = con.get(0).getConCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
