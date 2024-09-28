package factorynotificao;
    public class pushFactory extends NotificaoFactory{

        @Override
        public iNotificacao criarNotificacao() {
            return new notificacaoPush();
            
        }
        
    }

