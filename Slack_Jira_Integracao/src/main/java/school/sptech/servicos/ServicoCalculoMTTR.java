package school.sptech.servicos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import school.sptech.client.ClientJira;
import school.sptech.model.RegistroAlerta;
import school.sptech.model.Severidade;
import school.sptech.repositorio.RegistroRepositorio;
import school.sptech.repositorio.UsuarioRepositorio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class ServicoCalculoMTTR {

    @Value("${sla.prazo.critico:1}")
    private int slaPrazoCriticoHoras;

    @Value("${sla.prazo.medio:4}")
    private int slaPrazoMedioHoras;

    @Value("${sla.prazo.baixo:24}")
    private int slaPrazoBaixoHoras;

    private final ClientJira clientJira;
    private final RegistroRepositorio registroRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final ObjectMapper objectMapper;


    public ServicoCalculoMTTR(ClientJira clientJira,
                              RegistroRepositorio registroRepositorio,
                              UsuarioRepositorio usuarioRepositorio,
                              ObjectMapper objectMapper) {
        this.clientJira = clientJira;
        this.registroRepositorio = registroRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.objectMapper = objectMapper;
    }

    public void processarResolucao(String webhookBody) {
        try {
            JsonNode payload = objectMapper.readTree(webhookBody);
            String issueKey = payload.path("issue").path("key").asText();

            if (issueKey.isBlank()) {
                System.err.println("issueKey não encontrada no webhook.");
                return;
            }

            System.out.printf("Processando resolução do chamado: " + issueKey);

            Optional<RegistroAlerta> optional = registroRepositorio.findByIssueKey(issueKey);
            if (optional.isEmpty()) {
                System.err.printf("Registro não encontrado para issueKey: %s%n", issueKey);
                return;
            }
            RegistroAlerta registro = optional.get();
            System.out.println("Registro encontrado: " + optional.isPresent());

            LocalDateTime resolvidoEm = clientJira.getResolvidoEm(issueKey);
            if (resolvidoEm == null) {
                System.err.printf("Chamado %s ainda não tem resolutiondate.%n", issueKey);
                return;
            }

            int mttrMinutos = (int) ChronoUnit.MINUTES.between(
                    registro.getAbertoEm(), resolvidoEm);

            boolean slaOk = verificarSla(registro.getSeveridade(), mttrMinutos);

            registro.setResolvidoEm(resolvidoEm);
            registro.setMttrMinutos(mttrMinutos);
            registro.setSlaOK(slaOk);
            registroRepositorio.save(registro);

            System.out.printf("%s | MTTR: %d min | SLA: %s%n",
                    issueKey, mttrMinutos, slaOk ? "OK" : "VIOLADO");


            if (registro.getFkResponsavel() != null) {
                usuarioRepositorio.atualizarSlaMttr(registro.getFkResponsavel());
                System.out.printf("sla_mttr do analista %d atualizado.%n",
                        registro.getFkResponsavel());
            }

        } catch (Exception e) {
            System.err.println("Erro ao processar resolução: " + e.getMessage());
        }
    }

    private boolean verificarSla(Severidade severidade, int mttrMinutos) {
        if (severidade == null) return false;
        int prazoMinutos = switch (severidade) {
            case critico -> slaPrazoCriticoHoras * 60;
            case medio -> slaPrazoMedioHoras * 60;
            case baixo -> slaPrazoBaixoHoras * 60;
        };
        return mttrMinutos <= prazoMinutos;
    }
}