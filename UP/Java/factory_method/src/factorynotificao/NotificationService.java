package factorynotificao;

public class NotificationService {
    public void enviarNotificao(NotificaoFactory factory, String mensagem){
        iNotificacao notificacao = factory.criarNotificacao();
        notificacao.enviar(mensagem);
    }

}
