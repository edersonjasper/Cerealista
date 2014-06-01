/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.PagamentoFuncionario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class PagamentoFuncionarioDAO extends GenericDAO {

    public PagamentoFuncionarioDAO(){

    }
     public int addPagamentoFuncionario(PagamentoFuncionario pagFun){
        saveOrUpdatePojo(pagFun);
        return pagFun.getPagFunCodigo();
    }
    public void removePagamentoFuncionario(PagamentoFuncionario pagFun){
        removePojo(pagFun);
    }
    public void setPagamentoFuncionario(PagamentoFuncionario pagFun){
        saveOrUpdatePojo(pagFun);
    }
    public PagamentoFuncionario getPagamentoFuncionario(int pagFunId){
        PagamentoFuncionario pagFun = getPojo(PagamentoFuncionario.class, pagFunId);
        return pagFun;
    }
    public List<PagamentoFuncionario> getPagamentoFuncionarios(Integer pesCatId, Date dataInicial, Date dataFinal){
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        return getPureList(PagamentoFuncionario.class, "from PagamentoFuncionario pagFun " +
                "where pesCatCodigo ="+pesCatId+
                "and pagFunData >= '"+ft.format(dataInicial)+
                "' and pagFunData <= '"+ft.format(dataFinal)+
                "' order by pagFunData desc");
    }
    public List<PagamentoFuncionario> getPagamentoFuncionariosIdFun(Integer pesCatId){
        return getPureList(PagamentoFuncionario.class, "from PagamentoFuncionario pagFun " +
                "where pesCatCodigo ="+pesCatId+
                " order by pagFunData desc");
    }
    public List<PagamentoFuncionario> getPagamentoFuncionariosTodos(){
        return getPureList(PagamentoFuncionario.class, "from PagamentoFuncionario pagFun order by pagFunCodigo desc");
    }

    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<PagamentoFuncionario> pagFun = ses.createQuery("from PagamentoFuncionario pagFun order by pagFunCodigo desc limit 1").list();
        if(pagFun.size() != 0){
            max = pagFun.get(0).getPagFunCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }

}
