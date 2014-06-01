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
@SequenceGenerator(name="seq",sequenceName="despesa_des_codigo_seq",allocationSize=1)
@Table(name="DESPESA")
public class Despesa implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="DES_CODIGO",nullable=false)
    private Integer desCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="CAT_DES_CODIGO")
    private CategoriaDespesa catDesCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="USU_CODIGO")
    private Usuario usuCodigo;

    @Basic(optional=false)
    @Column(name="DES_VALOR",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double desValor;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="DES_DATA",nullable=false)
    private Date desData;

    @Basic(optional=true)
    @Column(name="DES_DESCRICAO",length=50)
    private String desDescricao;

    public Despesa(){

    }

    public CategoriaDespesa getCatDesCodigo() {
        return catDesCodigo;
    }

    public void setCatDesCodigo(CategoriaDespesa catDesCodigo) {
        this.catDesCodigo = catDesCodigo;
    }

    public Integer getDesCodigo() {
        return desCodigo;
    }

    public void setDesCodigo(Integer desCodigo) {
        this.desCodigo = desCodigo;
    }

    public Date getDesData() {
        return desData;
    }

    public void setDesData(Date desData) {
        this.desData = desData;
    }

    public String getDesDescricao() {
        return desDescricao;
    }

    public void setDesDescricao(String desDescricao) {
        this.desDescricao = desDescricao;
    }

    public Double getDesValor() {
        return desValor;
    }

    public void setDesValor(Double desValor) {
        this.desValor = desValor;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

}
