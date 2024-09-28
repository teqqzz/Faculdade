package factorynotificao;
public class smsFactory extends NotificaoFactory {
    @Override
    public iNotificacao criarNotificacao(){
        return new notificacaoSMS();
    }
}
