/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.OrdemDAO;
import cerealista.dao.PagamentoOrdemDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Ordem;
import classe.entidade.PagamentoOrdem;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ederson
 */

public class PagamentoOrdemFaces {
    private Ordem selectedOrdem;
    private PagamentoOrdemDAO pagOrdDAO = new PagamentoOrdemDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private PagamentoOrdem selectedPagamentoOrdem;
    private List<PagamentoOrdem> cachedPagamentoOrdem = null;
    private Ordem selectedAuxOrdem;
    private Integer codigo;
    private Double valor;
    private OrdemDAO ordDAO = new OrdemDAO();
    /** Creates a new instance of PagamentoOrdemFaces */
    public PagamentoOrdemFaces() {
    }
      //===============  Pagamento Ordem =======================
    public void addPagamentoOrdem() {
        selectedPagamentoOrdem = new PagamentoOrdem();
        codigo = 1;
        Date dt = new Date();
        selectedPagamentoOrdem.setPagOrdData(dt);
        selectedPagamentoOrdem.setOrdCodigo(selectedOrdem);

        sesDAO.setaSession("id", "addPagamentoOrdem");
    }

    public void finishAddPagamentoOrdem() {

        if (codigo == 0) {
            valor = selectedPagamentoOrdem.getPagOrdValor() - valor;
            valor = pagOrdDAO.getAcumulado(selectedPagamentoOrdem.getOrdCodigo().getOrdCodigo()) + valor;
        } else {
            valor = pagOrdDAO.getAcumulado(selectedPagamentoOrdem.getOrdCodigo().getOrdCodigo());
            valor = valor + selectedPagamentoOrdem.getPagOrdValor();
        }

        selectedPagamentoOrdem.setPagOrdValorAcumulado(valor);
        pagOrdDAO.addPagamentoOrdem(selectedPagamentoOrdem);
        selectedAuxOrdem = ordDAO.getOrdem(selectedPagamentoOrdem.getOrdCodigo().getOrdCodigo());
        if (selectedAuxOrdem.getOrdValorRestante() <= valor) {
            selectedOrdem.setOrdPago("S");
            ordDAO.addOrdem(selectedOrdem);
        }
        cachedPagamentoOrdem = null;
        sesDAO.setaSession("id", "pagamentoOrdem");
    }

    public void updatePagamentoOrdem() {
        codigo = 0;
        valor = selectedPagamentoOrdem.getPagOrdValor();
        sesDAO.setaSession("id", "addPagamentoOrdem");
    }

    public void removePagamentoOrdem() {
        pagOrdDAO.removePagamentoOrdem(selectedPagamentoOrdem);
        cachedPagamentoOrdem = null;
        sesDAO.setaSession("id", "pagamentoOrdem");
    }
    public void chamaPagamentoOrdem(){
        sesDAO.setaSession("id", "pagamentoOrdem");
    }

    public List<PagamentoOrdem> getCachedPagamentoOrdem() {
        cachedPagamentoOrdem = null;
        if (cachedPagamentoOrdem == null) {
            cachedPagamentoOrdem = pagOrdDAO.getPagamentoOrdemsOrd(selectedOrdem.getOrdCodigo());
        }
        return cachedPagamentoOrdem;
    }

    public PagamentoOrdem getSelectedPagamentoOrdem() {
        return selectedPagamentoOrdem;
    }

    public void setSelectedPagamentoOrdem(PagamentoOrdem selectedPagamentoOrdem) {
        this.selectedPagamentoOrdem = selectedPagamentoOrdem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Ordem getSelectedAuxOrdem() {
        return selectedAuxOrdem;
    }

    public void setSelectedAuxOrdem(Ordem selectedAuxOrdem) {
        this.selectedAuxOrdem = selectedAuxOrdem;
    }

    public Ordem getSelectedOrdem() {
        return selectedOrdem;
    }

    public void setSelectedOrdem(Ordem selectedOrdem) {
        this.selectedOrdem = selectedOrdem;
    }


}
