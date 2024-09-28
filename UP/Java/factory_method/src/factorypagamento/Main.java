package factorypagamento;

public class Main {
    public static void main(String[] args) {
       PagamentoService service = new PagamentoService();

       service.processarPagamento(new FactoryCartaoCredito(1234567891234567L), 250.00);

       service.processarPagamento(new FactoryCriptomoeda(500.00), 350.00);

       service.processarPagamento(new FactoryPaypal("@outlook.com"), 450.00);
    }
}
