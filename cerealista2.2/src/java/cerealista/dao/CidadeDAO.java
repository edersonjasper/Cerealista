/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Cidade;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class CidadeDAO extends GenericDAO{

    public CidadeDAO(){

    }
     public int addCidade(Cidade cidade){
        saveOrUpdatePojo(cidade);
        return cidade.getCidCodigo();
    }
    public void removeCidade(Cidade cidade){
        removePojo(cidade);
    }
    public void setCidade(Cidade cidade){
        saveOrUpdatePojo(cidade);
    }
    public Cidade getCidade(int cidadeId){
        Cidade cidade = getPojo(Cidade.class, cidadeId);
        return cidade;
    }
    public List<Cidade> getCidades(){
        return getPureList(Cidade.class, "from Cidade cid order by cidNome asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Cidade> cid = ses.createQuery("from Cidade cid order by cidCodigo desc limit 1").list();
        if(cid.size() != 0){
            max = cid.get(0).getCidCodigo() +1;
            return max;
        }
        max = 1;
        return max;
    }
}
