/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.faces;

import cerealista.dao.HorasTrabalhadasDAO;
import cerealista.dao.PessoaCategoriaDAO;
import cerealista.dao.SessionDAO;
import classe.entidade.HorasTrabalhadas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eder
 */
public class HorasTrabalhadasFaces {

    private HorasTrabalhadas selectedHorasTrabalhadas = new HorasTrabalhadas();
    private HorasTrabalhadasDAO horTraDAO = new HorasTrabalhadasDAO();
    private PessoaCategoriaDAO pesCatDAO = new PessoaCategoriaDAO();
    private SessionDAO sesDAO = new SessionDAO();
    private List<HorasTrabalhadas> cachedHorastrabalhadas = null;
    private Date dataIni;
    private Date dataFin;
    private Integer pesId;
    private Double total;
    private Double horas;

    /** Creates a new instance of HorasTrabalhadasFaces */
    public HorasTrabalhadasFaces() {
    }

    public void addHorasTrabalhadas() {
        selectedHorasTrabalhadas = new HorasTrabalhadas();
        Date data = new Date();
        selectedHorasTrabalhadas.setHorTraData(data);
        sesDAO.setaSession("id", "addHorasTrabalhadas");
    }

    public void finishAddHorasTrabalhadas() {
        selectedHorasTrabalhadas.calculaValorHorasTrabalhadas();
        horTraDAO.addHorasTrabalhadas(selectedHorasTrabalhadas);
        cachedHorastrabalhadas = null;

        sesDAO.setaSession("id", "horasTrabalhadas");
    }

    public void updateHorasTrabalhadas() {
        sesDAO.setaSession("id", "addHorasTrabalhadas");
    }

    public void removeHorasTrabalhadas() {
        horTraDAO.removeHorasTrabalhadas(selectedHorasTrabalhadas);
        cachedHorastrabalhadas = null;
        sesDAO.setaSession("id", "horasTrabalhadas");
    }
    public void chamaHorasTrabalhadas(){
        sesDAO.setaSession("id", "horasTrabalhadas");
    }

    public List<HorasTrabalhadas> getCachedHorastrabalhadas() {
        cachedHorastrabalhadas = null;
        if (pesId == null) {
            pesId = 0;
        }
        if (selectedHorasTrabalhadas.getPesCatCodigo() != null) {
            total = 0.0;
            horas = 0.0;
            Boolean t;
            String hora = "";
            String min = "";
            Double minutos = 0.0;
            cachedHorastrabalhadas = horTraDAO.getPesqHorasTrabalhadas(selectedHorasTrabalhadas.getPesCatCodigo().getPesCatCodigo(), dataIni, dataFin);
            for (HorasTrabalhadas horTra : cachedHorastrabalhadas) {
                total = total + horTra.getHorTraValorTotal();
                //calula o total de horas
                String hor = String.valueOf(horTra.getHorTraHorasTrabalhadas());
                t = true;
                hora = "";
                min = "";
                for (int i = 0; i < hor.length();) {
                    if (hor.substring(i, i + 1).equals(".")) {
                        t = false;
//                        horas = horas + Double.valueOf(hor.substring(i - 4, i - 1));
                    } else if (t) {
                        hora = hora + hor.substring(i, i + 1);
                    } else {
                        min = min + hor.substring(i, i + 1);

                    }
                    i++;
                }
                // colocar duas casas ex.: 3 + 0 = 30;
                if (min.length() == 1) {
                    min = min + "0";
                }
                horas = horas + Double.valueOf(hora);
                minutos = minutos + Double.valueOf(min);
            }
            while (minutos >= 60) {
                horas = horas + 1;
                minutos = minutos - 60;
            }
            horas = horas + (minutos / 100);

        }
        return cachedHorastrabalhadas;
    }

    public HorasTrabalhadas getSelectedHorasTrabalhadas() {
        return selectedHorasTrabalhadas;
    }

    public void setSelectedHorasTrabalhadas(HorasTrabalhadas selectedHorasTrabalhadas) {
        this.selectedHorasTrabalhadas = selectedHorasTrabalhadas;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
