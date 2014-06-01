/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classe.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eder
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="ordem_ord_codigo_seq",allocationSize=1)
@Table(name = "ordem")
public class Ordem implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name = "ORD_CODIGO", nullable = false)
    private Integer ordCodigo;
    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    private Usuario usuCodigo;
    @ManyToOne
    @JoinColumn(name = "pes_cat_codigo")
    private PessoaCategoria pesCatCodigo;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORD_DATA", nullable = false)
    private Date ordData;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORD_DATA_VENCIMENTO", nullable = false)
    private Date ordDataVencimento;
    @Column(name = "ORD_PESO_TOTAL", nullable = true, columnDefinition = "numeric(10,3) default '0'")
    private Double ordPesoTotal;
    @Column(name = "ORD_VALOR_TOTAL", nullable = true, columnDefinition = "numeric(10,2) default '0'")
    private Double ordValorTotal;
    @Column(name = "ORD_FUNDO_RURAL", nullable = true, columnDefinition = "numeric(10,2) default '0'")
    private Double ordFundoRural;
    @Column(name = "ORD_DESCONTO", nullable = true, columnDefinition = "numeric(10,2) default '0'")
    private Double ordDesconto;
    @Column(name = "ORD_ADIANTAMENTO", nullable = true, columnDefinition = "numeric(10,2) default '0'")
    private Double ordAdiantemento;
    @Column(name = "ORD_VALOR_RESTANTE", nullable = true, columnDefinition = "numeric(10,2) default '0'")
    private Double ordValorRestante;
    @Column(name="ord_pago",length=1)
    private String ordPago;
    @Column(name="ord_aberta",length=1)
    private String ordAberta;
    @Column(name="ord_nota_fornecedor",length=10)
    private Integer ordNotaFornecedor;

    @OneToMany(mappedBy = "ordCodigo", fetch = FetchType.LAZY)
    private List<PagamentoOrdem> pagamentoOrdens;

    public Ordem() {
    }

    public List<PagamentoOrdem> getPagamentoOrdens() {
        return pagamentoOrdens;
    }

    public void setPagamentoOrdens(List<PagamentoOrdem> pagamentoOrdens) {
        this.pagamentoOrdens = pagamentoOrdens;
    }

    public String getOrdPago() {
        return ordPago;
    }

    public void setOrdPago(String ordPago) {
        this.ordPago = ordPago;
    }

    public Double getOrdAdiantemento() {
        return ordAdiantemento;
    }

    public String getOrdAberta() {
        return ordAberta;
    }

    public void setOrdAberta(String ordAberta) {
        this.ordAberta = ordAberta;
    }
    

    public void setOrdAdiantemento(Double ordAdiantemento) {
        this.ordAdiantemento = ordAdiantemento;
    }

    public Integer getOrdCodigo() {
        return ordCodigo;
    }

    public void setOrdCodigo(Integer ordCodigo) {
        this.ordCodigo = ordCodigo;
    }

    public Date getOrdData() {
        return ordData;
    }

    public void setOrdData(Date ordData) {
        this.ordData = ordData;
    }

    public Date getOrdDataVencimento() {
        return ordDataVencimento;
    }

    public void setOrdDataVencimento(Date ordDataVencimento) {
        this.ordDataVencimento = ordDataVencimento;
    }

    public Double getOrdDesconto() {
        return ordDesconto;
    }

    public void setOrdDesconto(Double ordDesconto) {
        this.ordDesconto = ordDesconto;
    }

    public Double getOrdFundoRural() {
        return ordFundoRural;
    }

    public void setOrdFundoRural(Double ordFundoRural) {
        this.ordFundoRural = ordFundoRural;
    }

    public Double getOrdPesoTotal() {
        return ordPesoTotal;
    }

    public void setOrdPesoTotal(Double ordPesoTotal) {
        this.ordPesoTotal = ordPesoTotal;
    }

    public Double getOrdValorRestante() {
        return ordValorRestante;
    }

    public void setOrdValorRestante(Double ordValorRestante) {
        this.ordValorRestante = ordValorRestante;
    }

    public Double getOrdValorTotal() {
        return ordValorTotal;
    }

    public void setOrdValorTotal(Double ordValorTotal) {
        this.ordValorTotal = ordValorTotal;
    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public Usuario getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Usuario usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public void calculaOrdValorTotal() {
    }

    public Integer getOrdNotaFornecedor() {
        return ordNotaFornecedor;
    }

    public void setOrdNotaFornecedor(Integer ordNotaFornecedor) {
        this.ordNotaFornecedor = ordNotaFornecedor;
    }

    public void calculaOrdValorRestante() {
        ordValorRestante = 0.0;
        if (getOrdValorTotal() != null && getOrdFundoRural() != null && getOrdDesconto() != null && getOrdAdiantemento() != null) {
            ordValorRestante = getOrdValorTotal() - getOrdFundoRural() - getOrdDesconto() - getOrdAdiantemento();
        }
    }
}
