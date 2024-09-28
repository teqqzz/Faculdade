package factorypagamento;

public class PagamentoService {
    public void processarPagamento(PagamentoFactory factory, double amount){
        iPagamento pagamento = factory.processarPagamento();
        pagamento.processarPagamento(amount);
    }
}
