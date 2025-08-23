package pagamento;

public class DescontoConvenio extends DescontoStrategy {
    protected double desconto = 20;

    public double aplicarDesconto(double valor) {
        return valor - desconto;
    }
}