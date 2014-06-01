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
@SequenceGenerator(name="seq",sequenceName="cidade_cid_codigo_seq",allocationSize=1)
@Table(name="cidade")
public class Cidade implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="cid_codigo",nullable=false)
    private Integer cidCodigo;

    @Basic(optional=false)
    @Column(name="cid_nome",nullable=false,length=40)
    private String cidNome;

    @Basic(optional=false)
    @Column(name="cid_uf",length=2,nullable=false)
    private String cidUf;

    @OneToMany(mappedBy="cidCodigo",fetch=FetchType.LAZY)
    private List<Pessoa> pessoas;

    @OneToMany(mappedBy="cidCodigo",fetch=FetchType.LAZY)
    private List<Veiculo> veiculos;

    public Cidade(){

    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
    public Integer getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public String getCidUf() {
        return cidUf;
    }

    public void setCidUf(String cidUf) {
        this.cidUf = cidUf.toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.cidCodigo != other.cidCodigo && (this.cidCodigo == null || !this.cidCodigo.equals(other.cidCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.cidCodigo != null ? this.cidCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return cidNome;
    }
}
