import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
    private Mapa mapaJogador1;
    private Mapa mapaJogador2;
    private Jogador jogador1;
    private Jogador jogador2;
    private Logger logger;
    private int numeroPartidas;

    public Jogo() {
        // Inicializa os mapas dos jogadores, o logger e o contador de partidas
        this.mapaJogador1 = new Mapa(16, 16);
        this.mapaJogador2 = new Mapa(16, 16);
        this.logger = new Logger();
        this.numeroPartidas = 0;
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        // Inicia o jogo e solicita o nome do jogador
        System.out.println("Bem-vindo ao jogo de Batalha Naval!");
        System.out.println("Digite o nome do jogador:");
        String nomeJogador1 = scanner.next();
        jogador1 = new Jogador(nomeJogador1);
        jogador2 = new Jogador("Computador");

        // Loop principal do jogo
        while (true) {

            jogarSolo(scanner); // Inicia uma partida
            numeroPartidas++; // Incrementa o número de partidas jogadas
            System.out.println("Deseja encerrar o jogo? (s/n)");
            String encerrar = scanner.next();
            if (encerrar.equalsIgnoreCase("s")) {
                exibirPontuacao(); // Exibe a pontuação final
                break;
            }
            else if(encerrar.equalsIgnoreCase("n")){
                mapaJogador1.limparMapa();
                mapaJogador2.limparMapa();
            }
            else{
                System.out.println("Selecione uma opcao valida");
            }
        }

        scanner.close();
    }

    private void jogarSolo(Scanner scanner) {
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.posicionarEmbarcacoes(mapaJogador2); // Posiciona as embarcações do computador
        System.out.println("Mapa do Computador:");
        mapaJogador2.imprimirMapa();
        System.out.println("");
        System.out.println("Seu Mapa:");
        embarcacao.posicionarEmbarcacoes(mapaJogador1); // Posiciona as embarcações do jogador
        mapaJogador1.imprimirMapa();
        System.out.println("");

        // Loop para permitir ao jogador trocar seu mapa
        while (true) {
            System.out.println("Vez do jogador " + jogador1.getNome());
            System.out.println("Deseja trocar o seu mapa? (s/n)");
            String continuar = scanner.next();
            if (continuar.equalsIgnoreCase("s")) {
                // Reinicia o mapa do jogador
                int tamanhoOriginalX = mapaJogador1.getTamanhoX();
                int tamanhoOriginalY = mapaJogador1.getTamanhoY();
                mapaJogador1 = new Mapa(tamanhoOriginalX, tamanhoOriginalY);
                embarcacao.posicionarEmbarcacoes(mapaJogador1);
                mapaJogador1.imprimirMapa();
            } else if (continuar.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Opção inválida. Digite 's' para trocar o mapa ou 'n' para continuar.");
            }
        }

        // Exibe os mapas parciais


        System.out.println("Pontuação:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao());
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao());
        System.out.println("");

        System.out.println("Mapa Parcial do Computador:");
        mapaJogador2.imprimirMapaParcial();
        System.out.println("");
        System.out.println("Mapa Parcial do Jogador1:");
        mapaJogador1.imprimirMapaParcial();
        System.out.println("");

        // Loop principal da partida
        while (true) {
            // Loop para garantir que o jogador selecione uma posição válida para ataque
            int x, y;
            while (true) {
                System.out.println("Digite a coordenada x para atacar:");
                x = scanner.nextInt();
                System.out.println("Digite a coordenada y para atacar:");
                y = scanner.nextInt();
    
                // Verifica se as coordenadas estão dentro do mapa
                if (x < 1 || x > mapaJogador2.getTamanhoX() || y < 1 || y > mapaJogador2.getTamanhoY()) {
                    System.out.println("Coordenadas fora do mapa. Por favor, escolha novamente.");
                } else if (mapaJogador2.getMapa()[x - 1][y - 1] == 'X' || mapaJogador2.getMapa()[x - 1][y - 1] == 'E') {
                    System.out.println("Você já atacou essa posição. Por favor, escolha novamente.");
                } else {
                    break;
                }
            }
    
            boolean acertou = jogador1.atacarPosicao(x, y, mapaJogador2);
    
            if (acertou) {
                System.out.println("Você acertou um navio!");
                logger.registrarAtaque(jogador1.getNome(), x, y, true, jogador1.getNome(), mapaJogador2,
                        jogador1.getPontuacao(), jogador2.getPontuacao());
                        jogador1.aumentarPontuacao();
            } else {
                System.out.println("Você errou o ataque.");
                logger.registrarAtaque(jogador1.getNome(), x, y, false, jogador1.getNome(), mapaJogador2,
                        jogador1.getPontuacao(), jogador2.getPontuacao());
            }
           
            // Jogada do computador
            System.out.println("Agora é a vez do " + jogador2.getNome() + " atacar...");
            int xPc,yPc;
            Random random = new Random();
            xPc = random.nextInt(mapaJogador1.getTamanhoX()) + 1;
            yPc = random.nextInt(mapaJogador1.getTamanhoY()) + 1;
            
        boolean acertouPc = jogador2.atacarPosicaoPc(xPc, yPc, mapaJogador1);

            if (acertouPc) {
                System.out.println("O " + jogador2.getNome() + " acertou um navio!");
                logger.registrarAtaque(jogador2.getNome(), xPc, yPc, true, jogador2.getNome(), mapaJogador1,
                        jogador2.getPontuacao(), jogador1.getPontuacao());
                        jogador2.aumentarPontuacao();
            } else {
                System.out.println("O " + jogador2.getNome() + " errou o ataque.");
                logger.registrarAtaque(jogador2.getNome(), xPc, yPc, false, jogador2.getNome(), mapaJogador1,
                        jogador2.getPontuacao(), jogador1.getPontuacao());
            }

            System.out.println("Pontuação:");
            System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao());
            System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao());
            System.out.println("");

            // Exibe os mapas parciais após as jogadas
            System.out.println("Mapa Parcial do Computador:");
            mapaJogador2.imprimirMapaParcial();
            System.out.println("");
            System.out.println("Mapa Parcial do Jogador1:");
            mapaJogador1.imprimirMapaParcial();
            System.out.println("");

            // Verifica se algum dos jogadores venceu
            if (jogador1.todosNaviosAfundados(mapaJogador1)) {
                System.out.println("Todos os navios do jogador " + jogador1.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador2.getNome() + " venceu!");
                
                logger.registrarVitoria(jogador2.getNome());
                logger.salvarLog();
                break;
            } else if (jogador2.todosNaviosAfundados(mapaJogador2)) {
                System.out.println("Todos os navios do jogador " + jogador2.getNome() + " foram afundados!");
                System.out.println("O jogador " + jogador1.getNome() + " venceu!");
                logger.registrarVitoria(jogador1.getNome());
                logger.salvarLog();
                break;
            }
        }
    }

    private void exibirPontuacao() {
        // Exibe a pontuação final dos jogadores
        System.out.println("Pontuação final:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao() );
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao() );
        System.out.println("Número total de partidas jogadas: " + numeroPartidas);
    }

    public static void main(String[] args) {
        // Método main para iniciar o jogo
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}

