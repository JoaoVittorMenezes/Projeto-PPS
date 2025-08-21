package Pagamento;

public class Pagamento {
    private DescontoStrategy strategy;

    public void setStrategy(DescontoStrategy tipoDesconto) {
        this.strategy = tipoDesconto;
    }

    public double pagar(double valor) {
        return strategy.aplicarDesconto(valor);
    }

}