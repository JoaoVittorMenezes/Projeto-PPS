package exame;

public interface ExameState {
    public void avancarEstado();
    public void cancelar();
    public void gerarLaudo();
}