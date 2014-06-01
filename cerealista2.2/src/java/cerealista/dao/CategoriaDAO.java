/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cerealista.dao;

import classe.entidade.Categoria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class CategoriaDAO extends GenericDAO{

    public CategoriaDAO(){

    }
     public int addCategoria(Categoria categoria){
        saveOrUpdatePojo(categoria);
        return categoria.getCatCodigo();
    }
    public void removeCategoria(Categoria categoria){
        removePojo(categoria);
    }
    public void setCategoria(Categoria categoria){
        saveOrUpdatePojo(categoria);
    }
    public Categoria getCategoria(int categoriaId){
        Categoria categoria = getPojo(Categoria.class, categoriaId);
        return categoria;
    }
    public List<Categoria> getCategorias(){
        return getPureList(Categoria.class, "from Categoria cat order by catDescricao asc");
    }
    public List<Categoria> getCategoriasPesId(Integer pesId){
        return getPureList(Categoria.class, "from Categoria cat " +
                "where catCodigo not in (select pesCat.catCodigo from PessoaCategoria pesCat " +
                                            "where pesCodigo = "+pesId+") order by catDescricao asc");
    }
    public Integer getProximo(Integer max){
        Session ses = getSession();
        List<Categoria> cat = ses.createQuery("from Categoria cat order by catCodigo desc limit 1").list();
        if(cat.size() != 0){
            max = cat.get(0).getCatCodigo()+1;
            return max;
        }
        max = 1;
        return max;
    }

}
