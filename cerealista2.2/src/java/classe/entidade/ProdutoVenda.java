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
@SequenceGenerator(name="seq",sequenceName="produto_venda_pro_ven_codigo_seq",allocationSize=1)
@Table(name="produto_venda")
public class ProdutoVenda implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="pro_ven_codigo",nullable=false)
    private Integer proVenCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="pro_codigo",nullable=false)
    private Produto proCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="ven_codigo",nullable=false)
    private Venda venCodigo;

    @Basic(optional=false)
    @Column(name="pro_ven_quantidade",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double proVenQuatidade;

    @Basic(optional=false)
    @Column(name="pro_ven_peso_unitario",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double proVenPesoUnitario;

    @Basic(optional=false)
    @Column(name="pro_ven_peso_total",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double proVenPesoTotal;

    @Basic(optional=false)
    @Column(name="pro_ven_valor_unitario",columnDefinition = "numeric(10,2) default '0'")
    private Double proVenValorUnitario;

    @Basic(optional=false)
    @Column(name="pro_ven_valor_total",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double proVenValorTotal;

    @Basic(optional=true)
    @Column(name="pro_ven_nome_fornecedor",nullable=true,length=30)
    private String proVenNomeFornecedor;

    public ProdutoVenda (){

    }

    public String getProVenNomeFornecedor() {
        return proVenNomeFornecedor;
    }

    public void setProVenNomeFornecedor(String proVenNomeFornecedor) {
        this.proVenNomeFornecedor = proVenNomeFornecedor;
    }

    public Produto getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Produto proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Integer getProVenCodigo() {
        return proVenCodigo;
    }

    public void setProVenCodigo(Integer proVenCodigo) {
        this.proVenCodigo = proVenCodigo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public Venda getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(Venda venCodigo) {
        this.venCodigo = venCodigo;
    }

   

    public Double getProVenPesoTotal() {
        return proVenPesoTotal;
    }

    public void setProVenPesoTotal(Double proVenPesoTotal) {
        this.proVenPesoTotal = proVenPesoTotal;
    }

    public Double getProVenPesoUnitario() {
        return proVenPesoUnitario;
    }

    public void setProVenPesoUnitario(Double proVenPesoUnitario) {
        this.proVenPesoUnitario = proVenPesoUnitario;
    }

    public Double getProVenQuatidade() {
        return proVenQuatidade;
    }

    public void setProVenQuatidade(Double proVenQuatidade) {
        this.proVenQuatidade = proVenQuatidade;
    }

    public Double getProVenValorTotal() {
        return proVenValorTotal;
    }

    public void setProVenValorTotal(Double proVenValorTotal) {
        this.proVenValorTotal = proVenValorTotal;
    }

    public Double getProVenValorUnitario() {
        return proVenValorUnitario;
    }

    public void setProVenValorUnitario(Double proVenValorUnitario) {
        this.proVenValorUnitario = proVenValorUnitario;
    }

    public void calculaPesoTotal(){
        proVenPesoTotal = getProVenPesoUnitario() * getProVenQuatidade();
    }
    public void calculaValorTotal(){
        proVenValorTotal = getProVenValorUnitario() * getProVenQuatidade();
    }
    
}
