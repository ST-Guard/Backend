package school.sptech.servicos;

import school.sptech.app.AlertaProcessador;
import school.sptech.client.ClientJira;
import school.sptech.client.ClientS3;
import school.sptech.model.Alerta;
import school.sptech.model.RegistroAlerta;
import school.sptech.repositorio.RegistroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicoAlertas implements AlertaProcessador {

    @Autowired
    private ClientS3 s3Cliente;

    @Autowired
    private ClientJira clientJira;

    @Autowired
    private RegistroRepositorio registroRepositorio;


    @Override
    public void processar() {
        System.out.println("Processando alertas pendentes...");

        List<Alerta> alertasPendentes = s3Cliente.baixarAlertasPendentes();

        if (alertasPendentes.isEmpty()) {
            System.out.println("Nenhum alerta pendente.");
            return;
        }

        System.out.println("Foram encontrados " + alertasPendentes.size() + " alertas");

        for (Alerta alerta : alertasPendentes) {
            try {
                String titulo = String.format("[ALERTA] %s - %s: %.1f%%",
                        alerta.getServidor(), alerta.getComponente(), alerta.getValor());

                String descricao = String.format(
                        "Servidor: %s\nZona: %s\nComponente: %s\nValor: %.2f%%\nLimite: %.2f%%\nSeveridade: %s\nResponsável: %s",
                        alerta.getServidor(), alerta.getZona(), alerta.getComponente(),
                        alerta.getValor(), alerta.getThresholdMomento(),
                        alerta.getSeveridade(), alerta.getNomeResponsavel()
                );

                String issueKey = clientJira.abrirChamado("KAN", titulo, descricao, "Incident");
                System.out.println("Chamado criado: " + issueKey);

                RegistroAlerta registro = new RegistroAlerta();
                registro.setIssueKey(issueKey);
                registro.setAbertoEm(LocalDateTime.now());
                registro.setFkResponsavel(alerta.getIdResponsavel());
                registro.setSeveridade(alerta.getSeveridade());
                registro.setFkServidor(alerta.getIdServidor());
                registro.setFkComponente(alerta.getIdComponente());
                registro.setValor(alerta.getValor());
                registro.setThreshold_momento(alerta.getThresholdMomento());
                registro.setDataHora(alerta.getTimestamp());
                registro.setSlaOK(null);
                registro.setDatacenter(alerta.getDatacenter());

                registroRepositorio.save(registro);
                System.out.println("Salvo no banco: " + issueKey);

            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

}
