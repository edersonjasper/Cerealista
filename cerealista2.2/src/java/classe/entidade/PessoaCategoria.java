/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classe.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="pessoa_categoria_pes_cat_codigo_seq",allocationSize=1)
@Table(name = "pessoa_categoria")
public class PessoaCategoria implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name="pes_cat_codigo", nullable=false)
    private Integer pesCatCodigo;

    @ManyToOne
    @JoinColumn(name="cat_codigo", nullable=false)
    private Categoria catCodigo;

    @ManyToOne
    @JoinColumn(name="pes_codigo", nullable=false)
    private Pessoa pesCodigo;


    @OneToMany(mappedBy = "pesCatCodigo", fetch = FetchType.LAZY)
    private List<HorasTrabalhadas> horasTrabalhadas;


    @OneToMany(mappedBy = "pesCatCodigo", fetch = FetchType.LAZY)
    private List<Ordem> ordens;

    @OneToMany(mappedBy = "pesCatCodigo", fetch = FetchType.LAZY)
    private List<Ordem> caixa;


    @OneToMany(mappedBy = "pesCatCodigo", fetch = FetchType.LAZY)
    private List<PagamentoFuncionario> pagamentoFuncionarios;

    @OneToMany(mappedBy = "pesCatCodigo", fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public PessoaCategoria(){

    }

    public Categoria getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(Categoria catCodigo) {
        this.catCodigo = catCodigo;
    }

    public Integer getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(Integer pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public Pessoa getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Pessoa pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public List<HorasTrabalhadas> getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(List<HorasTrabalhadas> horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public List<Ordem> getCaixa() {
        return caixa;
    }

    public void setCaixa(List<Ordem> caixa) {
        this.caixa = caixa;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }

    public List<PagamentoFuncionario> getPagamentoFuncionarios() {
        return pagamentoFuncionarios;
    }

    public void setPagamentoFuncionarios(List<PagamentoFuncionario> pagamentoFuncionarios) {
        this.pagamentoFuncionarios = pagamentoFuncionarios;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaCategoria other = (PessoaCategoria) obj;
        if (this.pesCatCodigo != other.pesCatCodigo && (this.pesCatCodigo == null || !this.pesCatCodigo.equals(other.pesCatCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.pesCatCodigo != null ? this.pesCatCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        return String.valueOf(pesCodigo);
    }
}
