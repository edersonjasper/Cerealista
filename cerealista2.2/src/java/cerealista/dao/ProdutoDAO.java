/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Produto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class ProdutoDAO extends GenericDAO{

    public ProdutoDAO(){

    }
    public int addProduto(Produto produto){
        saveOrUpdatePojo(produto);
        return produto.getProCodigo();
    }


    public void removeProduto(Produto produto){
        removePojo(produto);
    }
    public void setProduto(Produto produto){
        saveOrUpdatePojo(produto);
    }
    public Produto getProduto(int produtoId){
        Produto produto = getPojo(Produto.class, produtoId);
        return produto;
    }
    public List<Produto> getProdutos(){
        return getPureList(Produto.class, "from Produto pro order by proNome asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Produto> pro = ses.createQuery("from Produto pro order by proCodigo desc limit 1").list();
        if(pro.size() != 0){
            max = pro.get(0).getProCodigo() + 1;
            return max;
        }
        max = 1;
        return max;
    }

}
