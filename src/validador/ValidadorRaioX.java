package Projeto-PPS.src.validador;

public class ValidadorRaioX implements Validador {

    private Validador proximo;

    @Override
    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    @Override
    public void validar(Exame exame) {
        if (exame instanceof ExameRaioX) {
            ExameRaioX raioX = (ExameRaioX) exame;

            if (raioX.getImagem() == null || raioX.getImagem().isEmpty()) {
                System.out.println("⚠ Raio-X inválido: imagem não pode ser vazia.");
            }

            if (raioX.getRadiologista() == null) {
                System.out.println("⚠ Raio-X inválido: radiologista não associado.");
            }

            return; // validação feita
        }

        if (proximo != null) {
            proximo.validar(exame);
        }
    }
}