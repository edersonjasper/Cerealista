/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Caixa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class CaixaDAO extends GenericDAO{

    public CaixaDAO(){

    }
    public int addCaixa(Caixa caixa){
        saveOrUpdatePojo(caixa);
        return caixa.getCaiCodigo();
    }
    public void removeCaixa(Caixa caixa){
        removePojo(caixa);
    }
    public void setCaixa(Caixa caixa){
        saveOrUpdatePojo(caixa);
    }
    public Caixa getCaixa(int caixaId){
        Caixa caixa = getPojo(Caixa.class, caixaId);
        return caixa;
    }
    public List<Caixa> getCaixas(){
        return getPureList(Caixa.class, "from Caixa cai order by caiCodigo desc");
    }
    public List<Caixa> getCaixaDatas(Integer pesCatId, Date dataInicial, Date dataFinal){
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        return getPureList(Caixa.class, "from Caixa cai " +
                "where pesCatCodigo ="+pesCatId+
                " and caiData >= '"+ft.format(dataInicial)+
                "' and caiData <= '"+ft.format(dataFinal)+
                "' order by caiCodigo desc");
    }
    public List<Caixa> getCaixaDatas(Integer pesCatId){
        return getPureList(Caixa.class, "from Caixa cai " +
                "where pesCatCodigo ="+pesCatId+
                " order by caiCodigo desc");
    }
    public List<Caixa> getCaixaDatas(Date dataInicial, Date dataFinal){
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        return getPureList(Caixa.class, "from Caixa cai " +
                "where caiData >= '"+ft.format(dataInicial)+
                "' and caiData <= '"+ft.format(dataFinal)+
                "' order by caiCodigo desc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Caixa> cai = ses.createQuery("from Caixa cai order by caiCodigo desc limit 1").list();
        if(cai.size() != 0){
            max = cai.get(0).getCaiCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
}
