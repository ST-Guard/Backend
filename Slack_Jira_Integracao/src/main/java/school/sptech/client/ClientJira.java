package school.sptech.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Component
public class ClientJira {

    @Value("${jira.baseurl}")
    private String baseUrl;

    @Value("${jira.email}")
    private String email;

    @Value("${jira.token}")
    private String apiToken;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ClientJira(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    private String cabecalho() {
        String auth = email + ":" + apiToken;
        return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
    }

    private HttpRequest.Builder requisicaoBasica(String endpoint) {
        return HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .timeout(Duration.ofSeconds(60))
                .header("Authorization", cabecalho())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    private String enviar(HttpRequest request) throws Exception {
        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        if (status >= 200 && status < 300) {
            return response.body();
        }
        throw new RuntimeException("Jira HTTP " + status + ": " + response.body());
    }

    public String abrirChamado(String projectKey, String titulo,
                               String descricao, String tipo) throws Exception {
        Map<String, Object> adfDescription = Map.of(
                "type", "doc",
                "version", 1,
                "content", List.of(Map.of(
                        "type", "paragraph",
                        "content", List.of(Map.of(
                                "type", "text",
                                "text", descricao
                        ))
                ))
        );

        Map<String, Object> payload = Map.of(
                "fields", Map.of(
                        "project", Map.of("key", projectKey),
                        "summary", titulo,
                        "description", adfDescription,
                        "issuetype", Map.of("name", tipo)
                )
        );

        String json = objectMapper.writeValueAsString(payload);
        HttpRequest request = requisicaoBasica("/rest/api/3/issue")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        String body = enviar(request);

        return objectMapper.readTree(body).get("key").asText();
    }


    public JsonNode buscarChamado(String issueKey) throws Exception {
        HttpRequest request = requisicaoBasica("/rest/api/3/issue/" + issueKey)
                .GET()
                .build();
        String body = enviar(request);
        return objectMapper.readTree(body);
    }

    public LocalDateTime getResolvidoEm(String issueKey) throws Exception {
        JsonNode chamado = buscarChamado(issueKey);
        JsonNode resolutionDate = chamado.path("fields").path("resolutiondate");

        if (resolutionDate.isNull() || resolutionDate.isMissingNode()) {
            return null;
        }

        String dateStr = resolutionDate.asText();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return LocalDateTime.parse(dateStr, formatter);
    }
}