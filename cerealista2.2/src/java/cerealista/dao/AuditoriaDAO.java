/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Auditoria;
import java.util.List;

/**
 *
 * @author Eder
 */
public class AuditoriaDAO extends GenericDAO {

    public AuditoriaDAO(){

    }
    public Integer addAuditoria(Auditoria auditoria){
        saveOrUpdatePojo(auditoria);
        return auditoria.getAudCodigo();
    }
    public void removeAuditoria(Auditoria auditoria){
        removePojo(auditoria);
    }
    public void setAuditoria(Auditoria auditoria){
        saveOrUpdatePojo(auditoria);
    }
    public Auditoria getAuditoria(int auditoriaId){
        Auditoria auditoria = getPojo(Auditoria.class, auditoriaId);
        return auditoria;
    }
    public List<Auditoria> getAuditorias(){
        return getPureList(Auditoria.class, "from auditoria aud");
    }

}
