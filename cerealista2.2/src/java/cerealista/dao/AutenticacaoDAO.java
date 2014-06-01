/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Autenticacao;
import java.util.List;

/**
 *
 * @author Eder
 */
public class AutenticacaoDAO extends GenericDAO {

    public AutenticacaoDAO(){

    }
    public Integer addAutenticacao(Autenticacao autenticacao){
        saveOrUpdatePojo(autenticacao);
        return autenticacao.getAutCodigo();
    }
    public void removeAutenticacao(Autenticacao Autenticacao){
        removePojo(Autenticacao);
    }
    public void setAutenticacao(Autenticacao Autenticacao){
        saveOrUpdatePojo(Autenticacao);
    }
    public Autenticacao getAutenticacao(int AutenticacaoId){
        Autenticacao Autenticacao = getPojo(Autenticacao.class, AutenticacaoId);
        return Autenticacao;
    }
    public List<Autenticacao> getAutenticacaos(){
        return getPureList(Autenticacao.class, "from autenticacao aut");
    }

}
