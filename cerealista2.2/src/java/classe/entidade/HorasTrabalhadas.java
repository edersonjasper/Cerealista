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
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@SequenceGenerator(name="seq",sequenceName="horas_trabalhadas_hor_tra_codigo_seq",allocationSize=1)
@Table(name = "horas_trabalhadas")
public class HorasTrabalhadas  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Basic(optional = false)
    @Column(name = "hor_tra_codigo", nullable = false)
    private Integer horTraCodigo;
    @Basic(optional = false)
    @Column(name = "hor_tra_horas_trabalhadas", nullable = false, columnDefinition = "numeric(10,2) default '0'")
    private Double horTraHorasTrabalhadas;
    @Basic(optional = false)
    @Column(name = "hor_tra_valor_hora", nullable = false, columnDefinition = "numeric(10,2) default '0'")
    private Double horTraValorHora;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "hor_tra_data", nullable = false)
    private Date horTraData;
    @Basic(optional = true)
    @Column(name = "hor_tra_descricao", nullable = true,length=50)
    private String horTraDescricao;
    @Basic(optional = false)
    @Column(name = "hor_tra_valor_total", nullable = false, columnDefinition = "numeric(10,2) default '0'")
    private Double horTraValorTotal;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pes_cat_codigo", nullable = false)
    private PessoaCategoria pesCatCodigo;

    public HorasTrabalhadas() {
    }

    public Integer getHorTraCodigo() {
        return horTraCodigo;
    }

    public void setHorTraCodigo(Integer horTraCodigo) {
        this.horTraCodigo = horTraCodigo;
    }

    public Date getHorTraData() {
        return horTraData;
    }

    public void setHorTraData(Date horTraData) {
        this.horTraData = horTraData;
    }

    public String getHorTraDescricao() {
        return horTraDescricao;
    }

    public void setHorTraDescricao(String horTraDescricao) {
        this.horTraDescricao = horTraDescricao;
    }

    public Double getHorTraHorasTrabalhadas() {
        return horTraHorasTrabalhadas;
    }

    public void setHorTraHorasTrabalhadas(Double horTraHorasTrabalhadas) {
        this.horTraHorasTrabalhadas = horTraHorasTrabalhadas;
    }

    public Double getHorTraValorHora() {
        return horTraValorHora;
    }

    public void setHorTraValorHora(Double horTraValorHora) {
        this.horTraValorHora = horTraValorHora;
    }

    public Double getHorTraValorTotal() {
        return horTraValorTotal;
    }

    public void setHorTraValorTotal(Double horTraValorTotal) {
        this.horTraValorTotal = horTraValorTotal;
    }

    public PessoaCategoria getPesCatCodigo() {
        return pesCatCodigo;
    }

    public void setPesCatCodigo(PessoaCategoria pesCatCodigo) {
        this.pesCatCodigo = pesCatCodigo;
    }

    public void calculaValorHorasTrabalhadas() {
        Boolean t = true;
        Boolean h = false;
        Boolean m = false;
        String hora = "";
        String min = "0.";
        Double vH = 0.0;
        Double vM = 0.0;
        Double vT = 0.0;

        String hor = String.valueOf(horTraHorasTrabalhadas);
        for (int i = 0; i < hor.length();) {
            if (hor.substring(i, i + 1).equals(".")) {
                t = false;
            } else if (t) {
                hora = hora + hor.substring(i, i + 1);
                h = true;
            } else {
                min = min + hor.substring(i, i + 1);
                m = true;
            }
            i++;
        }
        if (h) {
            vH = Double.valueOf(hora) * getHorTraValorHora();
        }
        if (m) {
            vM = (((100.0 / 60.0) * Double.valueOf(min)) * getHorTraValorHora());
        }
        vT = vH + vM;


        horTraValorTotal = vT;
    }
}
