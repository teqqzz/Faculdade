package factorynotificao;
public class emailFactory extends NotificaoFactory {
    public iNotificacao criarNotificacao(){
        return new notificaoEmail();
    }

}
