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
@SequenceGenerator(name="seq",sequenceName="acesso_ace_codigo_seq",allocationSize=1)
@Table(name = "ACESSO")
public class Acesso implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name = "ACE_CODIGO",nullable=false)
    private Integer aceCodigo;

    @Basic(optional=false)
    @Column(name = "ACE_DESCRICAO",nullable=false,length=40)
    private String aceDescricao;

//    @ManyToMany
//   @JoinTable(name="acesso_usuario",
//        joinColumns={@JoinColumn(name="ace_codigo")},
//    inverseJoinColumns={@JoinColumn(name="usu_codigo")})
//   private Set<Usuario> usuCodigo;
    
    public Acesso() {
    }

    public Integer getAceCodigo() {
        return aceCodigo;
    }

    public void setAceCodigo(Integer aceCodigo) {
        this.aceCodigo = aceCodigo;
    }

    public String getAceDescricao() {
        return aceDescricao;
    }

    public void setAceDescricao(String aceDescricao) {
        this.aceDescricao = aceDescricao;
    }
}
