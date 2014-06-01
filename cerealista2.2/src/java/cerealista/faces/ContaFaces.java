/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.ContaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.Conta;
import classe.entidade.Pessoa;
import java.util.List;

/**
 *
 * @author ederson
 */
public class ContaFaces {

    private List<Conta> cachedConta = null;
    private ContaDAO conDAO = new ContaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private Conta selectedConta;
    private Pessoa selectedPessoa;

    /** Creates a new instance of ContaFaces */
    public ContaFaces() {
    }

    public void conta() {
        sesDAO.setaSession("id", "conta");
    }

    public void addConta() {
        selectedConta = new Conta();
        selectedConta.setPesCodigo(selectedPessoa);
        sesDAO.setaSession("id", "addConta");
    }

    public void finishAddConta() {
        conDAO.addConta(selectedConta);
        cachedConta = null;
        sesDAO.setaSession("id", "conta");
    }

    public void updateConta() {
        sesDAO.setaSession("id", "addConta");
    }

    public void removeConta() {
        conDAO.removeConta(selectedConta);
        cachedConta = null;
        sesDAO.setaSession("id", "conta");
    }
    public void chamaConta(){
        sesDAO.setaSession("id", "conta");
    }

    public List<Conta> getCachedConta() {
        cachedConta = null;
        if (cachedConta == null) {
            cachedConta = conDAO.getConta(selectedPessoa.getPesCodigo());
        }
        return cachedConta;
    }

    public Conta getSelectedConta() {
        return selectedConta;
    }

    public void setSelectedConta(Conta selectedConta) {
        this.selectedConta = selectedConta;
    }

    public Pessoa getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(Pessoa selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }
}
