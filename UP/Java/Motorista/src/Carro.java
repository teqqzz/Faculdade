public class Carro implements MotorCarro {
    public boolean carroLigado = false;
    public int velocidade = 0;
    
    public Boolean ligarCarro(){
        if (!carroLigado){
            carroLigado = true;
            System.out.println("Carro Ligado");
        }
            return carroLigado;}
    public Boolean desligarCarro(){
        if(carroLigado){
            carroLigado = false;
            System.out.println("Carro Desligado");
        }
            return carroLigado;}

    public void acelerar(){
        if (carroLigado){
            velocidade += 10;
            System.out.println("Sua velocidade atual e " +velocidade + "km/h");
        }
    }
    public void frear(){
        if (carroLigado){
            velocidade -= 10;
            System.out.println("Sua velocidade atual e " +velocidade + "km/h");
        }
        
    }
}
