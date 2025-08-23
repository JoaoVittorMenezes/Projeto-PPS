package Projeto-PPS.src.validador;

public class ValidadorRessonancia implements Validador {

    private Validador proximo;

    @Override
    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    @Override
    public void validar(Exame exame) {
        if (exame instanceof ExameRessonancia) {
            ExameRessonancia rm = (ExameRessonancia) exame;

            if (rm.getDescricao() == null || rm.getDescricao().isEmpty()) {
                System.out.println("⚠ Ressonância inválida: descrição não pode estar vazia.");
            }

            if (rm.getRadiologista() == null) {
                System.out.println("⚠ Ressonância inválida: radiologista não associado.");
            }

            if (rm.isPacienteComMarcapasso() || rm.isPacienteComImplantesMetalicos()) {
                System.out.println("❌ Paciente com marcapasso/implantes não pode realizar ressonância!");
            }

            return; // validação feita
        }

        if (proximo != null) {
            proximo.validar(exame);
        }
    }
}