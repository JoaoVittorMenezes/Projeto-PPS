public abstract class DescontoStrategy {
    protected double desconto;
    public abstract double aplicarDesconto(double valor);
}