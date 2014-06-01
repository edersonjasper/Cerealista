/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.FormaPagamento;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class FormaPagamentoDAO extends GenericDAO {

    public FormaPagamentoDAO() {
    }

    public int addFormaPagamento(FormaPagamento formaPagamento) {
        saveOrUpdatePojo(formaPagamento);
        return formaPagamento.getForPagCodigo();
    }

    public void removeFormaPagamento(FormaPagamento formaPagamento) {
        removePojo(formaPagamento);
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        saveOrUpdatePojo(formaPagamento);
    }

    public FormaPagamento getFormaPagamento(int formaPagamentoId) {
        FormaPagamento formaPagamento = getPojo(FormaPagamento.class, formaPagamentoId);
        return formaPagamento;
    }

    public List<FormaPagamento> getFormaPagamentos() {
        return getPureList(FormaPagamento.class, "from FormaPagamento forPag order by forPagDescricao");
    }

    public Integer getProximo(Integer max) {
        Session ses = getSession();
        List<FormaPagamento> forPag = ses.createQuery("from FormaPagamento forPag order by forPagCodigo desc limit 1").list();
        if (forPag.size() != 0) {
            max = forPag.get(0).getForPagCodigo() + 1;
            return max;
        }
        max = 1;
        return max;
    }
}
