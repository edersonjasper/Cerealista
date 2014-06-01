/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.CategoriaDespesa;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class CategoriaDespesaDAO extends GenericDAO {

    public CategoriaDespesaDAO() {
    }

    public int addCategoriaDespesa(CategoriaDespesa catDes) {
        saveOrUpdatePojo(catDes);
        return catDes.getCatDesCodigo();
    }

    public void removeCategoriaDespesa(CategoriaDespesa catDes) {
        removePojo(catDes);
    }

    public void setCategoriaDespesa(CategoriaDespesa catDes) {
        saveOrUpdatePojo(catDes);
    }

    public CategoriaDespesa getCategoriaDespesa(int catDesId) {
        CategoriaDespesa catDes = getPojo(CategoriaDespesa.class, catDesId);
        return catDes;
    }

    public List<CategoriaDespesa> getCategoriaDespesas() {
        return getPureList(CategoriaDespesa.class, "from CategoriaDespesa catDes order by catDesDescricao asc");
    }

    public Integer getProximo(Integer max) {
        Session ses = getSession();
        List<CategoriaDespesa> catDes = ses.createQuery("from CategoriaDespesa catDes order by catDesCodigo desc limit 1").list();
        if (catDes.size() != 0) {
            max = catDes.get(0).getCatDesCodigo() + 1;
            return max;
        }
        max = 1;
        return max;
    }
}
