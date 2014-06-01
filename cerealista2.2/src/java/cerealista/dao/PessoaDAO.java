/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Pessoa;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class PessoaDAO extends GenericDAO{

    public PessoaDAO(){

    }
     public int addPessoa(Pessoa pessoa){
        saveOrUpdatePojo(pessoa);
        return pessoa.getPesCodigo();
    }
     public Integer getProximo(Integer max){
         Session ses = getSession();
        
        List<Pessoa> pes = ses.createQuery("from Pessoa pes order by pesCodigo desc limit 1").list();

         if(pes.size() != 0){
             max = pes.get(0).getPesCodigo()+1;
             return max;
         }
         max = 1;
         return max;
     }
    public void removePessoa(Pessoa pessoa){
        removePojo(pessoa);
    }
    public void setPessoa(Pessoa pessoa){
        saveOrUpdatePojo(pessoa);
    }
    public Pessoa getPessoa(int pessoaId){
        Pessoa pessoa = getPojo(Pessoa.class, pessoaId);
        return pessoa;
    }
    public List<Pessoa> getPessoas(){
        return getPureList(Pessoa.class, "from Pessoa pes order by pesNome asc");
    }

}
