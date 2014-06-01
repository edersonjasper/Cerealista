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
@SequenceGenerator(name="seq",sequenceName="veiculo_vei_codigo_seq",allocationSize=1)
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional = false)
    @Column(name = "vei_codigo")
    private Integer veiCodigo;
    @Basic(optional = false)
    @Column(name = "vei_placa",length=8, nullable = false)
    private String veiPlaca;
    @Basic(optional = false)
    @Column(name = "vei_veiculo",length=30, nullable = false)
    private String veiVeiculo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pes_cat_codigo", nullable = false)
    private PessoaCategoria pesCatCodigo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cid_codigo", nullable = false)
    private Cidade cidCodigo;
    @OneToMany(mappedBy = "veiCodigo", fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public Veiculo() {
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Cidade getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Cidade cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }


    public Integer getVeiCodigo() {
        return veiCodigo;
    }

    public void setVeiCodigo(Integer veiCodigo) {
        this.veiCodigo = veiCodigo;
    }

    public String getVeiPlaca() {
        return veiPlaca;
    }

    public void setVeiPlaca(String veiPlaca) {
        this.veiPlaca = veiPlaca.toUpperCase();
    }

    public String getVeiVeiculo() {
        return veiVeiculo;
    }

    public void setVeiVeiculo(String veiVeiculo) {
        this.veiVeiculo = veiVeiculo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (this.veiCodigo != other.veiCodigo && (this.veiCodigo == null || !this.veiCodigo.equals(other.veiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.veiCodigo != null ? this.veiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return veiPlaca;
    }
}
