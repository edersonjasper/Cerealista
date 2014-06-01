/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Quebra;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class QuebraDAO extends GenericDAO{

    public QuebraDAO(){

    }
    public int addQuebra(Quebra quebra){
        saveOrUpdatePojo(quebra);
        return quebra.getQueCodigo();
    }
    public void removeQuebra(Quebra quebra){
        removePojo(quebra);
    }
    public void setQuebra(Quebra quebra){
        saveOrUpdatePojo(quebra);
    }
    public Quebra getQuebra(int quebraId){
        Quebra quebra = getPojo(Quebra.class, quebraId);
        return quebra;
    }
    public List<Quebra> getQuebras(){
        return getPureList(Quebra.class, "from Quebra que order by queData desc");
    }
    public List<Quebra> getQuebraProduto(int proId){
        if(proId == 0){
            return getPureList(Quebra.class, "from Quebra que order by queData desc");
        }
        return getPureList(Quebra.class, "from Quebra que where proCodigo = "+proId+ "order by queData desc");
    }

    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Quebra> que = ses.createQuery("from Quebra que order by queCodigo desc limit 1").list();
        if(que.size() != 0){
            max = que.get(0).getQueCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
