package notificador;

import modelos.Laudo;
import modelos.Paciente;

public class NotificacaoSms implements NotificacaoService {
    @Override
    public void notificar(Paciente paciente, Laudo laudo) {
        System.out.println("Enviando SMS para " + paciente.getNomePaciente() + " com laudo " + laudo.getDescricao());
    }
}
