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
@SequenceGenerator(name="seq",sequenceName="quebra_que_codigo_seq",allocationSize=1)
@Table(name="quebra")
public class Quebra  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="que_codigo")
    private Integer queCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="usu_codigo",nullable=false)
    private Usuario usuCodigo;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="pro_codigo",nullable=false)
    private Produto proCodigo;

    @Basic(optional=false)
    @Column(name="que_quantidade",columnDefinition = "numeric(10,2) default '0'")
    private Double queQuantidade;

    @Basic(optional=false)
    @Column(name="que_peso_unitario",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double quePesoUnitario;

    @Basic(optional=false)
    @Column(name="que_peso_total",nullable=false,columnDefinition = "numeric(10,3) default '0'")
    private Double quePesoTotal;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="que_data",nullable=false)
    private Date queData;

    public Quebra(){

    }

    public Produto getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Produto proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Integer getQueCodigo() {
        return queCodigo;
    }

    public void setQueCodigo(Integer queCodigo) {
        this.queCodigo = queCodigo;
    }

    public Date getQueData() {
        return queData;
    }

    public void setQueData(Date queData) {
        this.queData = queData;
    }

    public Double getQuePesoTotal() {
        return quePesoTotal;
    }

    public void setQuePesoTotal(Double quePesoTotal) {
        this.quePesoTotal = quePesoTotal;
    }

    public Double getQuePesoUnitario() {
        return quePesoUnitario;
    }

    public void setQuePesoUnitario(Double quePesoUnitario) {
        this.quePesoUnitario = quePesoUnitario;
    }

    public Double getQueQuantidade() {
        return queQuantidade;
    }

    public void setQueQuantidade(Double queQuantidade) {
        this.queQuantidade = queQuantidade;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    public void calculaPesoTotal(){
        quePesoTotal = getQueQuantidade() * getQuePesoUnitario();
    }
}
