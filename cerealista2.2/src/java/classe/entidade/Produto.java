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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="produto_pro_codigo_seq",allocationSize=1)
@Table(name="PRODUTO")
public class Produto implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="PRO_CODIGO",nullable=false)
    private Integer proCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="UNI_MED_CODIGO")
    private UnidadeMedida uniMedCodigo;

    @Basic(optional=false)
    @Column(name="PRO_NOME", nullable=false,length=40)
    private String proNome;

    @Basic(optional=false)
    @Column(name="PRO_ESTOQUE",nullable=false,columnDefinition="numeric(10,3)default '0'")
    private Double proEstoque;

    @OneToMany(mappedBy="proCodigo",fetch=FetchType.LAZY)
    private List<Quebra> quebras;

    public List<Quebra> getQuebras() {
        return quebras;
    }

    public void setQuebras(List<Quebra> quebras) {
        this.quebras = quebras;
    }

    
    public Produto(){

    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Double getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(Double proEstoque) {
        this.proEstoque = proEstoque;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public UnidadeMedida getUniMedCodigo() {
        return uniMedCodigo;
    }

    public void setUniMedCodigo(UnidadeMedida uniMedCodigo) {
        this.uniMedCodigo = uniMedCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.proCodigo != other.proCodigo && (this.proCodigo == null || !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.proCodigo != null ? this.proCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString()    {
        return proNome;
    }

}
