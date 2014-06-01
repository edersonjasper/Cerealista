/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Despesa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class DespesaDAO extends GenericDAO{
    
    public DespesaDAO(){
        
    }
    public int addDespesa(Despesa despesa){
        saveOrUpdatePojo(despesa);
        return despesa.getDesCodigo();
    }
    public void removeDespesa(Despesa despesa){
        removePojo(despesa);
    }
    public void setDespesa(Despesa despesa){
        saveOrUpdatePojo(despesa);
    }
    public Despesa getDespesa(int despesaId){
        Despesa despesa = getPojo(Despesa.class, despesaId);
        return despesa;
    }
    public List<Despesa> getDespesas(){
        return getPureList(Despesa.class, "from Despesa des order by desData desc");
    }
    public List<Despesa> getDespesasData(Date dataIni, Date dataFin){
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return getPureList(Despesa.class, "from Despesa des " +
                "where desData >= '"+ft.format(dataIni)+"'"+
                " and desData <= '"+ft.format(dataFin) +"' order by desCodigo desc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Despesa> des = ses.createQuery("from Despesa des order by desCodigo desc limit 1").list();
        if(des.size() != 0){
            max = des.get(0).getDesCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }

}
