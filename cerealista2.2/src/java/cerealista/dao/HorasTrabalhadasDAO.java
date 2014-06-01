/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cerealista.dao;

import classe.entidade.HorasTrabalhadas;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class HorasTrabalhadasDAO extends GenericDAO {

    public HorasTrabalhadasDAO() {
    }

    public int addHorasTrabalhadas(HorasTrabalhadas horTra) {
        saveOrUpdatePojo(horTra);
        return horTra.getHorTraCodigo();
    }

    public void removeHorasTrabalhadas(HorasTrabalhadas horTra) {
        removePojo(horTra);
    }

    public void setHorasTrabalhadas(HorasTrabalhadas horTra) {
        saveOrUpdatePojo(horTra);
    }

    public HorasTrabalhadas getHorasTrabalhada(int horTraId) {
        HorasTrabalhadas horTra = getPojo(HorasTrabalhadas.class, horTraId);
        return horTra;
    }

    public List<HorasTrabalhadas> getHorasTrabalhadas() {
        return getPureList(HorasTrabalhadas.class, "from HorasTrabalhadas horTra order by horTraData desc");
    }

    public List<HorasTrabalhadas> getPesqHorasTrabalhadas(Integer pesId, Date dataIni, Date dataFin) {
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        if (pesId != 0 && dataIni != null && dataFin != null) {
            return getPureList(HorasTrabalhadas.class, "from HorasTrabalhadas horTra " +
                    "where pesCatCodigo = " + pesId +
                    "and horTraData >= '" + dt.format(dataIni) + "'" +
                    "and horTraData <= '" + dt.format(dataFin) + "' order by horTraCodigo desc");
        } else if (pesId == 0 && dataIni != null && dataFin != null) {
            return getPureList(HorasTrabalhadas.class, "from HorasTrabalhadas horTra " +
                    "where  horTraData >= '" + dt.format(dataIni) + "'" +
                    "and horTraData <= '" + dt.format(dataFin) + "' order by horTraCodigo desc");
        } else if (pesId != 0 && dataIni == null && dataFin == null) {
            return getPureList(HorasTrabalhadas.class, "from HorasTrabalhadas horTra " +
                    "where pesCatCodigo = " + pesId + " order by horTraCodigo desc");
        } else {
            return getPureList(HorasTrabalhadas.class, "from HorasTrabalhadas horTra order by horTraCodigo desc");
        }
    }

    public Integer getProximo(Integer max) {
        Session ses = getSession();
        List<HorasTrabalhadas> horTra = ses.createQuery("from HorasTrabalhadas horTra order by horTraCodigo desc limit 1").list();
        if (horTra.size() != 0) {
            max = horTra.get(0).getHorTraCodigo() + 1;
            return max;
        }
        max = 1;
        return max;
    }
}
