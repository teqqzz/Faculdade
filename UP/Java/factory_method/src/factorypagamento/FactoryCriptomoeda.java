package factorypagamento;

public class FactoryCriptomoeda extends PagamentoFactory {
    private double amount = 0.00;
    
    public FactoryCriptomoeda(double amount){
        this.amount = amount;
    }

    public iPagamento processarPagamento(){
        return new PagamentoCriptomoeda(amount);
    }

}
