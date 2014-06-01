/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.ProdutoVenda;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class ProdutoVendaDAO extends GenericDAO{

    public ProdutoVendaDAO(){

    }
    public int addProdutoVenda(ProdutoVenda proVen){
        saveOrUpdatePojo(proVen);
        return proVen.getProVenCodigo();
    }
    public void removeProdutoVenda(ProdutoVenda proVen){
        removePojo(proVen);
    }
    public void setProdutoVenda(ProdutoVenda proVen){
        saveOrUpdatePojo(proVen);
    }
    public ProdutoVenda getProdutoVenda(int proVenId){
        ProdutoVenda proVen = getPojo(ProdutoVenda.class, proVenId);
        return proVen;
    }
    public List<ProdutoVenda> getProdutoVendas(){
        return getPureList(ProdutoVenda.class, "from ProdutoVenda proVen order by ven_codigo asc");
    }
    public List<ProdutoVenda> getProdutoVendasVenda(int venID){
        return getPureList(ProdutoVenda.class, "from ProdutoVenda proVen where venCodigo = "+venID+"order by proVenCodigo asc");
    }

    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<ProdutoVenda> proVen = ses.createQuery("from ProdutoVenda proVen order by proVenCodigo desc limit 1").list();
        if(proVen.size() != 0){
            max = proVen.get(0).getProVenCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
    public List<ProdutoVenda> getTotalVenda(Integer venID){
        Session ses = getSession();
        List<ProdutoVenda> toReturn = ses.createQuery("from ProdutoVenda proVen where venCodigo = "+venID) .list();
        return toReturn;
    }
}
