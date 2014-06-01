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
@SequenceGenerator(name="seq",sequenceName="telefone_tel_codigo_seq",allocationSize=1)
@Table(name="telefone")
public class Telefone  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="tel_codigo",nullable=false)
    private Integer telCodigo;

    @Basic(optional=false)
    @Column(name="tel_numero",nullable=false,length=20)
    private String telNumero;

    @Basic(optional=true)
    @Column(name="tel_contato",nullable=true,length=30)
    private String telContato;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="tip_codigo")
    private TipoTelefone tipCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="pes_codigo")
    private Pessoa pesCodigo;


    public Telefone(){

    }

    public Pessoa getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Pessoa pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public Integer getTelCodigo() {
        return telCodigo;
    }

    public void setTelCodigo(Integer telCodigo) {
        this.telCodigo = telCodigo;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getTelNumero() {
        return telNumero;
    }

    public void setTelNumero(String telNumero) {
        this.telNumero = telNumero;
    }

    public TipoTelefone getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(TipoTelefone tipCodigo) {
        this.tipCodigo = tipCodigo;
    }
    
}
