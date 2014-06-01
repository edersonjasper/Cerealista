/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.CategoriaDAO;
import cerealista.dao.PessoaCategoriaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Categoria;
import classe.entidade.Pessoa;
import classe.entidade.PessoaCategoria;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class PessoaCategoriafaces {

    private PessoaCategoria selectedPessoaCategoria;
    private PessoaCategoriaDAO pesCatDAO = new PessoaCategoriaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private CategoriaDAO catDAO = new CategoriaDAO();
    private List<PessoaCategoria> cachedPessoaCategoria = null;
    private Pessoa selectedPessoa;

    /** Creates a new instance of PessoaCategoriafaces */
    public PessoaCategoriafaces() {
    }

    public void addPessoaCateforia() {
        selectedPessoaCategoria = new PessoaCategoria();
        selectedPessoaCategoria.setPesCodigo(selectedPessoa);
        sesDAO.setaSession("id", "addPessoaCategoria");
    }

    public void finishAddCategoria() {
        pesCatDAO.addPessoaCategoria(selectedPessoaCategoria);
        cachedPessoaCategoria = null;
        sesDAO.setaSession("id", "pessoaCategoria");
    }

    public void updatePessoaCategoria() {
        sesDAO.setaSession("id", "addPessoaCategoria");
    }

    public void removePessoaCategoria() {
        pesCatDAO.removePessoaCategoria(selectedPessoaCategoria);
        cachedPessoaCategoria = null;
        sesDAO.setaSession("id", "pessoaCategoria");
    }
    public void chamaPessoaCategoria(){
        sesDAO.setaSession("id", "pessoaCategoria");
    }
    public List<SelectItem> getCategoria() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (Categoria cat : catDAO.getCategoriasPesId(selectedPessoa.getPesCodigo())) {
            toReturn.add(new SelectItem(cat, cat.getCatDescricao()));
        }
        return toReturn;
    }

    public List<SelectItem> getPessoaCategoriaFuncionarios() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (PessoaCategoria pesCat : pesCatDAO.getPessoaCategoriasFuncionarios()) {
            toReturn.add(new SelectItem(pesCat, pesCat.getPesCodigo() + "-" + pesCat.getCatCodigo()));
        }
        return toReturn;
    }
    public List<SelectItem> getPessoaCategoriaClientes() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (PessoaCategoria pesCat : pesCatDAO.getPessoaCategoriasClientes()) {
            toReturn.add(new SelectItem(pesCat, pesCat.getPesCodigo() + "-" + pesCat.getCatCodigo()));
        }
        return toReturn;
    }
    public List<SelectItem> getPessoaCategoriaFornecedores() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (PessoaCategoria pesCat : pesCatDAO.getPessoaCategoriasFornecedores()) {
            toReturn.add(new SelectItem(pesCat, pesCat.getPesCodigo() + "-" + pesCat.getCatCodigo()));
        }
        return toReturn;
    }
    public List<SelectItem> getPessoaCategoriaTransportadora() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        for (PessoaCategoria pesCat : pesCatDAO.getPessoaCategoriasTransportadora()) {
            toReturn.add(new SelectItem(pesCat, pesCat.getPesCodigo() + "-" + pesCat.getCatCodigo()));
        }
        return toReturn;
    }

    public List<PessoaCategoria> getCachedPessoaCategoria() {
        cachedPessoaCategoria = null;
        cachedPessoaCategoria = pesCatDAO.getPessoaCategoriasPesId(selectedPessoa.getPesCodigo());
        return cachedPessoaCategoria;
    }

    public PessoaCategoria getSelectedPessoaCategoria() {
        return selectedPessoaCategoria;
    }

    public void setSelectedPessoaCategoria(PessoaCategoria selectedPessoaCategoria) {
        this.selectedPessoaCategoria = selectedPessoaCategoria;
    }

    public Pessoa getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(Pessoa selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }
}
