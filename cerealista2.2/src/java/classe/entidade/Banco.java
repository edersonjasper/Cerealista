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
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="banco_ban_codigo_seq",allocationSize=1)
@Table(name="banco")
public class Banco implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="ban_codigo" , nullable=false)
    private Integer banCodigo;
    
    @Basic(optional=false)
    @Column(name="ban_nome",nullable=false,length=30)
    private String banNome;

     @OneToMany(mappedBy = "banCodigo", fetch = FetchType.LAZY)
    private List<Banco> bancos;
    public Banco(){

    }

    public List<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<Banco> bancos) {
        this.bancos = bancos;
    }

    public Integer getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(Integer banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getBanNome() {
        return banNome;
    }

    public void setBanNome(String banNome) {
        this.banNome = banNome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Banco other = (Banco) obj;
        if (this.banCodigo != other.banCodigo && (this.banCodigo == null || !this.banCodigo.equals(other.banCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.banCodigo != null ? this.banCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return banNome;
    }
}
