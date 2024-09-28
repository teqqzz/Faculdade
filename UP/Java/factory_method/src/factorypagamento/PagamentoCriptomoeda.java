package factorypagamento;

public class PagamentoCriptomoeda implements iPagamento {
    private double saldo = 0.00;

    public PagamentoCriptomoeda(double saldo){
        this.saldo = saldo;
    }

    public void processarPagamento(double amount){
        if (saldo >= amount ){
            System.out.println("Processando seu pagamento em criptomoeda no valor de: " +amount);
        }
        else{
            System.out.println("Seu saldo não e equivalente " +amount + " pagamento não processado");
        }
    }
}
