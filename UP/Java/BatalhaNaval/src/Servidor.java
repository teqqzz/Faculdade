import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(80);
        System.out.println("Servidor iniciado na porta 80");

        Socket client = server.accept();
        System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());

        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(client.getInputStream());

        System.out.println("Jogador conectado. A partida iniciará em breve!");

        Jogador jogador1 = new Jogador("Servidor");
        Jogador jogador2 = new Jogador("Cliente");
        Mapa mapaJogador1 = new Mapa(16, 16);
        Mapa mapaJogador2 = new Mapa(16, 16);
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.posicionarEmbarcacoes(mapaJogador1);
        embarcacao.posicionarEmbarcacoes(mapaJogador2);
        int jogadorAtual = 1;
        out.writeObject(jogador1);
        out.writeObject(jogador2);
        out.writeObject(mapaJogador1);
        out.writeObject(mapaJogador2);
        out.writeInt(jogadorAtual);

        while (true) {
            System.out.println("Seu mapa:");
            System.out.println(mapaJogador1);
            System.out.println("Mapa do adversário:");
            System.out.println(mapaJogador2);

            if (jogadorAtual == 2) {
                System.out.println("Aguardando o ataque do adversário...");
                int cx = in.readInt();
                int cy = in.readInt();
                boolean acertouoServidor = jogador2.atacarPosicao(cx, cy, mapaJogador1);
                if (acertouoServidor) {
                    System.out.println("O "+jogador2.getNome()+ "acertou um navio!");
                } else {
                    System.out.println("O "+jogador2.getNome()+ "errou o ataque.");
                }
                jogadorAtual = in.readInt();
            }

            if(jogadorAtual == 1) {
                int sx,sy;
              while(true){ 
                System.out.println("Sua vez de atacar!");
                System.out.println("Informe as coordenadas para atacar:");
                System.out.print("Coordenada X: ");
                sx = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                System.out.print("Coordenada Y: ");
                sy = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

                if (sx < 1 || sx > mapaJogador2.getTamanhoX() || sy < 1 || sy > mapaJogador2.getTamanhoY()) {
                    System.out.println("Coordenadas fora do mapa. Por favor, escolha novamente.");
                } else if (mapaJogador2.getMapa()[sx - 1][sy - 1] == 'X' || mapaJogador2.getMapa()[sx - 1][sy - 1] == 'E') {
                    System.out.println("Você já atacou essa posição. Por favor, escolha novamente.");
                } else {
                    break;
                }
            } 

                out.writeInt(sx);
                out.writeInt(sy);
                out.flush();
                boolean acertouoCliente = jogador1.atacarPosicao(sx, sy, mapaJogador2);
                if (acertouoCliente) {
                    System.out.println("Você acertou um navio!");
                } else {
                    System.out.println("Você errou o ataque.");
                }
                jogadorAtual = in.readInt();
            }
            if (jogador1.todosNaviosAfundados(mapaJogador1)) {
                System.out.println("Todos os navios do jogador " + jogador1.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador2.getNome() + " venceu!");
                jogador2.aumentarPontuacao();
                break;
            } else if (jogador2.todosNaviosAfundados(mapaJogador2)) {
                System.out.println("Todos os navios do jogador " + jogador2.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador1.getNome() + " venceu!");
                jogador1.aumentarPontuacao();
                break;
            }
        
        }
     server.close();   
    }
    
}
