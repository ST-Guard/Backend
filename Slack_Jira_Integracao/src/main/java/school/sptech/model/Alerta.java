package school.sptech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alerta {

    @JsonProperty("id_servidor")
    private Integer idServidor;

    @JsonProperty("id_componente")
    private Integer idComponente;

    @JsonProperty("servidor")
    private String servidor;

    @JsonProperty("zona")
    private String zona;

    private String datacenter;

    @JsonProperty("componente")
    private String componente;

    @JsonProperty("valor")
    private Double valor;

    @JsonProperty("threshold_momento")
    private Double thresholdMomento;

    @JsonProperty("severidade")
    private String severidadeStr;

    @JsonProperty("id_responsavel")
    private Integer idResponsavel;

    @JsonProperty("nome_responsavel")
    private String nomeResponsavel;

    @JsonProperty("timestamp")
    private String timestampStr;

    @JsonProperty("issue_key")
    private String issueKey;

    @JsonProperty("status")
    private String status;

    @JsonProperty("sla_prazo_horas")
    private Integer slaPrazoHoras;

    public Alerta() {}

    public Severidade getSeveridade() {
        if (severidadeStr == null) return null;
        return Severidade.string(severidadeStr);
    }

    public LocalDateTime getTimestamp() {
        if (timestampStr == null) return null;
        try {
            return LocalDateTime.parse(timestampStr);
        } catch (Exception e) {
            return null;
        }
    }


    public Integer getIdServidor() { return idServidor; }
    public void setIdServidor(Integer idServidor) { this.idServidor = idServidor; }

    public Integer getIdComponente() { return idComponente; }
    public void setIdComponente(Integer idComponente) { this.idComponente = idComponente; }

    public String getServidor() { return servidor; }
    public void setServidor(String servidor) { this.servidor = servidor; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public String getDatacenter() { return datacenter; }
    public void setDatacenter(String datacenter) { this.datacenter = datacenter; }

    public String getComponente() { return componente; }
    public void setComponente(String componente) { this.componente = componente; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Double getThresholdMomento() { return thresholdMomento; }
    public void setThresholdMomento(Double thresholdMomento) { this.thresholdMomento = thresholdMomento; }

    /// public String getSeveridadeStr() { return severidadeStr; }
    /// public void setSeveridadeStr(String severidadeStr) { this.severidadeStr = severidadeStr; }

    public Integer getIdResponsavel() { return idResponsavel; }
    public void setIdResponsavel(Integer idResponsavel) { this.idResponsavel = idResponsavel; }

    public String getNomeResponsavel() { return nomeResponsavel; }
    public void setNomeResponsavel(String nomeResponsavel) { this.nomeResponsavel = nomeResponsavel; }

    ///  public String getTimestampStr() { return timestampStr; }
    /// public void setTimestampStr(String timestampStr) { this.timestampStr = timestampStr; }

    public String getIssueKey() { return issueKey; }
    public void setIssueKey(String issueKey) { this.issueKey = issueKey; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getSlaPrazoHoras() { return slaPrazoHoras; }
    public void setSlaPrazoHoras(Integer slaPrazoHoras) { this.slaPrazoHoras = slaPrazoHoras; }
}
