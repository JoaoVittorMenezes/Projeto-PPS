package notificador;

import modelos.Laudo;
import modelos.Paciente;

import java.util.HashMap;
import java.util.Map;

public class Notificador {
    private Map<Paciente, String> assinantes = new HashMap<>();
    private Map<String, NotificacaoService> servicos = new HashMap<>();
    public Notificador() {
        servicos.put("email", new NotificacaoEmail());
        servicos.put("sms", new NotificacaoSms());
    }

    public void assinar(Paciente assinante, String tipoNotificacao) {
        assinantes.put(assinante, tipoNotificacao.toLowerCase());
    }

    public void cancelarAssinatura(Paciente assinante) {
        assinantes.remove(assinante);
    }

    public void notificarAssinante(Paciente assinante, Laudo laudo) {
        String tipo = assinantes.get(assinante);
        NotificacaoService servico = servicos.get(tipo);
        if (servico != null) {
            servico.notificar(assinante, laudo);
        }
    }

}