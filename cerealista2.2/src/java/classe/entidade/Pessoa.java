/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="pessoa_pes_codigo_seq",allocationSize=1)
@Table(name = "pessoa")
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name = "pes_codigo", nullable = false)
    private Integer pesCodigo;
    @Basic(optional = false)
    @Column(name = "PES_NOME", nullable = false,length=40)
    private String pesNome;
    @Basic(optional = false)
    @Column(name = "PES_SEXO", nullable = false,length=1)
    private String pesSexo;
    @Basic(optional = false)
    @Column(name = "PES_CPF_CNPJ", nullable = false,length=18)
    private String pesCpfCnpj;
    @Basic(optional = true)
    @Column(name = "PES_IE", nullable = true,length=11)
    private String pesIe;
    @Basic(optional = false)
    @Column(name = "PES_ENDERECO", nullable = false,length=50)
    private String pesEndereco;
    @Basic(optional = false)
    @Column(name = "PES_BAIRRO", nullable = false,length=40)
    private String pesBairro;
    @Basic(optional = true)
    @Column(name = "PES_NUMERO", nullable = true,length=6)
    private Integer pesNumero;
    @Basic(optional = false)
    @Column(name = "PES_CEP", nullable = false,length=9)
    private String pesCep;
    @Basic(optional = true)
    @Temporal(TemporalType.DATE)
    @Column(name = "PES_NASCIMENTO", nullable = true)
    private Date pesNascimento;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CID_CODIGO")
    private Cidade cidCodigo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "USU_CODIGO")
    private Usuario usuCodigo;
    @Basic(optional = false)
    @Column(name = "PES_OCULTO", nullable = false,length=1)
    private String pesOculto;
    @Basic(optional = false)
    @Column(name = "pes_tipo", nullable = false,length=1)
    private String pesTipo;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "pessoa_categoria",
//        joinColumns = {@JoinColumn(name = "pes_codigo")},
//        inverseJoinColumns={@JoinColumn(name="cat_codigo")})
//    private Set<Categoria> catCodigo;
    @OneToMany(mappedBy = "pesCodigo", fetch = FetchType.LAZY)
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "pesCodigo", fetch = FetchType.LAZY)
    private List<Conta> contas;

    public Pessoa() {
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public String getPesTipo() {
        return pesTipo;
    }

    public void setPesTipo(String pesTipo) {
        this.pesTipo = pesTipo;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Cidade getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Cidade cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getPesBairro() {
        return pesBairro;
    }

    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    public String getPesCep() {
        return pesCep;
    }

    public void setPesCep(String pesCep) {
        this.pesCep = pesCep;
    }

    public Integer getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Integer pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public String getPesCpfCnpj() {
        return pesCpfCnpj;
    }

    public void setPesCpfCnpj(String pesCpfCnpj) {
        this.pesCpfCnpj = pesCpfCnpj;
    }

    public String getPesEndereco() {
        return pesEndereco;
    }

    public void setPesEndereco(String pesEndereco) {
        this.pesEndereco = pesEndereco;
    }

    public String getPesIe() {
        return pesIe;
    }

    public void setPesIe(String pesIe) {
        this.pesIe = pesIe;
    }

    public Date getPesNascimento() {
        return pesNascimento;
    }

    public void setPesNascimento(Date pesNascimento) {
        this.pesNascimento = pesNascimento;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Integer getPesNumero() {
        return pesNumero;
    }

    public void setPesNumero(Integer pesNumero) {
        this.pesNumero = pesNumero;
    }

    public String getPesOculto() {
        return pesOculto;
    }

    public void setPesOculto(String pesOculto) {
        this.pesOculto = pesOculto;
    }

    public String getPesSexo() {
        return pesSexo;
    }

    public void setPesSexo(String pesSexo) {
        this.pesSexo = pesSexo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.pesCodigo != other.pesCodigo && (this.pesCodigo == null || !this.pesCodigo.equals(other.pesCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.pesCodigo != null ? this.pesCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return pesNome;
    }
}
