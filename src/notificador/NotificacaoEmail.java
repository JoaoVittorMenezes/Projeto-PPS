package notificador;

public class NotificacaoEmail implements NotificacaoService {
    @Override
    public void notificar(Paciente paciente, Laudo laudo) {
        System.out.println("Enviando e-mail para " + paciente.getEmail() + " com laudo " + laudo.getDescricao());
    }
}
