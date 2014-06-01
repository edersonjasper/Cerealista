/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.SessionDAO;
import cerealista.dao.TelefoneDAO;
import classe.entidade.Pessoa;
import classe.entidade.Telefone;
import java.util.List;

/**
 *
 * @author Eder
 */
public class TelefoneFaces {

    private Telefone selectedTelefone;
    private TelefoneDAO telDAO = new TelefoneDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<Telefone> cachedTelefone = null;
    private Pessoa selectedPessoa;

    /** Creates a new instance of TelefoneFaces */
    public TelefoneFaces() {
    }

    public List<Telefone> getCachedTelefone() {

        cachedTelefone = null;
        cachedTelefone = telDAO.getTelefone(selectedPessoa.getPesCodigo());

        return cachedTelefone;
    }

    public void addTelefone() {
        selectedTelefone = new Telefone();
        selectedTelefone.setPesCodigo(selectedPessoa);
        sesDAO.setaSession("id", "addTelefone");
    }

    public void finishAddTelefone() {
        telDAO.addTelefone(selectedTelefone);
        cachedTelefone = null;
        sesDAO.setaSession("id", "telefone");
    }

    public void updateTelefone() {
        sesDAO.setaSession("id", "addTelefone");
    }

    public void removeTelefone() {
        telDAO.removeTelefone(selectedTelefone);
        cachedTelefone = null;
        sesDAO.setaSession("id", "telefone");
    }
    public void chamaTelefone(){
        sesDAO.setaSession("id", "telefone");
    }

    public Telefone getSelectedTelefone() {
        return selectedTelefone;
    }

    public void setSelectedTelefone(Telefone selectedTelefone) {
        this.selectedTelefone = selectedTelefone;
    }

    public Pessoa getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(Pessoa selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }
}
