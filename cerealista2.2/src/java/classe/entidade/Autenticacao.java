/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="autenticacao_aut_codigo_seq",allocationSize=1)
@Table(name = "AUTENTICACAO")
public class Autenticacao implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="AUT_CODIGO",nullable=false)
    private Integer autCodigo;

    @Basic(optional=false)
    @Column(name="aut_data",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date autData;

    @Basic(optional=false)
    @Column(name="AUT_USUARIO",nullable=false,length=20)
    private String autUsuario;

    @Basic(optional=false)
    @Column(name="AUT_SENHA",nullable=false,length=20)
    private String autSenha;

    @Basic(optional=false)
    @Column(name="AUT_ACERTO",nullable=false,length=1)
    private String autAcerto;

    @Basic(optional=false)
    @Column(name="USU_CODIGO",nullable=false)
    private String usuCodigo;

    public Autenticacao() {
    }

    public String getAutAcerto() {
        return autAcerto;
    }

    public void setAutAcerto(String autAcerto) {
        this.autAcerto = autAcerto;
    }

    public Integer getAutCodigo() {
        return autCodigo;
    }

    public void setAutCodigo(Integer autCodigo) {
        this.autCodigo = autCodigo;
    }

    public Date getAutData() {
        return autData;
    }

    public void setAutData(Date autData) {
        this.autData = autData;
    }

    public String getAutSenha() {
        return autSenha;
    }

    public void setAutSenha(String autSenha) {
        this.autSenha = autSenha;
    }

    public String getAutUsuario() {
        return autUsuario;
    }

    public void setAutUsuario(String autUsuario) {
        this.autUsuario = autUsuario;
    }

    public String getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(String usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    
}
