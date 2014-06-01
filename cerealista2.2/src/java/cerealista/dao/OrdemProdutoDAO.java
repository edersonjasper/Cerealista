/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.OrdemProduto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class OrdemProdutoDAO extends GenericDAO {

    private OrdemDAO ordDAO = new OrdemDAO();

    public OrdemProdutoDAO() {
    }

    public int addOrdemProduto(OrdemProduto ordPro) {
        saveOrUpdatePojo(ordPro);
        return ordPro.getOrdProCodigo();
    }

    public void removeOrdemProduto(OrdemProduto ordPro) {
        removePojo(ordPro);
    }

    public void setOrdemProduto(OrdemProduto ordPro) {
        saveOrUpdatePojo(ordPro);
    }

    public OrdemProduto getOrdemProduto(int ordProId) {
        OrdemProduto ordPro = getPojo(OrdemProduto.class, ordProId);
        return ordPro;
    }

    public List<OrdemProduto> getOrdemProdutos(int ordId) {
        return getPureList(OrdemProduto.class, "from OrdemProduto ordPro where ordCodigo = " + ordId + "order by proCodigo.proNome asc");
    }
    public List<OrdemProduto> getOrdemProdutos() {
        return getPureList(OrdemProduto.class, "from OrdemProduto ordPro order by proCodigo.proNome asc");
    }

    public Integer getProximo(Integer max) {
        Session ses = getSession();
        List<OrdemProduto> ordPro = ses.createQuery("from OrdemProduto ordPro order by ordProCodigo desc limit 1").list();
        if (ordPro.size() != 0) {
            max = ordPro.get(0).getOrdProCodigo() + 1;
            return max;
        }
        max = 1;
        return max;
    }

    public List<OrdemProduto> getValorTotal(Integer ordId) {
       
        Session ses = getSession();
        List<OrdemProduto> toReturn = ses.createQuery("from OrdemProduto ordPro where ordCodigo =" + ordId).list();
      
        return toReturn;
    }
}