class Logger {
    private List<String> log;

    public Logger() {
        // Inicializa o registro de log
        this.log = new ArrayList<>();
    }

    // Registra os ataques no log
    public void registrarAtaque(String jogador, int x, int y, boolean acertou, String nomeJogador, Mapa mapaJogador,
            int pontuacaoJogador1, int pontuacaoJogador2) {
        StringBuilder entry = new StringBuilder();
        entry.append("Ataque: Jogador ").append(jogador)
                .append(", Coordenadas: (").append(x).append(", ").append(y)
                .append("), Acertou: ").append(acertou).append("\n");

        // Adiciona o mapa parcial ao log
        entry.append("Mapa de " + nomeJogador + ":");
        char[][] mapaParcial = mapaJogador.getMapa();
        for (int i = 0; i < mapaParcial.length; i++) {
            for (int j = 0; j < mapaParcial[i].length; j++) {
                entry.append(mapaParcial[i][j]).append(" ");
            }
            entry.append("\n");
        }
        entry.append("\n");

        // Adiciona a pontuação ao log
        entry.append("Pontuação:\n");
        entry.append(jogador + ": " + pontuacaoJogador1);
        entry.append("Computador: " + pontuacaoJogador2);
        entry.append("\n");

        log.add(entry.toString());
    }

    // Registra a vitória no log
    public void registrarVitoria(String jogador) {
        log.add("Vitória: Jogador " + jogador);
    }
    // Salva o log em um arquivo
    public void salvarLog() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt"))) {
            for (String entry : log) {
                writer.println(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}