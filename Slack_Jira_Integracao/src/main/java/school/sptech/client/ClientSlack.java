package school.sptech.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ClientSlack {

    @Value("${slack.webhook.url}")
    private String webhookUrl;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public void enviar(String mensagem) {
        try {
            String payload = "{\"text\": \"" + mensagem.replace("\"", "\\\"") + "\"}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString());

            System.out.printf("Slack Status:" + response.statusCode() + " | Resposta: " + response.body());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}