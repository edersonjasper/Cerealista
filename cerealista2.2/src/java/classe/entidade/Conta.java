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
@SequenceGenerator(name="seq",sequenceName="conta_con_codigo_seq",allocationSize=1)
@Table(name="conta")
public class Conta implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="con_codigo", nullable=false)
    private Integer conCodigo;

    @Basic(optional=false)
    @Column(name="con_numero_conta", nullable=false,length=10)
    private String conNumeroConta;

    @Basic(optional=false)
    @Column(name="con_agencia",nullable=false,length=7)
    private String conAgencia;

    @Basic(optional=false)
    @Column(name="con_operacao",nullable=false,length=20)
    private String conOperacao;

    @Basic(optional=true)
    @Column(name="con_numero_banco",nullable=true,length=6)
    private Integer conNumeroBanco;

    @Basic(optional=false)
    @Column(name="con_nome_deposito",nullable=false,length=40)
    private String conNomeDeposito;

    @ManyToOne(optional=false)
    @JoinColumn(name="pes_codigo",nullable=false)
    private Pessoa pesCodigo;

    @ManyToOne(optional=false)
    @JoinColumn(name="ban_codigo",nullable=false)
    private Banco banCodigo;

    public Conta(){

    }

    public Banco getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(Banco banCodigo) {
        this.banCodigo = banCodigo;
    }

    public String getConAgencia() {
        return conAgencia;
    }

    public void setConAgencia(String conAgencia) {
        this.conAgencia = conAgencia;
    }

    public Integer getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(Integer conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConNomeDeposito() {
        return conNomeDeposito;
    }

    public void setConNomeDeposito(String conNomeDeposito) {
        this.conNomeDeposito = conNomeDeposito;
    }

    public Integer getConNumeroBanco() {
        return conNumeroBanco;
    }

    public void setConNumeroBanco(Integer conNumeroBanco) {
        this.conNumeroBanco = conNumeroBanco;
    }

    public String getConNumeroConta() {
        return conNumeroConta;
    }

    public void setConNumeroConta(String conNumeroConta) {
        this.conNumeroConta = conNumeroConta;
    }

    public String getConOperacao() {
        return conOperacao;
    }

    public void setConOperacao(String conOperacao) {
        this.conOperacao = conOperacao;
    }

    public Pessoa getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Pessoa pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.conCodigo != other.conCodigo && (this.conCodigo == null || !this.conCodigo.equals(other.conCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.conCodigo != null ? this.conCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return conNomeDeposito;
    }
    

}
