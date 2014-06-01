/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="categoria_cat_codigo_seq",allocationSize=1)
@Table(name="CATEGORIA")
public class Categoria  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="CAT_CODIGO",nullable=false)
    private Integer catCodigo;

    @Basic(optional=false)
    @Column(name="CAT_DESCRICAO",nullable=false,length=30)
    private String catDescricao;

    public Categoria(){

    }

   

   
    

    public Integer getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(Integer catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getCatDescricao() {
        return catDescricao;
    }

    public void setCatDescricao(String catDescricao) {
        this.catDescricao = catDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.catCodigo != other.catCodigo && (this.catCodigo == null || !this.catCodigo.equals(other.catCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.catCodigo != null ? this.catCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return catDescricao;
    }
    
}
