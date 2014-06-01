/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Acesso;
import java.util.List;

/**
 *
 * @author Eder
 */
public class AcessoDAO extends GenericDAO{

    public AcessoDAO() {
    }
     public int addAcesso(Acesso acesso){
        saveOrUpdatePojo(acesso);
        return acesso.getAceCodigo();
    }
    public void removeAcesso(Acesso acesso){
        removePojo(acesso);
    }
    public void setAcesso(Acesso acesso){
        saveOrUpdatePojo(acesso);
    }
    public Acesso getAcesso(int acessoId){
        Acesso acesso = getPojo(Acesso.class, acessoId);
        return acesso;
    }
    public List<Acesso> getAcessos(){
        return getPureList(Acesso.class, "from acesso ace");
    }

}
