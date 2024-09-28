package factorypagamento;

import java.util.*;

public class PagamentoPaypal implements iPagamento {
    private String verification = "";

    private List<String> contasPaypal = Arrays.asList("ermanos@gmail.com", "cesar@gmail.com", "richard@outlook.com");

    public PagamentoPaypal(String verification){
        this.verification = verification;
    }

    public void processarPagamento(double amount) {   
        if (contasPaypal.contains(verification)) {
            System.out.println("Processando pagamento no PayPal no valor de: " + amount);
        }   else {
                System.out.println("Conta PayPal: " +verification+ " não verificada. Pagamento não processado.");
            }
    }

}
