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
@SequenceGenerator(name="seq",sequenceName="venda_ven_codigo_seq",allocationSize=1)
@Table(name="venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="ven_codigo",nullable=false)
    private Integer venCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="vei_codigo",nullable=false)
    private Veiculo veiCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="pes_cat_codigo",nullable=false)
    private PessoaCategoria pesCatCodigo;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="ven_data",nullable=false)
    private Date venData;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="ven_data_entrega",nullable=false)
    private Date venDAtaEntrega;

    @Basic(optional=true)
    @Column(name="ven_valor_total",nullable=true, columnDefinition = "numeric(10,2) default '0'")
    private Double venValorTotal;

    @Basic(optional=true)
    @Column(name="ven_peso_total",nullable=true, columnDefinition = "numeric(10,3) default '0'")
    private Double venPesoTotal;

    @Basic(optional=true)
    @Column(name="ven_valor_frete",nullable=true, columnDefinition = "numeric(10,2) default '0'")
    private Double venValorFrete;

    @Basic(optional=false)
    @Column(name="ven_icms",nullable=false, columnDefinition = "numeric(10,2) default '0'")
    private Double venIcms;

    @Basic(optional=true)
    @Column(name="ven_seguro",nullable=true, columnDefinition = "numeric(10,2) default '0'")
    private Double venSeguro;

    @Basic(optional=true)
    @Column(name="ven_valor_liquido", columnDefinition = "numeric(10,2) default '0'")
    private Double venValorLiquido;
    @Basic(optional=false)
    @Column(name="ven_fechada",length=1)
    private String venFechada;

    public Venda(){

    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public String getVenFechada() {
        return venFechada;
    }

    public void setVenFechada(String venFechada) {
        this.venFechada = venFechada;
    }
    

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Veiculo getVeiCodigo() {
        return veiCodigo;
    }

    public void setVeiCodigo(Veiculo veiCodigo) {
        this.veiCodigo = veiCodigo;
    }

    public Integer getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }

    public Date getVenDAtaEntrega() {
        return venDAtaEntrega;
    }

    public void setVenDAtaEntrega(Date venDAtaEntrega) {
        this.venDAtaEntrega = venDAtaEntrega;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    public Double getVenIcms() {
        return venIcms;
    }

    public void setVenIcms(Double venIcms) {
        this.venIcms = venIcms;
    }

    public Double getVenPesoTotal() {
        return venPesoTotal;
    }

    public void setVenPesoTotal(Double venPesoTotal) {
        this.venPesoTotal = venPesoTotal;
    }

    public Double getVenSeguro() {
        return venSeguro;
    }

    public void setVenSeguro(Double venSeguro) {
        this.venSeguro = venSeguro;
    }

    public Double getVenValorFrete() {
        return venValorFrete;
    }

    public void setVenValorFrete(Double venValorFrete) {
        this.venValorFrete = venValorFrete;
    }

    public Double getVenValorLiquido() {
        return venValorLiquido;
    }

    public void setVenValorLiquido(Double venValorLiquido) {
        this.venValorLiquido = venValorLiquido;
    }

    public Double getVenValorTotal() {
        return venValorTotal;
    }

    public void setVenValorTotal(Double venValorTotal) {
        this.venValorTotal = venValorTotal;
    }
    public void calculaValorLiquido(){
        venValorLiquido = getVenValorTotal() + getVenIcms() + getVenSeguro() + getVenValorFrete();
    }
    
}
