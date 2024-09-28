public class Motora {
    public Carro carro;

    public Motora(Carro carro){
        this.carro = carro;
    }

    public boolean ligarCarro(){
        return carro.ligarCarro();
    }
    public boolean desligarCarro(){
        return carro.desligarCarro();
    }
    public void acelerar(){
        carro.acelerar();
    }
    public void frear(){
        carro.frear();
    }

    public Moto moto;
    public Motora(Moto moto){
        this.moto = moto;
    }

    public boolean ligarMoto(){
        return moto.ligarMoto();
    }
    public boolean desligarMoto(){
        return moto.desligarMoto();
    }
    public void acelerarM(){
        moto.acelerarM();
    }
    public void frearM(){
        moto.frearM();
    }
}
