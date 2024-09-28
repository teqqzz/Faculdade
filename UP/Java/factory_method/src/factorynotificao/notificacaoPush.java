package factorynotificao;
public class notificacaoPush implements iNotificacao {
    @Override
    public void enviar(String mensagem){
        //Implementação da logica do Push
        System.out.println("Push: " + mensagem);
    }
}
