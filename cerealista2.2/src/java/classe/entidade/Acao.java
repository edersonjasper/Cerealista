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
@SequenceGenerator(name="seq",sequenceName="acao_aca_codigo_seq",allocationSize=1)
@Table(name="ACAO")
public class Acao implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="ACA_CODIGO",nullable=false)
    private Integer acaCodigo;

    @Basic(optional=false)
    @Column(name="ACA_DESCRICAO",nullable=false,length=20)
    private String acaDescricao;

    @OneToMany(mappedBy="acaCodigo",fetch=FetchType.LAZY)
    private List<Auditoria> auditoras;

    public Acao(){
    }

    public List<Auditoria> getAuditoras() {
        return auditoras;
    }

    public void setAuditoras(List<Auditoria> auditoras) {
        this.auditoras = auditoras;
    }

    
    public Integer getAcaCodigo() {
        return acaCodigo;
    }

    public void setAcaCodigo(Integer acaCodigo) {
        this.acaCodigo = acaCodigo;
    }

    public String getAcaDescricao() {
        return acaDescricao;
    }

    public void setAcaDescricao(String acaDescricao) {
        this.acaDescricao = acaDescricao;
    }

}
