package school.sptech.model;

import java.time.LocalDateTime;

public class Alerta {
    private String servidor;
    private String zona;
    private String datacenter;
    private String componente;
    private Double valor;
    private Double limiteMomento;
    private Severidade severidade;
    private Integer idResponsavel;
    private LocalDateTime horario;
    
    public Alerta() {
    }

    public Alerta(String servidor, String zona, String datacenter, String componente, Double valor, Double limiteMomento, Severidade severidade, Integer idResponsavel, LocalDateTime horario) {
        this.servidor = servidor;
        this.zona = zona;
        this.datacenter = datacenter;
        this.componente = componente;
        this.valor = valor;
        this.limiteMomento = limiteMomento;
        this.severidade = severidade;
        this.idResponsavel = idResponsavel;
        this.horario = horario;
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

    public Double getLimiteMomento() {
        return limiteMomento;
    }

    public void setLimiteMomento(Double limiteMomento) {
        this.limiteMomento = limiteMomento;
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

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
}
