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
@SequenceGenerator(name="seq",sequenceName="ordem_produto_ord_pro_codigo_seq",allocationSize=1)
@Table(name="ordem_produto")
public class OrdemProduto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="ord_pro_codigo",nullable=false)
    private Integer ordProCodigo;

    @Basic(optional=false)
    @Column(name="ord_pro_quantidade",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double ordProQuantidade;

    @Basic(optional=false)
    @Column(name="ord_pro_valor_unitario",columnDefinition = "numeric(10,2) default '0'")
    private Double ordProValorUnitario;

    @Basic(optional=false)
    @Column(name="ord_pro_valor_total",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double ordProValorTotal;

    @Basic(optional=false)
    @Column(name="ord_pro_peso_unitario",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double ordProPesoUnitario;

    @Basic(optional=false)
    @Column(name="ord_pro_peso_total",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double ordProPesoTotal;

    @ManyToOne(optional=false)
    @JoinColumn(name="pro_codigo",nullable=false)
    private Produto proCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="ord_codigo",nullable=false)
    private Ordem ordCodigo;



    public OrdemProduto(){

    }

    public Integer getOrdProCodigo() {
        return ordProCodigo;
    }

    public void setOrdProCodigo(Integer ordProCodigo) {
        this.ordProCodigo = ordProCodigo;
    }

    public Ordem getOrdCodigo() {
        return ordCodigo;
    }

    public void setOrdCodigo(Ordem ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Produto getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Produto proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

  

    public Double getOrdProPesoTotal() {
        return ordProPesoTotal;
    }

    public void setOrdProPesoTotal(Double ordProPesoTotal) {
        this.ordProPesoTotal = ordProPesoTotal;
    }

    public Double getOrdProPesoUnitario() {
        return ordProPesoUnitario;
    }

    public void setOrdProPesoUnitario(Double ordProPesoUnitario) {
        this.ordProPesoUnitario = ordProPesoUnitario;
    }

    public Double getOrdProQuantidade() {
        return ordProQuantidade;
    }

    public void setOrdProQuantidade(Double ordProQuantidade) {
        this.ordProQuantidade = ordProQuantidade;
    }

    public Double getOrdProValorTotal() {
        return ordProValorTotal;
    }

    public void setOrdProValorTotal(Double ordProValorTotal) {
        this.ordProValorTotal = ordProValorTotal;
    }

    public Double getOrdProValorUnitario() {
        return ordProValorUnitario;
    }

    public void setOrdProValorUnitario(Double ordProValorUnitario) {
        this.ordProValorUnitario = ordProValorUnitario;
    }
    public void calculaPesoTotal(){
        ordProPesoTotal = getOrdProPesoUnitario() * getOrdProQuantidade();
    }
    public void calculaValorTotal(){
        ordProValorTotal = getOrdProValorUnitario() * getOrdProPesoTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemProduto other = (OrdemProduto) obj;
        if (this.ordProCodigo != other.ordProCodigo && (this.ordProCodigo == null || !this.ordProCodigo.equals(other.ordProCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.ordProCodigo != null ? this.ordProCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return String.valueOf(ordProCodigo);
    }
}
