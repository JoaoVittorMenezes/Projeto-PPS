package pagamento;

public class Teste {
    public static void main(String[] args) {
        Pagamento pag1 = new Pagamento();
        pag1.setStrategy(new DescontoConvenio());
        System.out.println(pag1.pagar(30));
    }
}