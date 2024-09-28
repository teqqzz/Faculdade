    package factorypagamento;

    public class FactoryPaypal extends PagamentoFactory {
        private String verification = "";

        public FactoryPaypal(String verification){
            this.verification = verification;
        }

        public iPagamento processarPagamento(){
            return new PagamentoPaypal(verification);
        }

    }
