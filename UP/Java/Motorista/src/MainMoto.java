import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMoto {
    public static void main(String[] args) {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Moto moto = new Moto();
        Motora motora = new Motora(moto);

        try{
            System.out.println("Caso Deseje Ligar a Moto Gire a Chave");
            System.out.println("Deseja Girar a Chave(aperte s)");
            String chave = reader.readLine();
            boolean s = false;
                if(chave.equalsIgnoreCase("s")){
                    motora.ligarMoto();
                    while(!s){
                        
                        System.out.println("Caso Deseje Acelerar(a) ou Frear(f) ou Desligar(d)");
                        chave = reader.readLine();
                            if(chave.equalsIgnoreCase("a")){
                                motora.acelerarM();
                            }
                            else if(chave.equalsIgnoreCase("f")){
                                motora.frearM();
                            }
                            else if(chave.equalsIgnoreCase("d")){
                                motora.desligarMoto();
                                s = true;
                            }
                    }
                }
                else{
                    System.out.println("Voce não Ligou o carro");   
                }
            reader.close();
        }catch (IOException e){}   
    }
}
  