package factorynotificao;
public class App {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.enviarNotificao(new emailFactory(), "Email uau");

        service.enviarNotificao(new smsFactory(), "Sms Uau");

        service.enviarNotificao(new pushFactory(), "Push uau");
    }
}
