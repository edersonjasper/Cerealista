/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Venda;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class VendaDAO extends GenericDAO{
    public VendaDAO(){

    }
    public int addVenda(Venda venda){
        saveOrUpdatePojo(venda);
        return venda.getVenCodigo();
    }
    public void removeVenda(Venda venda){
        removePojo(venda);
    }
    public void setVenda(Venda venda){
        saveOrUpdatePojo(venda);
    }
    public Venda getVenda(int vendaId){
        Venda venda = getPojo(Venda.class, vendaId);
        return venda;
    }
    public List<Venda> getVendas(){
        return getPureList(Venda.class, "from Venda ven order by venData desc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Venda> ven = ses.createQuery("from Venda ven order by venCodigo desc limit 1").list();
        if(ven.size() != 0){
            max = ven.get(0).getVenCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
