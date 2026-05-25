package school.sptech.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "registros_alertas")
public class RegistroAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro")
    private Integer idRegistro;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "threshold_momento")
    private Double threshold_momento;

    @Column(name = "issue_key")
    private String issueKey;

    @Column(name = "aberto_em")
    private LocalDateTime abertoEm;

    @Column(name = "resolvido_em")
    private LocalDateTime resolvidoEm;

    @Column(name = "mttr_minutos")
    private Integer mttrMinutos;

    @Column(name = "sla_ok")
    private Boolean slaOK;

    @Column(name = "fk_responsavel")
    private Integer fkResponsavel;

    @Column(name = "fkRegistroServidor")
    private Integer fkServidor;

    @Column(name = "fkRegistroComponente")
    private Integer fkComponente;

    @Enumerated(EnumType.STRING)
    @Column(name = "severidade")
    private Severidade severidade;

    @Column(name = "dataHora")
    private LocalDateTime dataHora;

    public RegistroAlerta() {
    }

    public RegistroAlerta(Integer idRegistro, Double valor, Double threshold_momento, String issueKey, LocalDateTime abertoEm, LocalDateTime resolvidoEm, Integer mttrMinutos, Boolean slaOK, Integer fkResponsavel, Integer fkServidor, Integer fkComponente, Severidade severidade, LocalDateTime dataHora) {
        this.idRegistro = idRegistro;
        this.valor = valor;
        this.threshold_momento = threshold_momento;
        this.issueKey = issueKey;
        this.abertoEm = abertoEm;
        this.resolvidoEm = resolvidoEm;
        this.mttrMinutos = mttrMinutos;
        this.slaOK = slaOK;
        this.fkResponsavel = fkResponsavel;
        this.fkServidor = fkServidor;
        this.fkComponente = fkComponente;
        this.severidade = severidade;
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getThreshold_momento() {
        return threshold_momento;
    }

    public void setThreshold_momento(Double threshold_momento) {
        this.threshold_momento = threshold_momento;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public LocalDateTime getAbertoEm() {
        return abertoEm;
    }

    public void setAbertoEm(LocalDateTime abertoEm) {
        this.abertoEm = abertoEm;
    }

    public LocalDateTime getResolvidoEm() {
        return resolvidoEm;
    }

    public void setResolvidoEm(LocalDateTime resolvidoEm) {
        this.resolvidoEm = resolvidoEm;
    }

    public Integer getMttrMinutos() {
        return mttrMinutos;
    }

    public void setMttrMinutos(Integer mttrMinutos) {
        this.mttrMinutos = mttrMinutos;
    }

    public Boolean getSlaOK() {
        return slaOK;
    }

    public void setSlaOK(Boolean slaOK) {
        this.slaOK = slaOK;
    }

    public Integer getFkResponsavel() {
        return fkResponsavel;
    }

    public void setFkResponsavel(Integer fkResponsavel) {
        this.fkResponsavel = fkResponsavel;
    }

    public Integer getFkServidor() {
        return fkServidor;
    }

    public void setFkServidor(Integer fkServidor) {
        this.fkServidor = fkServidor;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }

    public Severidade getSeveridade() {
        return severidade;
    }

    public void setSeveridade(Severidade severidade) {
        this.severidade = severidade;
    }
}
