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
@SequenceGenerator(name="seq",sequenceName="pagamento_ordem_pag_ord_codigo_seq",allocationSize=1)
@Table(name="pagamento_ordem")
public class PagamentoOrdem implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="pag_ord_codigo",nullable=false)
    private Integer pagOrdCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="for_pag_codigo",nullable=false)
    private FormaPagamento forPagCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="ord_codigo",nullable=false)
    private Ordem ordCodigo;

    @Basic(optional=false)
    @Column(name="pag_ord_valor",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double pagOrdValor;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="pag_ord_data",nullable=false)
    private Date pagOrdData;

    @Basic(optional=true)
    @Column(name="pag_ord_valor_acumulado",columnDefinition = "numeric(10,2) default '0'")
    private Double pagOrdValorAcumulado;

    public FormaPagamento getForPagCodigo() {
        return forPagCodigo;
    }

    public void setForPagCodigo(FormaPagamento forPagCodigo) {
        this.forPagCodigo = forPagCodigo;
    }

    public Ordem getOrdCodigo() {
        return ordCodigo;
    }

    public void setOrdCodigo(Ordem ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Integer getPagOrdCodigo() {
        return pagOrdCodigo;
    }

    public void setPagOrdCodigo(Integer pagOrdCodigo) {
        this.pagOrdCodigo = pagOrdCodigo;
    }

    public Date getPagOrdData() {
        return pagOrdData;
    }

    public void setPagOrdData(Date pagOrdData) {
        this.pagOrdData = pagOrdData;
    }

    public Double getPagOrdValor() {
        return pagOrdValor;
    }

    public void setPagOrdValor(Double pagOrdValor) {
        this.pagOrdValor = pagOrdValor;
    }

    public Double getPagOrdValorAcumulado() {
        return pagOrdValorAcumulado;
    }

    public void setPagOrdValorAcumulado(Double pagOrdValorAcumulado) {
        this.pagOrdValorAcumulado = pagOrdValorAcumulado;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public void calculaValorAcumulado(){
        pagOrdValorAcumulado = getPagOrdValorAcumulado() + getPagOrdValor();
    }
    public PagamentoOrdem(){

    }

}
