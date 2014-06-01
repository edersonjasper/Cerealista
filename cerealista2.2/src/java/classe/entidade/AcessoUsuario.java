/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="acesso_usuario_ace_usu_codigo_seq",allocationSize=1)
@Table(name = "acesso_usuario")
public class AcessoUsuario implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="ace_usu_codigo",nullable=false)
    private Integer aceUsuCodigo;

    @ManyToOne(optional=true)
    @JoinColumn(name="ace_codigo",nullable=false)
    private Acesso aceCodigo;

    @ManyToOne(optional=true)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;


    public AcessoUsuario(){

    }

    public Acesso getAceCodigo() {
        return aceCodigo;
    }

    public void setAceCodigo(Acesso aceCodigo) {
        this.aceCodigo = aceCodigo;
    }

    public Integer getAceUsuCodigo() {
        return aceUsuCodigo;
    }

    public void setAceUsuCodigo(Integer aceUsuCodigo) {
        this.aceUsuCodigo = aceUsuCodigo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    

}
