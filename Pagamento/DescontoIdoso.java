public class DescontoIdoso extends DescontoStrategy {
    protected double desconto = 30;

    public double aplicarDesconto(double valor) {
        return valor - desconto;
    }
}