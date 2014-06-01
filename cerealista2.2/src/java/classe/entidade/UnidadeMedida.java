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
@SequenceGenerator(name="seq",sequenceName="unidade_medida_uni_med_codigo_seq",allocationSize=1)
@Table(name="unidade_medida")
public class UnidadeMedida implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="UNI_MED_CODIGO",nullable=false)
    private Integer uniMedCodigo;

    @Basic(optional=false)
    @Column(name="UNI_MED_DESCRICAO",length=5)
    private String uniMedDescricao;

    @OneToMany(mappedBy="uniMedCodigo",fetch=FetchType.LAZY)
    private List<Produto> produtos;

    public UnidadeMedida(){

    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
    public Integer getUniCodigo() {
        return uniMedCodigo;
    }

    public void setUniCodigo(Integer uniMedCodigo) {
        this.uniMedCodigo = uniMedCodigo;
    }

    public String getUniDescricao() {
        return uniMedDescricao;
    }

    public void setUniDescricao(String uniMedDescricao) {
        this.uniMedDescricao = uniMedDescricao.toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeMedida other = (UnidadeMedida) obj;
        if (this.uniMedCodigo != other.uniMedCodigo && (this.uniMedCodigo == null || !this.uniMedCodigo.equals(other.uniMedCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.uniMedCodigo != null ? this.uniMedCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return uniMedDescricao;
    }
    
}
