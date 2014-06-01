/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Acao;
import java.util.List;

/**
 *
 * @author Eder
 */
public class AcaoDAO extends GenericDAO{

    public int addAcao (Acao acao){
        saveOrUpdatePojo(acao);
        return acao.getAcaCodigo();
    }
    public void removeAcao(Acao acao){
        removePojo(acao);
    }
    public void setAcao(Acao acao){
        saveOrUpdatePojo(acao);
    }
    public Acao getAcao(int acaoId){
        Acao acao = getPojo(Acao.class, acaoId);
        return acao;
    }
    public List<Acao> getAcaos(){
        return getPureList(Acao.class, "from Acao acao");
    }
}
