public class Room {
    private ControlMethod controlMethod;
    private SmartDevice smartDevice;

    public Room(SmartDevice smartDevice, ControlMethod controlMethod ){
        this.smartDevice = smartDevice;
        this.controlMethod = controlMethod;
    }
    public void controlDevice(String command) {
        System.out.println("Status do dispositivo: " + smartDevice.Status());
        controlMethod.sendCommand(command);
        
        if (command.equalsIgnoreCase("ligar")) {
            smartDevice.turnOn();
        } else if (command.equalsIgnoreCase("desligar")) {
            smartDevice.turnOff();
        }
        
        System.out.println("Status do dispositivo: " + smartDevice.Status());
    }
}

