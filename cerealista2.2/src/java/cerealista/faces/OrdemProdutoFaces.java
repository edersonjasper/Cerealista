/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.OrdemDAO;
import cerealista.dao.OrdemProdutoDAO;
import cerealista.dao.ProdutoDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Ordem;
import classe.entidade.OrdemProduto;
import classe.entidade.Produto;
import java.util.List;

/**
 *
 * @author ederson
 */

public class OrdemProdutoFaces {
    private Ordem selectedOrdem;
    private OrdemProduto selectedOrdemProduto;
    private Produto selectedProduto;
    private OrdemProdutoDAO ordProDAO = new OrdemProdutoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private ProdutoDAO proDAO = new ProdutoDAO();
    private OrdemDAO ordDAO = new OrdemDAO();
    private List<OrdemProduto> cachedOrdemProduto = null;
    private List<OrdemProduto> listAuxiliarOrdPro = null;
    private Integer codigo;
    private Integer intAux;
    private Double peso = 0.0;
    private Double valor = 0.0;
    /** Creates a new instance of OrdemProdutoFaces */
    public OrdemProdutoFaces() {
    }

    public void addOrdemProduto() {
        selectedOrdemProduto = new OrdemProduto();
        codigo = 1;
        intAux = 0;
        selectedOrdemProduto.setOrdCodigo(selectedOrdem);

        sesDAO.setaSession("id", "addOrdemProduto");
    }

    public void finishAddOrdemProduto() {

        selectedOrdemProduto.calculaPesoTotal();
        selectedOrdemProduto.calculaValorTotal();
        ordProDAO.addOrdemProduto(selectedOrdemProduto);
        //seleciona o produto que foi inserido
        selectedProduto = proDAO.getProduto(selectedOrdemProduto.getProCodigo().getProCodigo());
        //verifica se foi atualizado e se é o mesmo produto
        if (codigo == 0 && selectedOrdemProduto.getProCodigo().getProCodigo() == intAux) {
            peso = selectedOrdemProduto.getOrdProPesoTotal() - peso;
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + peso);
        } // verifica se foi mudado de produto
        else if (selectedOrdemProduto.getProCodigo().getProCodigo() != intAux && intAux != 0) {
            //atualiza o estoque do produto que foi atualizado
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + selectedOrdemProduto.getOrdProPesoTotal());
            proDAO.addProduto(selectedProduto);
            //atualiza o estoque do produto anterior
            selectedProduto = proDAO.getProduto(intAux);
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - peso);
            proDAO.addProduto(selectedProduto);
        } else {
            selectedProduto.setProEstoque(selectedOrdemProduto.getOrdProPesoTotal() + selectedProduto.getProEstoque());
            proDAO.addProduto(selectedProduto);
        }
        valor = 0.0;
        peso = 0.0;
        listAuxiliarOrdPro = ordProDAO.getValorTotal(selectedOrdem.getOrdCodigo());
        if (listAuxiliarOrdPro.size() != 0) {
            for (OrdemProduto ordPro : listAuxiliarOrdPro) {
                valor = valor + ordPro.getOrdProValorTotal();
                peso = peso + ordPro.getOrdProPesoTotal();
            }
        }
        selectedOrdem.setOrdValorTotal(valor);
        selectedOrdem.setOrdPesoTotal(peso);
        selectedOrdem.setOrdValorRestante(valor);
        ordDAO.addOrdem(selectedOrdem);
        cachedOrdemProduto = null;
        sesDAO.setaSession("id", "ordemProduto");
    }

    public void updateOrdemProduto() {
        codigo = 0;
        intAux = selectedOrdemProduto.getProCodigo().getProCodigo();
        peso = selectedOrdemProduto.getOrdProPesoTotal();
        sesDAO.setaSession("id", "addOrdemProduto");
    }

    public void removeOrdemProduto() {
        ordProDAO.removeOrdemProduto(selectedOrdemProduto);
        valor = 0.0;
        peso = 0.0;

        selectedProduto = proDAO.getProduto(selectedOrdemProduto.getProCodigo().getProCodigo());
        selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedOrdemProduto.getOrdProPesoTotal());
        proDAO.addProduto(selectedProduto);

        listAuxiliarOrdPro = ordProDAO.getValorTotal(selectedOrdem.getOrdCodigo());
        if (listAuxiliarOrdPro.size() != 0) {
            for (OrdemProduto ordPro : listAuxiliarOrdPro) {
                valor = valor + ordPro.getOrdProValorTotal();
                peso = peso + ordPro.getOrdProPesoTotal();
            }
            selectedOrdem.setOrdValorTotal(valor);
            selectedOrdem.setOrdPesoTotal(peso);
        } else {
            selectedOrdem.setOrdAdiantemento(0.0);
            selectedOrdem.setOrdValorRestante(0.0);
            selectedOrdem.setOrdValorTotal(0.0);
            selectedOrdem.setOrdDesconto(0.0);
            selectedOrdem.setOrdFundoRural(0.0);
        }

        ordDAO.addOrdem(selectedOrdem);
        cachedOrdemProduto = null;
        sesDAO.setaSession("id", "ordemProduto");
    }
    public void chamaOrdemProduto(){
        sesDAO.setaSession("id", "ordemProduto");
    }

    public List<OrdemProduto> getCachedOrdemProduto() {
        cachedOrdemProduto = null;
        if (cachedOrdemProduto == null) {
            cachedOrdemProduto = ordProDAO.getOrdemProdutos(selectedOrdem.getOrdCodigo());
        }
        return cachedOrdemProduto;
    }

    public OrdemProduto getSelectedOrdemProduto() {
        return selectedOrdemProduto;
    }

    public void setSelectedOrdemProduto(OrdemProduto selectedOrdemProduto) {
        this.selectedOrdemProduto = selectedOrdemProduto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIntAux() {
        return intAux;
    }

    public void setIntAux(Integer intAux) {
        this.intAux = intAux;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Ordem getSelectedOrdem() {
        return selectedOrdem;
    }

    public void setSelectedOrdem(Ordem selectedOrdem) {
        this.selectedOrdem = selectedOrdem;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
