package school.sptech.model;

import java.util.List;
import java.util.Map;

public class RespostaAlertaGestora {


    private Map<String, Map<String, DadosDatacenter>> alertasGestora;

    public Map<String, Map<String, DadosDatacenter>> getAlertasGestora() {
        return alertasGestora;
    }

    public void setAlertasGestora(Map<String, Map<String, DadosDatacenter>> alertasGestora) {
        this.alertasGestora = alertasGestora;
    }

    public static class DadosDatacenter {
        private KPIs kpis;
        private List<Alerta> alertasAtivos;
        private Graficos graficos;

        public KPIs getKpis() { return kpis; }
        public void setKpis(KPIs kpis) { this.kpis = kpis; }

        public List<Alerta> getAlertasAtivos() { return alertasAtivos; }
        public void setAlertasAtivos(List<Alerta> alertasAtivos) { this.alertasAtivos = alertasAtivos; }

        public Graficos getGraficos() { return graficos; }
        public void setGraficos(Graficos graficos) { this.graficos = graficos; }
    }

    public static class KPIs {
        private Integer criticosAbertos;
        private Integer mediosAbertos;
        private Integer baixosAbertos;
        private Integer resolvidos24h;
        private String servidorMaisAlertas;
        private Integer qtdAlertasServidorTop;

        public Integer getCriticosAbertos() {
            return criticosAbertos;
        }

        public void setCriticosAbertos(Integer criticosAbertos) {
            this.criticosAbertos = criticosAbertos;
        }

        public Integer getMediosAbertos() {
            return mediosAbertos;
        }

        public void setMediosAbertos(Integer mediosAbertos) {
            this.mediosAbertos = mediosAbertos;
        }

        public Integer getBaixosAbertos() {
            return baixosAbertos;
        }

        public void setBaixosAbertos(Integer baixosAbertos) {
            this.baixosAbertos = baixosAbertos;
        }

        public Integer getResolvidos24h() {
            return resolvidos24h;
        }

        public void setResolvidos24h(Integer resolvidos24h) {
            this.resolvidos24h = resolvidos24h;
        }

        public String getServidorMaisAlertas() {
            return servidorMaisAlertas;
        }

        public void setServidorMaisAlertas(String servidorMaisAlertas) {
            this.servidorMaisAlertas = servidorMaisAlertas;
        }

        public Integer getQtdAlertasServidorTop() {
            return qtdAlertasServidorTop;
        }

        public void setQtdAlertasServidorTop(Integer qtdAlertasServidorTop) {
            this.qtdAlertasServidorTop = qtdAlertasServidorTop;
        }
    }

    public static class Graficos {
        private Map<String, Integer> alertasPorComponente;
        private List<SemanaAlerta> alertasPorSemana;
        private List<MttrServidor> mttrPorServidor;


        public Map<String, Integer> getAlertasPorComponente() {
            return alertasPorComponente;
        }

        public void setAlertasPorComponente(Map<String, Integer> alertasPorComponente) {
            this.alertasPorComponente = alertasPorComponente;
        }

        public List<SemanaAlerta> getAlertasPorSemana() {
            return alertasPorSemana;
        }

        public void setAlertasPorSemana(List<SemanaAlerta> alertasPorSemana) {
            this.alertasPorSemana = alertasPorSemana;
        }

        public List<MttrServidor> getMttrPorServidor() {
            return mttrPorServidor;
        }

        public void setMttrPorServidor(List<MttrServidor> mttrPorServidor) {
            this.mttrPorServidor = mttrPorServidor;
        }
    }

    public static class SemanaAlerta {
        private String semana;
        private String inicio;
        private Integer baixo;
        private Integer medio;
        private Integer critico;
        private Integer total;

        public String getSemana() {
            return semana;
        }

        public void setSemana(String semana) {
            this.semana = semana;
        }

        public String getInicio() {
            return inicio;
        }

        public void setInicio(String inicio) {
            this.inicio = inicio;
        }

        public Integer getBaixo() {
            return baixo;
        }

        public void setBaixo(Integer baixo) {
            this.baixo = baixo;
        }

        public Integer getMedio() {
            return medio;
        }

        public void setMedio(Integer medio) {
            this.medio = medio;
        }

        public Integer getCritico() {
            return critico;
        }

        public void setCritico(Integer critico) {
            this.critico = critico;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }

    public static class MttrServidor {
        private String servidor;
        private Double baixo;
        private Double medio;
        private Double critico;

        public String getServidor() {
            return servidor;
        }

        public void setServidor(String servidor) {
            this.servidor = servidor;
        }

        public Double getBaixo() {
            return baixo;
        }

        public void setBaixo(Double baixo) {
            this.baixo = baixo;
        }

        public Double getMedio() {
            return medio;
        }

        public void setMedio(Double medio) {
            this.medio = medio;
        }

        public Double getCritico() {
            return critico;
        }

        public void setCritico(Double critico) {
            this.critico = critico;
        }
    }


}