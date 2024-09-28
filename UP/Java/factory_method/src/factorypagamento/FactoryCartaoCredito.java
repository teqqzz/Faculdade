package factorypagamento;

public class FactoryCartaoCredito extends PagamentoFactory {
    private long nmrCartao;

    public FactoryCartaoCredito(long nmrCartao){
        this.nmrCartao = nmrCartao;
    }

    @Override
    public iPagamento processarPagamento(){
        return new PagamentoCartaoCredito(nmrCartao);
    }

}
