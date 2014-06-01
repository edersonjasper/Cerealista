/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.PessoaCategoria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class PessoaCategoriaDAO extends GenericDAO{

    public PessoaCategoriaDAO(){

    }
     public int addPessoaCategoria(PessoaCategoria pesCat){
        saveOrUpdatePojo(pesCat);
        return pesCat.getPesCatCodigo();
    }
     public Integer getProximo(Integer max){
         Session ses = getSession();
        
        List<PessoaCategoria> pesCat = ses.createQuery("from PessoaCategoria pesCat order by pesCatCodigo desc limit 1").list();

         if(pesCat.size() != 0){
             max = pesCat.get(0).getPesCatCodigo()+1;
             return max;
         }
         max = 1;
         return max;
     }
    public void removePessoaCategoria(PessoaCategoria pesCat){
        removePojo(pesCat);
    }
    public void setPessoaCategoria(PessoaCategoria pesCat){
        saveOrUpdatePojo(pesCat);
    }
    public PessoaCategoria getPessoaCategoria(int pesCatId){
        PessoaCategoria pesCat = getPojo(PessoaCategoria.class, pesCatId);
        return pesCat;
    }
    public List<PessoaCategoria> getPessoaCategoriasFuncionarios(){//categoria = 1 Funcionarios
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat" +
                " where catCodigo = 1 " +
                "and pesCodigo.pesOculto = 'N' order by pesCodigo.pesNome asc");
    }
    public List<PessoaCategoria> getPessoaCategoriasClientes(){
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat" +
                " where catCodigo = 2 " +
                "and pesCodigo.pesOculto = 'N' order by pesCodigo.pesNome asc");
    }
    public List<PessoaCategoria> getPessoaCategorias(){
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat" +
                " order by pesCodigo.pesNome asc");
    }
    public List<PessoaCategoria> getPessoaCategoriasFornecedores(){
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat" +
                " where catCodigo = 3 " +
                "and pesCodigo.pesOculto = 'N' order by pesCodigo.pesNome asc");
    }
    public List<PessoaCategoria> getPessoaCategoriasTransportadora(){
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat" +
                " where catCodigo = 4 " +
                "and pesCodigo.pesOculto = 'N' order by pesCodigo.pesNome asc");
    }
    public List<PessoaCategoria> getPessoaCategoriasPesId(Integer pesID){
        return getPureList(PessoaCategoria.class, "from PessoaCategoria pesCat where pesCodigo = "+pesID+" and pesCodigo.pesOculto = 'N' order by pesCodigo.pesNome asc");
    }

}
