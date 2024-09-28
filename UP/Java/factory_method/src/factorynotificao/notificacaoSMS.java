package factorynotificao;
public class notificacaoSMS implements iNotificacao {
    @Override
    public void enviar(String mensagem){
        //Implementação da logica do SMS
        System.out.println("SMS: " + mensagem);
    }
}

