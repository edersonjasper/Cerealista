
import cerealista.dao.UnidadeMedidaDAO;
import classe.entidade.UnidadeMedida;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eder
 */
public class UnidadeMedidaFaces {

    private UnidadeMedida selectedUniMed;
    private UnidadeMedidaDAO uniMedDAO = new UnidadeMedidaDAO();
    private List<UnidadeMedida> cachedUniMed = null;
    private Integer codigo;

    /** Creates a new instance of UnidadeMedidaFaces */
    public UnidadeMedidaFaces() {
    }

    public String addUnidadeMedida() {
        selectedUniMed = new UnidadeMedida();
        codigo = 0;
        codigo = uniMedDAO.getProximo(codigo);
        selectedUniMed.setUniCodigo(codigo);
        return "gotoAddUnidadeMedida";
    }
    public String finishAddUnidadeMedida(){
        uniMedDAO.addUnidadeMedida(selectedUniMed);
        cachedUniMed = null;
        return "gotoListUnidadeMedida";
    }
    public String updateUnidadeMedida(){
        return "gotoAddUnidadeMedida";
    }
    public String removeUnidadeMedida(){
        uniMedDAO.removeUnidadeMedida(selectedUniMed);
        cachedUniMed = null;
        return "gotoListUnidadeMedida";
    }
    public List<UnidadeMedida> getCachedUniMed() {
        if (cachedUniMed == null) {
            cachedUniMed = uniMedDAO.getUnidadeMedidas();
        }
        return cachedUniMed;
    }

    public UnidadeMedida getSelectedUniMed() {
        return selectedUniMed;
    }

    public void setSelectedUniMed(UnidadeMedida selectedUniMed) {
        this.selectedUniMed = selectedUniMed;
    }
}
