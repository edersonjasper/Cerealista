/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.ProdutoDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Produto;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class ProdutoFaces {

    private Produto selectedProduto;
    private ProdutoDAO proDAO = new ProdutoDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Produto> cachedProduto = null;
    private Integer codigo;

    /** Creates a new instance of ProdutoFaces */
    public ProdutoFaces() {
    }

    public void addProduto() {
        selectedProduto = new Produto();
        codigo = 1;
        selectedProduto.setProEstoque(0.0);
        sesDAO.setaSession("id", "addProduto");

    }

    public void finishAddProduto() {
        proDAO.addProduto(selectedProduto);
        cachedProduto = null;
        sesDAO.setaSession("id", "produto");
    }

    public void updateProduto() {
        sesDAO.setaSession("id", "addProduto");
    }

    public void removeProduto() {
        proDAO.removeProduto(selectedProduto);
        cachedProduto = null;
        sesDAO.setaSession("id", "produto");
    }
    public void chamaProduto(){
        sesDAO.setaSession("id", "produto");
    }
    public List<SelectItem> getProduto() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (Produto pro : proDAO.getProdutos()) {
            toReturn.add(new SelectItem(pro, pro.getProNome()));
        }
        return toReturn;
    }

    public List<Produto> getCachedProduto() {
        cachedProduto = null;
        if (cachedProduto == null) {
            cachedProduto = proDAO.getProdutos();
            selectedProduto = null;
        }
        return cachedProduto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}
