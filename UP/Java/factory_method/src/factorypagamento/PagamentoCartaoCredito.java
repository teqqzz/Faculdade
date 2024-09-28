package factorypagamento;

public class PagamentoCartaoCredito implements iPagamento {
    private long nmrCartao;

    public PagamentoCartaoCredito(long nmrCartao){
        this.nmrCartao = nmrCartao;
    }
    public void processarPagamento(double amount){
        if (String.valueOf(nmrCartao).length() == 16){
            System.out.println("Processando pagamento no Cartao de credito no valor de: " + amount);
        }
        else{
            System.out.println("Seu cartao nao atinge 16 numeros necessarios");
        }
    }

}
