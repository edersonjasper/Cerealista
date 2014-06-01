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
//define que ira somente inserir e atualizar o que for modificado, e não todos os registros mesmo que não tenha modificado
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="usuario_usu_codigo_seq",allocationSize=1)
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name = "usu_codigo", nullable = false)
    private Integer usuCodigo;
    @Basic(optional = false)
    @Column(name = "usu_usuario", nullable = false,length=20)
    private String usuUsuario;
    @Basic(optional = false)
    @Column(name = "usu_senha", nullable = false,length=20)
    private String usuSenha;
    @Basic(optional = false)
    @Column(name = "usu_nome", nullable = false,length=40)
    private String usuNome;
    @Basic(optional = false)
    @Column(name = "usu_status", nullable = false,length=1)
    private String usuStatus;
//    @ManyToMany
//    @JoinTable(name = "acesso_usuario",
//    joinColumns = {@JoinColumn(name = "usu_codigo")},
//    inverseJoinColumns = {@JoinColumn(name = "ace_codigo")})
//    private Set<Acesso> aceCodigo;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Auditoria> auditorias;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Despesa> despesas;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Ordem> ordens;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<PagamentoFuncionario> pagamentoFuncionarios;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Caixa> caixa;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Quebra> quebras;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<PagamentoOrdem> pagamentoOrdens;
    @OneToMany(mappedBy = "usuCodigo", fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public String getUsuStatus() {
        return usuStatus;
    }

    public void setUsuStatus(String usuStatus) {
        this.usuStatus = usuStatus;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<PagamentoOrdem> getPagamentoOrdens() {
        return pagamentoOrdens;
    }

    public void setPagamentoOrdens(List<PagamentoOrdem> pagamentoOrdens) {
        this.pagamentoOrdens = pagamentoOrdens;
    }

    public List<Quebra> getQuebras() {
        return quebras;
    }

    public void setQuebras(List<Quebra> quebras) {
        this.quebras = quebras;
    }

    public List<Caixa> getCaixa() {
        return caixa;
    }

    public void setCaixa(List<Caixa> caixa) {
        this.caixa = caixa;
    }

    public List<PagamentoFuncionario> getPagamentoFuncionarios() {
        return pagamentoFuncionarios;
    }

    public void setPagamentoFuncionarios(List<PagamentoFuncionario> pagamentoFuncionarios) {
        this.pagamentoFuncionarios = pagamentoFuncionarios;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public Boolean isValidPassword(String password) {
        return password.equals(usuSenha);
    }

    public Usuario() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.usuCodigo != other.usuCodigo && (this.usuCodigo == null || !this.usuCodigo.equals(other.usuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.usuCodigo != null ? this.usuCodigo.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString(){
       return usuNome;
    }
}
