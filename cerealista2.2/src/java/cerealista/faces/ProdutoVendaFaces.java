/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.ProdutoDAO;
import cerealista.dao.ProdutoVendaDAO;
import cerealista.dao.SessionDAO;
import cerealista.dao.VendaDAO;
import classe.entidade.Produto;
import classe.entidade.ProdutoVenda;
import classe.entidade.Venda;
import java.util.List;

/**
 *
 * @author ederson
 */
public class ProdutoVendaFaces {

    private Venda selectedVenda;
    private ProdutoVenda selectedProdutoVenda;
    private Produto selectedProduto;
    private List<ProdutoVenda> cachedProdutoVenda = null;
    private ProdutoDAO proDAO = new ProdutoDAO();
    private Integer codigo;
    private Integer intAux;
    private ProdutoVendaDAO proVenDAO = new ProdutoVendaDAO();
    private VendaDAO venDAO = new VendaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private Double peso = 0.0;
    private Double valor = 0.0;
    private List<ProdutoVenda> listAuxiliar = null;
    /** Creates a new instance of ProdutoVendaFaces */
    public ProdutoVendaFaces() {
    }

    public void addProdutoVenda() {
        selectedProdutoVenda = new ProdutoVenda();
        selectedProdutoVenda.setVenCodigo(selectedVenda);
        codigo = 1;
        intAux = 0;
        sesDAO.setaSession("id", "addProdutoVenda");
    }

    public void finishAddProdutoVenda() {
        selectedProdutoVenda.calculaPesoTotal();
        selectedProdutoVenda.calculaValorTotal();
        proVenDAO.addProdutoVenda(selectedProdutoVenda);

        //carrega o produto que esta sendo inserido ou atualizado na vanda
        selectedProduto = proDAO.getProduto(selectedProdutoVenda.getProCodigo().getProCodigo());
        // se esta sendo atualizo somente o peso do mesmo produto que foi inserido antes ele atualiza o estoque do mesmo
        if (codigo == 0 && intAux == selectedProdutoVenda.getProCodigo().getProCodigo()) {
            peso = selectedProdutoVenda.getProVenPesoTotal() - peso;
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - peso);
        } else //verifica se foi mudado de produto para aquela quantidade
        //faz a comparação com o zero para verificar senão esta sendo inserido
        if (intAux != selectedProdutoVenda.getProCodigo().getProCodigo() && intAux != 0) {
            //atualiza o estoque do produto que esta sendo utilizado
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedProdutoVenda.getProVenPesoTotal());
            proDAO.addProduto(selectedProduto);
            //retorna ao estoque a quantidade do produto anterior
            selectedProduto = proDAO.getProduto(intAux);
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + peso);
            proDAO.addProduto(selectedProduto);

        } else {
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedProdutoVenda.getProVenPesoTotal());
        }
        proDAO.addProduto(selectedProduto);

        //seleciona os produtos da venda para atualizar o peso e o valor.
        listAuxiliar = proVenDAO.getTotalVenda(selectedProdutoVenda.getVenCodigo().getVenCodigo());
        if (listAuxiliar.size() != 0) {
            peso = 0.0;
            valor = 0.0;
            for (ProdutoVenda proVen : listAuxiliar) {
                peso = peso + proVen.getProVenPesoTotal();
                valor = valor + proVen.getProVenValorTotal();
            }
            selectedVenda.setVenPesoTotal(peso);
            selectedVenda.setVenValorTotal(valor);
            venDAO.addVenda(selectedVenda);
        }

        cachedProdutoVenda = null;

        sesDAO.setaSession("id", "produtoVenda");
    }

    public void updateProdutoVenda() {
        codigo = 0;
        peso = selectedProdutoVenda.getProVenPesoTotal();
        intAux = selectedProdutoVenda.getProCodigo().getProCodigo();
        sesDAO.setaSession("id", "addProdutoVenda");
    }

    public void removeProdutoVenda() {
        proVenDAO.removeProdutoVenda(selectedProdutoVenda);
        listAuxiliar = proVenDAO.getTotalVenda(selectedProdutoVenda.getVenCodigo().getVenCodigo());
        if (listAuxiliar.size() != 0) {
            peso = 0.0;
            valor = 0.0;
            for (ProdutoVenda proVen : listAuxiliar) {
                peso = peso + proVen.getProVenPesoTotal();
                valor = valor + proVen.getProVenValorTotal();
            }
            selectedVenda.setVenPesoTotal(peso);
            selectedVenda.setVenValorTotal(valor);
            venDAO.addVenda(selectedVenda);
        }// caso for o ultimo produto a ser excluido ele sera o peso e o valor total
        else {
            selectedVenda.setVenPesoTotal(0.0);
            selectedVenda.setVenValorTotal(0.0);
            selectedVenda.setVenValorFrete(0.0);
            selectedVenda.setVenValorLiquido(0.0);
            selectedVenda.setVenIcms(0.0);
            venDAO.addVenda(selectedVenda);
        }
        selectedProduto = proDAO.getProduto(selectedProdutoVenda.getProCodigo().getProCodigo());

        selectedProduto.setProEstoque(selectedProduto.getProEstoque() + selectedProdutoVenda.getProVenPesoTotal());

        proDAO.addProduto(selectedProduto);
        cachedProdutoVenda = null;

        sesDAO.setaSession("id", "produtoVenda");
    }
    public void chamaProdutoVenda(){
        sesDAO.setaSession("id", "produtoVenda");
    }
    public List<ProdutoVenda> getCachedProdutoVenda() {
        cachedProdutoVenda = null;
        if (cachedProdutoVenda == null) {
            cachedProdutoVenda = proVenDAO.getProdutoVendasVenda(selectedVenda.getVenCodigo());
        }
        return cachedProdutoVenda;
    }

    public ProdutoVenda getSelectedProdutoVenda() {
        return selectedProdutoVenda;
    }

    public void setSelectedProdutoVenda(ProdutoVenda selectedProdutoVenda) {
        this.selectedProdutoVenda = selectedProdutoVenda;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }

    public Venda getSelectedVenda() {
        return selectedVenda;
    }

    public void setSelectedVenda(Venda selectedVenda) {
        this.selectedVenda = selectedVenda;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
