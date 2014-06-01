/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.PessoaDAO;
import cerealista.dao.SessionDAO;
import cerealista.dao.UsuarioDAO;
import classe.entidade.Conta;
import classe.entidade.Pessoa;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Eder
 */
public class PessoaFaces {

    private List<Pessoa> cachedPessoa = null;
    private PessoaDAO pesDAO = new PessoaDAO();
    private UsuarioDAO usuDAO = new UsuarioDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private Pessoa selectedPessoa;
    private Conta selectedConta;

    /** Creates a new instance of PessoaFaces */
    public PessoaFaces() {
    }

    public void addPessoa() {
        selectedPessoa = new Pessoa();
        sesDAO.setaSession("id", "addPessoa");
    }

    public void finishAddPessoa() {
        char var = selectedPessoa.getPesSexo().charAt(0);
        selectedPessoa.setPesSexo(String.valueOf(var));

        var = selectedPessoa.getPesTipo().charAt(0);
        selectedPessoa.setPesTipo(String.valueOf(var));

        var = selectedPessoa.getPesOculto().charAt(0);
        selectedPessoa.setPesOculto(String.valueOf(var));

        pesDAO.addPessoa(selectedPessoa);
        cachedPessoa = null;
        sesDAO.setaSession("id", "pessoa");
    }

    public List<Pessoa> getCachedPessoa() {
        if (cachedPessoa == null) {
            cachedPessoa = pesDAO.getPessoas();
        }
        return cachedPessoa;
    }    

    public List<SelectItem> getTipoPessoa() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("F"));
        toReturn.add(new SelectItem("J"));
        return toReturn;

    }

    public List<SelectItem> getSexo() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("M"));
        toReturn.add(new SelectItem("F"));
        return toReturn;
    }

    public List<SelectItem> getOculto() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();
        toReturn.add(new SelectItem("N"));
        toReturn.add(new SelectItem("S"));
        return toReturn;
    }

    public void updatePessoa() {
        sesDAO.setaSession("id", "addPessoa");
    }

    public void removePessoa() {
        pesDAO.removePessoa(selectedPessoa);
        cachedPessoa = null;
        sesDAO.setaSession("id", "pessoa");
    }
    public void chamaPessoa(){
        sesDAO.setaSession("id", "pessoa");
    }

    public Pessoa getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(Pessoa selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }
   
}
