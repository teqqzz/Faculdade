import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 80);
        System.out.println("Conectado ao servidor.");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Jogador jogador1 = (Jogador) in.readObject();
        Jogador jogador2 = (Jogador) in.readObject();
        Mapa mapaJogador1 = (Mapa) in.readObject();
        Mapa mapaJogador2 = (Mapa) in.readObject();

        int jogadorAtual = in.readInt();
        while (true) {
            System.out.println("Seu mapa:");
            System.out.println(mapaJogador2);
            System.out.println("Mapa do adversário:");
            System.out.println(mapaJogador1);
            System.out.println("Aguardando o ataque do adversário...");
            if (jogadorAtual == 1) {
                while (true) {
                    int sx = in.readInt();
                    int sy = in.readInt();
                    boolean acertouoCliente = jogador1.atacarPosicao(sx, sy, mapaJogador2);
                    if (acertouoCliente) {
                        System.out.println("O "+jogador1.getNome()+ "acertou um navio!");
                    } else {
                        System.out.println("O "+jogador1.getNome()+ "errou o ataque.");
                    }
                    jogadorAtual = 2;
                    out.writeInt(jogadorAtual);
                    out.flush();
                    if (jogadorAtual == 2) {
                        break; 
                    }
                }
            }

            if (jogadorAtual == 2) {
                while (true) {
                    System.out.println("Seu mapa:");
                    System.out.println(mapaJogador2);
                    System.out.println("Mapa do adversário:");
                    System.out.println(mapaJogador1);
                    int cx,cy;
                    while(true){
                    System.out.println("Sua vez de atacar!");
                    System.out.println("Informe as coordenadas para atacar:");
                    System.out.print("Coordenada X: ");
                    cx = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    System.out.print("Coordenada Y: ");
                    cy = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    if (cx < 1 || cx > mapaJogador1.getTamanhoX() || cy < 1 || cy > mapaJogador1.getTamanhoY()) {
                        System.out.println("Coordenadas fora do mapa. Por favor, escolha novamente.");
                    } else if (mapaJogador1.getMapa()[cx - 1][cy - 1] == 'X' || mapaJogador1.getMapa()[cx - 1][cy - 1] == 'E') {
                        System.out.println("Você já atacou essa posição. Por favor, escolha novamente.");
                    } else {
                        break;
                    }
                }

                    out.writeInt(cx);
                    out.writeInt(cy);
                    out.flush();
                    boolean acertouoServidor = jogador2.atacarPosicao2(cx, cy, mapaJogador1);
                    
                    if (acertouoServidor) {
                        System.out.println("Você acertou um navio!");

                    } else {
                        System.out.println("Você errou o ataque.");
                    }
                    jogadorAtual = 1;
                    out.writeInt(jogadorAtual);
                    out.flush();

                    if (jogadorAtual == 1) {
                        break; 
                    }

                }
            }
            if (jogador1.todosNaviosAfundados(mapaJogador1)) {
                System.out.println("Todos os navios do jogador " + jogador1.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador2.getNome() + " venceu!");
                
                break;
            } else if (jogador2.todosNaviosAfundados(mapaJogador2)) {
                System.out.println("Todos os navios do jogador " + jogador2.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador1.getNome() + " venceu!");
                
                break;
            }
        }
        socket.close();
    }
    
}
