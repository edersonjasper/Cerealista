/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Veiculo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class VeiculoDAO extends GenericDAO{

    public VeiculoDAO(){

    }
    public int addVeiculo(Veiculo veiculo){
        saveOrUpdatePojo(veiculo);
        return veiculo.getVeiCodigo();
    }
    public void removeVeiculo(Veiculo veiculo){
        removePojo(veiculo);
    }
    public void setVeiculo(Veiculo veiculo){
        saveOrUpdatePojo(veiculo);
    }
    public Veiculo getVeiculo(int veiculoId){
        Veiculo veiculo = getPojo(Veiculo.class, veiculoId);
        return veiculo;
    }
    public List<Veiculo> getVeiculos(){
        return getPureList(Veiculo.class, "from Veiculo vei order by veiPlaca asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Veiculo> vei = ses.createQuery("from Veiculo vei order by veiCodigo desc limit 1").list();
        if(vei.size() != 0){
            max = vei.get(0).getVeiCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }

}
