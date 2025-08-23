package validador;

public interface ValidadorExame {
    void setProximo(ValidadorExame proximo);
    void validar(Exame exame);
}
