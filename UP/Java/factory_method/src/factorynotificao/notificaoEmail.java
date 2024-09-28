package factorynotificao;
public class notificaoEmail implements iNotificacao {
    @Override
    public void enviar(String mensagem){
        //Implementação da logica do email
        System.out.println("Email: " + mensagem);
    }
}
