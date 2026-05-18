package school.sptech.model;

import java.time.LocalDateTime;

public class RegistroAlerta {
    private Integer idRegistro;
    private String issueKey;
    private LocalDateTime abertoEm;
    private LocalDateTime resolvidoEm;
    private Integer mttrMinutos;
    private Boolean slaOK;
    private Integer fkResponsavel;
    private Severidade severidade;

    public RegistroAlerta() {
    }
    public RegistroAlerta(Integer idRegistro, String issueKey, LocalDateTime abertoEm, LocalDateTime resolvidoEm, Integer mttrMinutos, Boolean slaOK, Integer fkResponsavel, Severidade severidade) {
        this.idRegistro = idRegistro;
        this.issueKey = issueKey;
        this.abertoEm = abertoEm;
        this.resolvidoEm = resolvidoEm;
        this.mttrMinutos = mttrMinutos;
        this.slaOK = slaOK;
        this.fkResponsavel = fkResponsavel;
        this.severidade = severidade;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
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

    public Severidade getSeveridade() {
        return severidade;
    }

    public void setSeveridade(Severidade severidade) {
        this.severidade = severidade;
    }
}
