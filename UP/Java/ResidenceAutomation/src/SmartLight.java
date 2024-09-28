public class SmartLight implements SmartDevice {
    public Boolean On = false;

    public Boolean turnOn(){
        return On = true;
    }
    public Boolean turnOff(){
        return On = false;
    }
    public String Status(){
        if(On){
        return "Ligado";}
        else{
            return "Desligado";}
        }

}
