package Exame;

import Pagamento.Pagamento;

public abstract class Exame {
    protected GeradorDeLaudo geradorLaudo;
    protected Exame tipoExame;
    protected String nomePaciente;
    protected int idPaciente;
    protected ExameState estado;
    protected Pagamento pagamento;


    public abstract void gerarLaudo();

    public void setGerador(GeradorDeLaudo geradorLaudo) {
        this.geradorLaudo = geradorLaudo;
    }

    public String getLaudo() {
        this.geradorLaudo.gerarLaudo();
    }

    public void avancarEstado() {
        this.estado.avancarEstado();
    }

    public void cancelar() {
        this.estado.cancelar();
    }
}