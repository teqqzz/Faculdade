public class Moto implements MotorMoto {
    public boolean motoLigada = false;
    public int velocidade = 0;
    public Boolean ligarMoto(){
        if(!motoLigada){
            System.out.println("Moto Ligada");
        }
        return motoLigada = true;
    }
    public Boolean desligarMoto(){
        if(motoLigada){
            System.out.println("Moto Desligada");
        }
        return motoLigada = false;
    }

    public void acelerarM(){
        if (motoLigada){
            velocidade += 10;
            System.out.println("Sua velocidade e " +velocidade+ "km/h");
        }
    }
    public void frearM(){
        if (motoLigada){
            velocidade -= 10;
            System.out.println("Sua velocidade e " +velocidade+ "km/h");
        }
    }
}
