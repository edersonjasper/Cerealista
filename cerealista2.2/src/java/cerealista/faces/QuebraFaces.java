/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.faces;

import cerealista.dao.ProdutoDAO;
import cerealista.dao.QuebraDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Produto;
import classe.entidade.Quebra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ederson
 */

public class QuebraFaces {

    private QuebraDAO queDAO = new QuebraDAO();
    private Quebra selectedQuebra;
    private List<Quebra> cachedQuebra = null;
    private Integer intAux;
    private Double peso;
    private Produto selectedProduto;
    private ProdutoDAO proDAO = new ProdutoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private Integer codigo;
    /** Creates a new instance of QuebraFaces */
    public QuebraFaces() {
    }
    //=============== quebra ========================
    public List<Quebra> getCachedQuebra() {
        int proId = 0;
        cachedQuebra = null;
        if (cachedQuebra == null) {
            if (selectedProduto != null) {
                proId = selectedProduto.getProCodigo();
                cachedQuebra = queDAO.getQuebraProduto(proId);
            } else {
                cachedQuebra = queDAO.getQuebras();
            }

        }

        return cachedQuebra;
    }

    public void returnProdutoMain() {
        if (selectedProduto != null) {
            sesDAO.setaSession("id", "produto");
        }
    }

    public void addQuebra() {
        selectedQuebra = new Quebra();
        codigo = 1;
        intAux = 0;
        Date data = new Date();
        selectedQuebra.setQueData(data);
        if (selectedProduto != null) {
            selectedQuebra.setProCodigo(selectedProduto);
        }
        sesDAO.setaSession("id","addQuebra");
    }

    public void finishAddQuebra() {
        selectedQuebra.calculaPesoTotal();
        queDAO.addQuebra(selectedQuebra);
        //seleciona o poduto referente a quebra de caixa que foi inserido
        selectedProduto = proDAO.getProduto(selectedQuebra.getProCodigo().getProCodigo());
        //verifica se é atualização e se é o mesmo produto
        if (codigo == 0 && selectedQuebra.getProCodigo().getProCodigo() == intAux) {
            peso = peso - selectedQuebra.getQuePesoTotal();
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + peso);
            proDAO.addProduto(selectedProduto);
        } // verifica se foi mudado de produto na atualização
        else if (selectedQuebra.getProCodigo().getProCodigo() != intAux && intAux != 0) {
            //se for mudado de produto na atualização ele atualiza o estoque do mesmo
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedQuebra.getQuePesoTotal());
            proDAO.addProduto(selectedProduto);
            // atualiza o estoque do produto que estava inserido antes
            selectedProduto = proDAO.getProduto(intAux);
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() + peso);
            proDAO.addProduto(selectedProduto);
        } else {
            selectedProduto.setProEstoque(selectedProduto.getProEstoque() - selectedQuebra.getQuePesoTotal());
            proDAO.addProduto(selectedProduto);
        }
        cachedQuebra = null;
        sesDAO.setaSession("id","quebra");
    }

    public void updateQuebra() {
        codigo = 0;
        intAux = selectedQuebra.getProCodigo().getProCodigo();
        peso = selectedQuebra.getQuePesoTotal();
        sesDAO.setaSession("id","addQuebra");
    }

    public void removeQuebra() {
        queDAO.removeQuebra(selectedQuebra);
        selectedProduto = proDAO.getProduto(selectedQuebra.getProCodigo().getProCodigo());

        selectedProduto.setProEstoque(selectedProduto.getProEstoque() + selectedQuebra.getQuePesoTotal());
        proDAO.addProduto(selectedProduto);
        cachedQuebra = null;
        sesDAO.setaSession("id","quebra");
    }
    public void chamaQuebra(){
        sesDAO.setaSession("id","quebra");
    }
    public Quebra getSelectedQuebra() {
        return selectedQuebra;
    }

    public void setSelectedQuebra(Quebra selectedQuebra) {
        this.selectedQuebra = selectedQuebra;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIntAux() {
        return intAux;
    }

    public void setIntAux(Integer intAux) {
        this.intAux = intAux;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }

}
