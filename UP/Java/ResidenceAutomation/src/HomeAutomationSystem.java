public class HomeAutomationSystem {
    public static void main(String[] args) {
        SmartDevice camera = new SmartCamera();
        SmartDevice light = new SmartLight();
        
        ControlMethod appControl = new AppControl();
        ControlMethod voiceControl = new VoiceControl();


        Room livingRoom = new Room(camera, appControl);
        Room bedroom = new Room(light, voiceControl);

        System.out.println("Controlando a câmera na sala de estar:");
        livingRoom.controlDevice("ligar");
        
        System.out.println("\nControlando a luz no quarto:");
        bedroom.controlDevice("ligar");
        
        System.out.println("\nDesligando a câmera na sala de estar:");
        livingRoom.controlDevice("desligar");
        
        System.out.println("\nDesligando a luz no quarto:");
        bedroom.controlDevice("desligar");
    }
}
