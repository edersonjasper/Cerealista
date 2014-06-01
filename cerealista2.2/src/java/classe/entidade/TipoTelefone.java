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
@SequenceGenerator(name="seq",sequenceName="tipo_telefone_tip_codigo_seq",allocationSize=1)
@Table(name="tipo_telefone")
public class TipoTelefone implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="tip_codigo", nullable=false)
    private Integer tipCodigo;

    @Basic(optional=false)
    @Column(name="tip_descricao",nullable=false,length=20)
    private String tipDescricao;

    @OneToMany(mappedBy="tipCodigo",fetch=FetchType.LAZY)
    private List<Telefone> telefones;


    public TipoTelefone(){

    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    

    public Integer getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(Integer tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDescricao() {
        return tipDescricao;
    }

    public void setTipDescricao(String tipDescricao) {
        this.tipDescricao = tipDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoTelefone other = (TipoTelefone) obj;
        if (this.tipCodigo != other.tipCodigo && (this.tipCodigo == null || !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.tipCodigo != null ? this.tipCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return tipDescricao;
    }
    
}
