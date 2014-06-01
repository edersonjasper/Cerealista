/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.SaldoCaixa;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class SaldoCaixaDAO extends GenericDAO{
    public SaldoCaixaDAO(){

    }
    public int addSaldoCaixa(SaldoCaixa salCai){
        saveOrUpdatePojo(salCai);
        return salCai.getSalCaiCodigo();
    }
    public void removeSadoCaixa(SaldoCaixa salCai){
        removePojo(salCai);
    }
    public void setSaldoCaixa(SaldoCaixa salCai){
        saveOrUpdatePojo(salCai);
    }
    public SaldoCaixa getSaldoCaixa(int salCaiId){
        SaldoCaixa salCai = getPojo(SaldoCaixa.class, salCaiId);
        return salCai;
    }
    public List<SaldoCaixa> getSaldoCaixas(){
        return getPureList(SaldoCaixa.class, "from SaldoCaixa salCai order by salCaiCodigo desc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<SaldoCaixa> salCai = ses.createQuery("from SaldoCaixa salCai order by salCaiCodigo desc limit 1").list();
        if(salCai.size() != 0){
            max = salCai.get(0).getSalCaiCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }
    public Double getValor(Double valor){
        Session ses = getSession();
        List<SaldoCaixa> salCai = ses.createQuery("from SaldoCaixa salCai order by salCaiCodigo desc limit 1").list();
        if(salCai.size() != 0){
            valor = salCai.get(0).getSalCaiValor();
            return valor;
        }
        valor = 0.0;
        return valor;
    }

}
