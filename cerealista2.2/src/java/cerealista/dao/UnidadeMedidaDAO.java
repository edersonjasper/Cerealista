/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.UnidadeMedida;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class UnidadeMedidaDAO extends GenericDAO {

    public UnidadeMedidaDAO() {
    }

    public int addUnidadeMedida(UnidadeMedida uniMed) {
        saveOrUpdatePojo(uniMed);
        return uniMed.getUniCodigo();
    }

    public void removeUnidadeMedida(UnidadeMedida uniMed) {
        removePojo(uniMed);
    }

    public void setUnidadeMedida(UnidadeMedida uniMed) {
        saveOrUpdatePojo(uniMed);
    }

    public UnidadeMedida getUnidadeMedida(int uniMedId) {
        UnidadeMedida uniMed = getPojo(UnidadeMedida.class, uniMedId);
        return uniMed;
    }

    public List<UnidadeMedida> getUnidadeMedidas() {
        return getPureList(UnidadeMedida.class, "from UnidadeMedida uniMed order by uniMedDescricao asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<UnidadeMedida> uniMed = ses.createQuery("from UnidadeMedida uni order by uniMedCodigo desc limit 1").list();
                if(uniMed.size() != 0){
                    max = uniMed.get(0).getUniCodigo()+1;
                    return max;
                }
        max = 1;
        return max;
    }
}
