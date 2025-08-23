package exame;

public abstract class GeradorDeLaudo {
    protected Notificador notificador;

    public void gerarLaudo() {};
    public abstract void gerarCabecalho();
    public abstract void gerarCorpo();
    public abstract void finalizarDocumento();
}
