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
@SequenceGenerator(name="seq",sequenceName="saldo_caixa_sal_cai_codigo_seq",allocationSize=1)
@Table(name = "saldo_caixa")
public class SaldoCaixa implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="sal_cai_codigo",nullable=false)
    private Integer salCaiCodigo;

    @Basic(optional=false)
    @Column(name="sal_cai_valor",nullable=false,columnDefinition = "numeric(10,2) default '0'")
    private Double salCaiValor;

    @Basic(optional=false)
    @Column(name="sal_cai_tabela",nullable=false,length=30)
    private String salCaiTabela;

    @Basic(optional=false)
    @Temporal(TemporalType.DATE)
    @Column(name="sal_cai_data",nullable=false)
    private Date salCaiData;

    public Integer getSalCaiCodigo() {
        return salCaiCodigo;
    }

    public void setSalCaiCodigo(Integer salCaiCodigo) {
        this.salCaiCodigo = salCaiCodigo;
    }

    public Date getSalCaiData() {
        return salCaiData;
    }

    public void setSalCaiData(Date salCaiData) {
        this.salCaiData = salCaiData;
    }

    public Double getSalCaiValor() {
        return salCaiValor;
    }

    public void setSalCaiValor(Double salCaiValor) {
        this.salCaiValor = salCaiValor;
    }

    public String getSalCaiTabela() {
        return salCaiTabela;
    }

    public void setSalCaiTabela(String salCaiTabela) {
        this.salCaiTabela = salCaiTabela;
    }
    
    
    public SaldoCaixa() {
    }
}
