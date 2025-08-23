package Projeto-PPS.src.validador;

public class ValidadorSanguineo extends ValidadorExame {

    @Override
    protected boolean podeValidar(Exame exame) {
        return exame.getTipoExame().equalsIgnoreCase("sanguineo");
    }

    @Override
    protected boolean processar(Exame exame) {
        String nome = exame.getNome().toLowerCase();

        if (nome.equals("glicose")) {
            double v = exame.getValor();
            if (v < 60) {
                System.out.println("Hipoglicemia detectada!");
            } else if (v >= 60 && v <= 99) {
                System.out.println("Glicose normal.");
            } else if (v >= 100 && v <= 125) {
                System.out.println("Paciente intolerante à glicose.");
            } else {
                System.out.println("Diabetes detectada.");
            }
            return true;
        }

        if (nome.equals("creatinina")) {
            double v = exame.getValor();
            if (v > 1.5) {
                System.out.println("Creatinina em nível crítico!");
            } else {
                System.out.println("Creatinina dentro do esperado.");
            }
            return true;
        }

        return false;
    }
}
