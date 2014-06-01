/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.PagamentoOrdem;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class PagamentoOrdemDAO extends GenericDAO{

    public PagamentoOrdemDAO(){

    }
    public int addPagamentoOrdem(PagamentoOrdem pagOrd){
        saveOrUpdatePojo(pagOrd);
        return pagOrd.getPagOrdCodigo();
    }
    public void removePagamentoOrdem(PagamentoOrdem pagOrd){
        removePojo(pagOrd);
    }
    public void setPagamentoOrdem(PagamentoOrdem pagOrd){
        saveOrUpdatePojo(pagOrd);
    }
    public PagamentoOrdem getPagamentoOrdem(int pagOrdId){
        PagamentoOrdem pagOrd = getPojo(PagamentoOrdem.class, pagOrdId);
        return pagOrd;
    }
    public List<PagamentoOrdem> getPagamentoOrdems(){
        return getPureList(PagamentoOrdem.class, "from PagamentoOrdem pagOrd");
    }

    public List<PagamentoOrdem> getPagamentoOrdemsOrd(int ordId){
        return getPureList(PagamentoOrdem.class, "from PagamentoOrdem pagOrd where ordCodigo ="+ordId+"order by pagOrdValorAcumulado desc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<PagamentoOrdem> pagOrd = ses.createQuery("from PagamentoOrdem pagOrd order by pagOrdCodigo desc limit 1").list();
        if(pagOrd.size() != 0){
            max = pagOrd.get(0).getPagOrdCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
    public Double getAcumulado(Integer ordID){
        Double acumulado = 0.0;
        Session ses = getSession();
        List<PagamentoOrdem> pagAcu = ses.createQuery("from PagamentoOrdem pagOrd where ordCodigo ="+ordID+"order by pagOrdCodigo desc").list();
        if(pagAcu.size() != 0){
            acumulado = pagAcu.get(0).getPagOrdValorAcumulado();
        }
        return acumulado;
    }

}
