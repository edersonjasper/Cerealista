/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="categoria_despesa_cat_des_codigo_seq",allocationSize=1)
@Table(name="CATEGORIA_DESPESA")
public class CategoriaDespesa implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="CAT_DES_CODIGO",nullable=false)
    private Integer catDesCodigo;

    @Basic(optional=false)
    @Column(name="CAT_DES_DESCRICAO",nullable=false,length=30)
    private String catDesDescricao;

    @OneToMany(mappedBy="catDesCodigo",fetch=FetchType.LAZY)
    private List<Despesa> despesas;

    public CategoriaDespesa(){

    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    

    public Integer getCatDesCodigo() {
        return catDesCodigo;
    }

    public void setCatDesCodigo(Integer catDesCodigo) {
        this.catDesCodigo = catDesCodigo;
    }

    public String getCatDesDescricao() {
        return catDesDescricao;
    }

    public void setCatDesDescricao(String catDesDescricao) {
        this.catDesDescricao = catDesDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaDespesa other = (CategoriaDespesa) obj;
        if (this.catDesCodigo != other.catDesCodigo && (this.catDesCodigo == null || !this.catDesCodigo.equals(other.catDesCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.catDesCodigo != null ? this.catDesCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return catDesDescricao;
    }
}
