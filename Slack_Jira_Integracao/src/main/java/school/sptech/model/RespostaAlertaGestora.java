package school.sptech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaAlertaGestora {

    private Map<String, Map<String, DadosDatacenter>> alertasGestora;

    public Map<String, Map<String, DadosDatacenter>> getAlertasGestora() {
        return alertasGestora;
    }

    public void setAlertasGestora(Map<String, Map<String, DadosDatacenter>> alertasGestora) {
        this.alertasGestora = alertasGestora;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DadosDatacenter {

        @JsonProperty("KPIs")
        private KPIs kpis;

        @JsonProperty("ALERTAS_ATIVOS")
        private List<Alerta> alertasAtivos;

        @JsonProperty("GRAFICOS")
        private Graficos graficos;

        public KPIs getKpis() { return kpis; }
        public void setKpis(KPIs kpis) { this.kpis = kpis; }

        public List<Alerta> getAlertasAtivos() { return alertasAtivos; }
        public void setAlertasAtivos(List<Alerta> alertasAtivos) { this.alertasAtivos = alertasAtivos; }

        public Graficos getGraficos() { return graficos; }
        public void setGraficos(Graficos graficos) { this.graficos = graficos; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class KPIs {

        @JsonProperty("CRITICOS_ABERTOS")
        private Integer criticosAbertos;

        @JsonProperty("MEDIOS_ABERTOS")
        private Integer mediosAbertos;

        @JsonProperty("BAIXOS_ABERTOS")
        private Integer baixosAbertos;

        @JsonProperty("RESOLVIDOS_24H")
        private Integer resolvidos24h;

        @JsonProperty("SERVIDOR_MAIS_ALERTAS")
        private String servidorMaisAlertas;

        @JsonProperty("QTD_ALERTAS_SERVIDOR_TOP")
        private Integer qtdAlertasServidorTop;

        public Integer getCriticosAbertos() { return criticosAbertos; }
        public void setCriticosAbertos(Integer criticosAbertos) { this.criticosAbertos = criticosAbertos; }

        public Integer getMediosAbertos() { return mediosAbertos; }
        public void setMediosAbertos(Integer mediosAbertos) { this.mediosAbertos = mediosAbertos; }

        public Integer getBaixosAbertos() { return baixosAbertos; }
        public void setBaixosAbertos(Integer baixosAbertos) { this.baixosAbertos = baixosAbertos; }

        public Integer getResolvidos24h() { return resolvidos24h; }
        public void setResolvidos24h(Integer resolvidos24h) { this.resolvidos24h = resolvidos24h; }

        public String getServidorMaisAlertas() { return servidorMaisAlertas; }
        public void setServidorMaisAlertas(String servidorMaisAlertas) { this.servidorMaisAlertas = servidorMaisAlertas; }

        public Integer getQtdAlertasServidorTop() { return qtdAlertasServidorTop; }
        public void setQtdAlertasServidorTop(Integer qtdAlertasServidorTop) { this.qtdAlertasServidorTop = qtdAlertasServidorTop; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Graficos {

        @JsonProperty("ALERTAS_POR_COMPONENTE")
        private Map<String, Integer> alertasPorComponente;

        @JsonProperty("ALERTAS_POR_SEMANA")
        private List<SemanaAlerta> alertasPorSemana;

        @JsonProperty("MTTR_POR_SERVIDOR")
        private List<MttrServidor> mttrPorServidor;

        @JsonProperty("RESUMO_SEMANAS")
        private Map<String, Object> resumoSemanas;

        public Map<String, Integer> getAlertasPorComponente() { return alertasPorComponente; }
        public void setAlertasPorComponente(Map<String, Integer> alertasPorComponente) { this.alertasPorComponente = alertasPorComponente; }

        public List<SemanaAlerta> getAlertasPorSemana() { return alertasPorSemana; }
        public void setAlertasPorSemana(List<SemanaAlerta> alertasPorSemana) { this.alertasPorSemana = alertasPorSemana; }

        public List<MttrServidor> getMttrPorServidor() { return mttrPorServidor; }
        public void setMttrPorServidor(List<MttrServidor> mttrPorServidor) { this.mttrPorServidor = mttrPorServidor; }

        public Map<String, Object> getResumoSemanas() { return resumoSemanas; }
        public void setResumoSemanas(Map<String, Object> resumoSemanas) { this.resumoSemanas = resumoSemanas; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SemanaAlerta {

        @JsonProperty("semana")
        private String semana;

        @JsonProperty("inicio")
        private String inicio;

        @JsonProperty("baixo")
        private Integer baixo;

        @JsonProperty("medio")
        private Integer medio;

        @JsonProperty("critico")
        private Integer critico;

        @JsonProperty("total")
        private Integer total;

        public String getSemana() { return semana; }
        public void setSemana(String semana) { this.semana = semana; }

        public String getInicio() { return inicio; }
        public void setInicio(String inicio) { this.inicio = inicio; }

        public Integer getBaixo() { return baixo; }
        public void setBaixo(Integer baixo) { this.baixo = baixo; }

        public Integer getMedio() { return medio; }
        public void setMedio(Integer medio) { this.medio = medio; }

        public Integer getCritico() { return critico; }
        public void setCritico(Integer critico) { this.critico = critico; }

        public Integer getTotal() { return total; }
        public void setTotal(Integer total) { this.total = total; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MttrServidor {

        @JsonProperty("idServidor")
        private Integer idServidor;

        @JsonProperty("baixo")
        private Double baixo;

        @JsonProperty("medio")
        private Double medio;

        @JsonProperty("critico")
        private Double critico;

        public Integer getIdServidor() { return idServidor; }
        public void setIdServidor(Integer idServidor) { this.idServidor = idServidor; }

        public Double getBaixo() { return baixo; }
        public void setBaixo(Double baixo) { this.baixo = baixo; }

        public Double getMedio() { return medio; }
        public void setMedio(Double medio) { this.medio = medio; }

        public Double getCritico() { return critico; }
        public void setCritico(Double critico) { this.critico = critico; }
    }
}