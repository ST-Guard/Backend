package school.sptech.model;

import java.time.LocalDateTime;

public class Alerta {
    private Integer idServidor;
    private Integer idComponente;
    private String servidor;
    private String zona;
    private String datacenter;
    private String componente;
    private Double valor;
    private Double thresholdMomento;
    private Severidade severidade;
    private Integer idResponsavel;
    private String nomeResponsavel;
    private LocalDateTime timestamp;
    private String issueKey;

    public Alerta() {
    }

    public Alerta(Integer idServidor, Integer idComponente, String servidor, String zona, String datacenter, String componente, Double valor, Double thresholdMomento, Severidade severidade, Integer idResponsavel, String nomeResponsavel, LocalDateTime timestamp, String issueKey) {
        this.idServidor = idServidor;
        this.idComponente = idComponente;
        this.servidor = servidor;
        this.zona = zona;
        this.datacenter = datacenter;
        this.componente = componente;
        this.valor = valor;
        this.thresholdMomento = thresholdMomento;
        this.severidade = severidade;
        this.idResponsavel = idResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.timestamp = timestamp;
        this.issueKey = issueKey;
    }

    public String  getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Integer getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Alerta(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getThresholdMomento() {
        return thresholdMomento;
    }

    public void setThresholdMomento(Double thresholdMomento) {
        this.thresholdMomento = thresholdMomento;
    }

    public Severidade getSeveridade() {
        return severidade;
    }

    public void setSeveridade(Severidade severidade) {
        this.severidade = severidade;
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
