package school.sptech.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.servicos.ServicoGeradorHistorico;
import school.sptech.servicos.ServicoCalculoMTTR;

@RestController
@RequestMapping("/webhook")
public class WebHookController {

    private final ServicoCalculoMTTR servicoCalculoMTTR;
    private final ServicoGeradorHistorico servicoGeradorHistorico;
    private final ObjectMapper objectMapper;

    public WebHookController(ServicoCalculoMTTR servicoCalculoMTTR,
                             ServicoGeradorHistorico servicoGeradorHistorico,
                             ObjectMapper objectMapper) {
        this.servicoCalculoMTTR = servicoCalculoMTTR;
        this.servicoGeradorHistorico = servicoGeradorHistorico;
        this.objectMapper = objectMapper;
    }

    // WebHookController.java — adicionar esse método temporário
    @GetMapping("/teste-mttr/{issueKey}")
    public ResponseEntity<String> testeMttr(@PathVariable String issueKey) {
        String bodyFake = "{\"webhookEvent\":\"jira:issue_updated\",\"issue\":{\"key\":\""
                + issueKey
                + "\",\"fields\":{\"status\":{\"name\":\"Done\"}}}}";
        servicoCalculoMTTR.processarResolucao(bodyFake);
        return ResponseEntity.ok("MTTR processado para: " + issueKey);
    }

    @PostMapping("/jira")
    public ResponseEntity<String> receberWebhookJira(@RequestBody String body) {
        System.out.println("WebHook jira concluídp");

        try {
            JsonNode payload = objectMapper.readTree(body);
            String evento = payload.path("webhookEvent").asText("");

            if ("jira:issue_updated".equals(evento)) {
                JsonNode statusAtual = payload
                        .path("issue").path("fields")
                        .path("status").path("name");

                if ("Done".equalsIgnoreCase(statusAtual.asText())) {
                    System.out.println("Chamado resolvido");
                    servicoCalculoMTTR.processarResolucao(body);
                    servicoGeradorHistorico.gerar();
                } else {
                    System.out.printf("Evento " + evento + " ignorado " + statusAtual.asText());
                }
            } else {
                System.out.printf("Evento " + evento + " ignorado");
            }

            return ResponseEntity.ok("Recebido");

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            return ResponseEntity.ok("Erro interno registrado");
        }
    }
}