import java.io.*;
public class MainCarro {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Carro carro = new Carro();
        Motora motora = new Motora(carro);

        try{
            System.out.println("Caso Deseje Ligar o Carro Gire a Chave");
            System.out.println("Deseja Girar a Chave(aperte s)");
            String chave = reader.readLine();
            boolean s = false;
                if(chave.equalsIgnoreCase("s")){
                    motora.ligarCarro();
                    while(!s){
                        
                        System.out.println("Caso Deseje Acelerar(a) ou Frear(f) ou Desligar(d)");
                        chave = reader.readLine();
                            if(chave.equalsIgnoreCase("a")){
                                motora.acelerar();
                            }
                            else if(chave.equalsIgnoreCase("f")){
                                motora.frear();
                            }
                            else if(chave.equalsIgnoreCase("d")){
                                motora.desligarCarro();
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
