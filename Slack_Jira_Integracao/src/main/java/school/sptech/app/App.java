package school.sptech.app;
import school.sptech.config.Jira;
import java.time.LocalDateTime;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import school.sptech.config.Slack;
import java.io.IOException;
import org.json.JSONObject;


public class App {
    public static void main(String[] args) throws Exception {
        /*--------------------- JIRA e SLACK ------------------------*/
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String baseUrl = "URL";
        String email = "victor.gastardeli@sptech.school";
        String apiToken = "TOKEN";

        Random aleatorio = new Random();
        Jira jira = new Jira(baseUrl, email, apiToken);

        while (true) {
            JSONObject json = new JSONObject();
            LocalDateTime agora = LocalDateTime.now();
            String dataFormatada = agora.format(formatador);
            int cpu = aleatorio.nextInt(81,101);
            int ram = aleatorio.nextInt(101);
            int disco = aleatorio.nextInt(101);

            System.out.println("Status atuais do servidor");
            System.out.println("DATA: " + dataFormatada);
            System.out.println("CPU: " + cpu + "% | RAM: " + ram + "% | DISCO: " + disco + "%");

            if (cpu > 80) {

                String titulo = "Alerta: CPU Crítica - " + cpu + "%";
                String descricao = String.format("O uso da CPU estpa em %s. O uso de CPU atingiu %d%%, ultrapassando o limite de 80%%.", dataFormatada, cpu);

                String response = jira.createIssue("KAN", titulo, descricao, "Incident");
                System.out.println("Ticket CPU criado: " + response);
                json.put("text", "A CPU está em + de 80%, uma task foi aberta no jira");
            }

            if (ram > 80) {
                String titulo = "Alerta: RAM Crítica - " + ram + "%";
                String descricao = "O uso de memória RAM está em " + ram + "%. Data de captação do dado: " + dataFormatada;

                String response = jira.createIssue("KAN", titulo, descricao, "Incident");
                System.out.println("Ticket RAM criado: " + response);
            }

            if (disco > 85) {
                String titulo = "Alerta: Espaço em Disco - " + disco + "%";
                String descricao = "O volume principal de armazenamento atingiu " + disco + "% no dia " + dataFormatada + " Risco de travamento em breve";

                String response = jira.createIssue("KAN", titulo, descricao, "Incident");
                System.out.println("Ticket DISCO criado: " + response);
            }
            Slack.sendMessage(json);
            System.out.println("Carregando próximo dado...\n");
            Thread.sleep(10000);
        }
        /*--------------------------------------------------*/
    }
}

