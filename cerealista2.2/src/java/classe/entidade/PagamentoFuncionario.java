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
@SequenceGenerator(name="seq",sequenceName="pagamento_funcionario_pag_fun_codigo_seq",allocationSize=1)
@Table(name="PAGAMENTO_FUNCIONARIO")
public class PagamentoFuncionario implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="PAG_FUN_CODIGO",nullable=false)
    private Integer pagFunCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="USU_CODIGO")
    private Usuario usuCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="PES_CAT_CODIGO",nullable=false)
    private PessoaCategoria pesCatCodigo;

    @Basic(optional=false)
    @Column(name="PAG_FUN_VALOR",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double pagFunValor;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="PAG_FUN_DATA",nullable=false)
    private Date pagFunData;

    public PagamentoFuncionario(){

    }

    public Integer getPagFunCodigo() {
        return pagFunCodigo;
    }

    public void setPagFunCodigo(Integer pagFunCodigo) {
        this.pagFunCodigo = pagFunCodigo;
    }

    public Date getPagFunData() {
        return pagFunData;
    }

    public void setPagFunData(Date pagFunData) {
        this.pagFunData = pagFunData;
    }

    public Double getPagFunValor() {
        return pagFunValor;
    }

    public void setPagFunValor(Double pagFunValor) {
        this.pagFunValor = pagFunValor;
    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    
}
