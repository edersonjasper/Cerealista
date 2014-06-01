/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.TipoTelefone;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class TipoTelefoneDAO extends GenericDAO{

    public TipoTelefoneDAO(){

    }
     public int addTipoTelefone(TipoTelefone tipTel){
        saveOrUpdatePojo(tipTel);
        return tipTel.getTipCodigo();
    }
    public void removeTipoTelefone(TipoTelefone tipTel){
        removePojo(tipTel);
    }
    public void setTipoTelefone(TipoTelefone tipTel){
        saveOrUpdatePojo(tipTel);
    }
    public TipoTelefone getTipoTelefone(int tipTelId){
        TipoTelefone tipTel = getPojo(TipoTelefone.class, tipTelId);
        return tipTel;
    }
    public List<TipoTelefone> getTipoTelefones(){
        return getPureList(TipoTelefone.class, "from TipoTelefone tipTel order by tipDescricao asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<TipoTelefone> tipTel = ses.createQuery("from TipoTelefone tipTel order by tipCodigo desc limit 1").list();
        if(tipTel.size() != 0){
            max = tipTel.get(0).getTipCodigo()+1;
            return max;
        }
        max = 1;
        return max;

    }

}
