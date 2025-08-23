package notificador;

import modelos.Laudo;
import modelos.Paciente;

public interface NotificacaoService {
    void notificar(Paciente paciente, Laudo laudo);
}
