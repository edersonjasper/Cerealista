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
@SequenceGenerator(name="seq",sequenceName="caixa_cai_codigo_seq",allocationSize=1)
@Table(name="caixa")
public class Caixa implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="cai_codigo",nullable=false)
    private Integer caiCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;

   @ManyToOne(optional=false)
    @JoinColumn(name="pes_cat_codigo",nullable=false)
    private PessoaCategoria pesCatCodigo;

    @Basic(optional=false)
    @Column(name="cai_valor_depositado",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double caiValorDepositado;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="cai_data",nullable=false)
    private Date caiData;

    
    public Caixa(){

    }

    public Integer getCaiCodigo() {
        return caiCodigo;
    }

    public void setCaiCodigo(Integer caiCodigo) {
        this.caiCodigo = caiCodigo;
    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public Date getCaiData() {
        return caiData;
    }

    public void setCaiData(Date caiData) {
        this.caiData = caiData;
    }

    public Double getCaiValorDepositado() {
        return caiValorDepositado;
    }

    public void setCaiValorDepositado(Double caiValorDepositado) {
        this.caiValorDepositado = caiValorDepositado;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

}
