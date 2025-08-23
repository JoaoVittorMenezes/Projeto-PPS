package notificador;

public class NotificacaoSms implements NotificacaoService {
    @Override
    public void notificar(Paciente paciente, Laudo laudo) {
        System.out.println("Enviando SMS para " + paciente.getTelefone() + " com laudo " + laudo.getDescricao());
    }
}
