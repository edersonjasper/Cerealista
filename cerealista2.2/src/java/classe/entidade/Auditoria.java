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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name="seq",sequenceName="auditoria_aud_codigo_seq",allocationSize=1)
@Table(name="AUDITORIA")
public class Auditoria implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="AUD_CODIGO",nullable=false)
    private Integer audCodigo;

    @Temporal(TemporalType.DATE)
    @Basic(optional=false)
    @Column(name="AUD_DATA",nullable=false)
    private Date audData;

    @Basic(optional=false)
    @Column(name="AUD_CAMPO",nullable=false)
    private String audCampo;

    @Basic(optional=false)
    @Column(name="AUD_TABELA",nullable=false,length=30)
    private String audTabela;

    @Basic(optional=false)
    @Column(name="AUD_CODIGO_REGISTRO",nullable=false)
    private Integer audCodigoRegistro;

    @ManyToOne(optional=false)
    @JoinColumn(name="USU_CODIGO")
    private Usuario usuCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="ACA_CODIGO")
    private Acao acaCodigo;

    
    public Auditoria(){

    }

    public Integer getaudCodigoRegistro() {
        return audCodigoRegistro;
    }

    public void setaudCodigoRegistro(Integer audCodigoRegistro) {
        this.audCodigoRegistro = audCodigoRegistro;
    }

    public Acao getAcaCodigo() {
        return acaCodigo;
    }

    public void setAcaCodigo(Acao acaCodigo) {
        this.acaCodigo = acaCodigo;
    }

    public String getAudCampo() {
        return audCampo;
    }

    public void setAudCampo(String audCampo) {
        this.audCampo = audCampo;
    }

    public Integer getAudCodigo() {
        return audCodigo;
    }

    public void setAudCodigo(Integer audCodigo) {
        this.audCodigo = audCodigo;
    }

    public Date getAudData() {
        return audData;
    }

    public void setAudData(Date audData) {
        this.audData = audData;
    }

    public String getAudTabela() {
        return audTabela;
    }

    public void setAudTabela(String audTabela) {
        this.audTabela = audTabela;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    

}
