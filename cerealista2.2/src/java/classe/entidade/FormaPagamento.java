/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@SequenceGenerator(name="seq",sequenceName="forma_pagamento_for_pag_codigo_seq",allocationSize=1)
@Table(name="FORMA_PAGAMENTO")
public class FormaPagamento implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional=false)
    @Column(name="FOR_PAG_CODIGO",nullable=false)
    private Integer forPagCodigo;

    @Basic(optional=false)
    @Column(name="FOR_PAG_DESCRICAO",nullable=false,length=20)
    private String forPagDescricao;

    @OneToMany(mappedBy="forPagCodigo",fetch=FetchType.LAZY)
    private List<PagamentoOrdem> pagamentoOrdens;

    public List<PagamentoOrdem> getPagamentoOrdens() {
        return pagamentoOrdens;
    }

    public void setPagamentoOrdens(List<PagamentoOrdem> pagamentoOrdens) {
        this.pagamentoOrdens = pagamentoOrdens;
    }

            
    public FormaPagamento(){

    }

    public Integer getForPagCodigo() {
        return forPagCodigo;
    }

    public void setForPagCodigo(Integer forPagCodigo) {
        this.forPagCodigo = forPagCodigo;
    }

    public String getForPagDescricao() {
        return forPagDescricao;
    }

    public void setForPagDescricao(String forPagDescricao) {
        this.forPagDescricao = forPagDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormaPagamento other = (FormaPagamento) obj;
        if (this.forPagCodigo != other.forPagCodigo && (this.forPagCodigo == null || !this.forPagCodigo.equals(other.forPagCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.forPagCodigo != null ? this.forPagCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
        return forPagDescricao;
    }

}
