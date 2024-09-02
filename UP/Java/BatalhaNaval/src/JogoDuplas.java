import java.util.Scanner;
import java.util.Random;

// Classe principal do jogo de batalha naval em duplas
public class JogoDuplas {
    private Mapa mapaequipeJogador1; // Mapa da equipe do jogador 1
    private Mapa mapaequipeJogador2; // Mapa da equipe do jogador 2
    private Jogador jogador1; // Jogador 1
    private Jogador jogador2; // Jogador 2 (computador)
    private Jogador jogador3; // Jogador 3
    private Jogador jogador4; // Jogador 4 (computador)
    private int numeroPartidas; // Número total de partidas jogadas

    // Construtor da classe JogoDuplas
    public JogoDuplas() {
        this.mapaequipeJogador1 = new Mapa(4, 4); // Inicializa o mapa da equipe do jogador 1
        this.mapaequipeJogador2 = new Mapa(4, 4); // Inicializa o mapa da equipe do jogador 2
        this.numeroPartidas = 0; // Inicializa o número de partidas jogadas
    }

    // Método para iniciar o jogo
    public void iniciarJogoDuplas() {
        Scanner scanner = new Scanner(System.in); // Cria um Scanner para entrada de dados

        System.out.println("Bem-vindo ao jogo de Batalha Naval!");
        System.out.println("Digite o nome do jogador1:");
        String nomeJogador1 = scanner.next();
        jogador1 = new Jogador(nomeJogador1);

        System.out.println("Digite o nome do jogador2:");
        String nomeJogador3 = scanner.next();
        jogador3 = new Jogador(nomeJogador3);

        jogador2 = new Jogador("Computador");
        jogador4 = new Jogador("Computador2");

        Embarcacao embarcacao = new Embarcacao();
        embarcacao.posicionarEmbarcacoes(mapaequipeJogador2);
        System.out.println("Mapa do Computador:");
        mapaequipeJogador2.imprimirMapa();
        System.out.println("");
        System.out.println("Seu Mapa:");
        embarcacao.posicionarEmbarcacoes(mapaequipeJogador1);
        mapaequipeJogador1.imprimirMapa();
        System.out.println("");

        while (true) {
            System.out.println("Vez do jogador " + jogador1.getNome());
            System.out.println("Deseja trocar o seu mapa? (s/n)");
            String continuar = scanner.next();
            if (continuar.equalsIgnoreCase("s")) {
                int tamanhoOriginalX = mapaequipeJogador1.getTamanhoX();
                int tamanhoOriginalY = mapaequipeJogador1.getTamanhoY();
                mapaequipeJogador1 = new Mapa(tamanhoOriginalX, tamanhoOriginalY);
                embarcacao.posicionarEmbarcacoes(mapaequipeJogador1);
                mapaequipeJogador1.imprimirMapa();
            } else if (continuar.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Opção inválida. Digite 's' para trocar o mapa ou 'n' para continuar.");
            }
        }

        while (true) {
            jogarDuplas(scanner);
            numeroPartidas++;
            System.out.println("Deseja encerrar o jogo? (s/n)");
            String encerrar = scanner.next();
            if (encerrar.equalsIgnoreCase("s")) {
                exibirPontuacao();
                break;
            }
            else{
                mapaequipeJogador1.limparMapa();
                mapaequipeJogador2.limparMapa();
            }
        }

        scanner.close();
    }

    // Método para controlar o fluxo do jogo
    private void jogarDuplas(Scanner scanner) {

        System.out.println("Mapa Parcial do Computador:");
        mapaequipeJogador2.imprimirMapaParcial();
        System.out.println("");
        System.out.println("Mapa Parcial do Jogador1:");
        mapaequipeJogador1.imprimirMapaParcial();
        System.out.println("");

        while (true) {
            int x, y;
            while (true) {
                System.out.println("Digite a coordenada x para atacar " +jogador1+":");
                x = scanner.nextInt();
                System.out.println("Digite a coordenada y para atacar " +jogador1+":");
                y = scanner.nextInt();
    
                // Verifica se as coordenadas estão dentro do mapa
                if (x < 1 || x > mapaequipeJogador2.getTamanhoX() || y < 1 || y > mapaequipeJogador2.getTamanhoY()) {
                    System.out.println("Coordenadas fora do mapa. Por favor, escolha novamente.");
                } else if (mapaequipeJogador2.getMapa()[x - 1][y - 1] == 'X' || mapaequipeJogador2.getMapa()[x - 1][y - 1] == 'E') {
                    System.out.println("Você já atacou essa posição. Por favor, escolha novamente.");
                } else {
                    break;
                }
            }
            boolean acertou = jogador1.atacarPosicao(x, y, mapaequipeJogador2);

            if (acertou) {
                System.out.println("Você acertou um navio!");
                        jogador1.aumentarPontuacao();
            } else {
                System.out.println("Você errou o ataque.");
            }

            System.out.println("Agora é a vez do " + jogador2.getNome() + "atacar...");
            Random random = new Random();
            int xPc,yPc;
            xPc = random.nextInt(mapaequipeJogador1.getTamanhoX()) + 1;
            yPc = random.nextInt(mapaequipeJogador1.getTamanhoY()) + 1;
            boolean acertouPc = jogador2.atacarPosicaoPc(xPc, yPc, mapaequipeJogador1);

            if (acertouPc) {
                System.out.println("O " + jogador2.getNome() + " acertou um navio!");

                        jogador2.aumentarPontuacao();
            } else {
                System.out.println("O " + jogador2.getNome() + " errou o ataque.");

            }

            System.out.println("Pontuação:");
            System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao());
            System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao());
            System.out.println(jogador3.getNome() + ": " + jogador3.getPontuacao());
            System.out.println(jogador4.getNome() + ": " + jogador4.getPontuacao());
            System.out.println("");

            System.out.println("Mapa Parcial do Computador:");
            mapaequipeJogador2.imprimirMapaParcial();
            System.out.println("");
            System.out.println("Mapa Parcial do Jogador1:");
            mapaequipeJogador1.imprimirMapaParcial();
            System.out.println("");

            while (true) {
                while (true) {
                    System.out.println("Digite a coordenada x para atacar " +jogador3+":");
                    x = scanner.nextInt();
                    System.out.println("Digite a coordenada y para atacar " +jogador3+":");
                    y = scanner.nextInt();
        
                    // Verifica se as coordenadas estão dentro do mapa
                    if (x < 1 || x > mapaequipeJogador2.getTamanhoX() || y < 1 || y > mapaequipeJogador2.getTamanhoY()) {
                        System.out.println("Coordenadas fora do mapa. Por favor, escolha novamente.");
                    } else if (mapaequipeJogador2.getMapa()[x - 1][y - 1] == 'J' || mapaequipeJogador2.getMapa()[x - 1][y - 1] == 'E') {
                        System.out.println("Você já atacou essa posição. Por favor, escolha novamente.");
                    } else {
                        break;
                    }
                }
                acertou = jogador3.atacarPosicao2(x, y, mapaequipeJogador2);

                if (acertou) {
                    System.out.println("Você acertou um navio!");
                            jogador3.aumentarPontuacao();
                } else {
                    System.out.println("Você errou o ataque.");

                }

                System.out.println("Agora é a vez do " + jogador4.getNome() + "atacar...");
                // Gerar coordenadas aleatórias para o ataque do computador
                xPc = random.nextInt(mapaequipeJogador1.getTamanhoX()) + 1;
                yPc = random.nextInt(mapaequipeJogador1.getTamanhoY()) + 1;
                acertouPc = jogador2.atacarPosicaoPc2(xPc, yPc, mapaequipeJogador1);

                if (acertouPc) {
                    System.out.println("O " + jogador4.getNome() + " acertou um navio!");
                            jogador4.aumentarPontuacao();
                } else {
                    System.out.println("O " + jogador4.getNome() + " errou o ataque.");
                }

                System.out.println("Pontuação:");
                System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao());
                System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao());
                System.out.println(jogador3.getNome() + ": " + jogador3.getPontuacao());
                System.out.println(jogador4.getNome() + ": " + jogador4.getPontuacao());
                System.out.println("");
                
                System.out.println("Mapa Parcial do Computador:");
                mapaequipeJogador2.imprimirMapaParcial();
                System.out.println("");
                System.out.println("Mapa Parcial do Jogador1:");
                mapaequipeJogador1.imprimirMapaParcial();
                System.out.println("");

                if (jogador1.todosNaviosAfundados(mapaequipeJogador1)) {
                    System.out.println("Todos os navios do jogador " + jogador1.getNome() + " foram afundados!");
                    System.out.println("O jogador " + jogador2.getNome() + " venceu!");

                    break;
                } else if (jogador2.todosNaviosAfundados(mapaequipeJogador2)) {
                    System.out.println("Todos os navios do jogador " + jogador2.getNome() + " foram afundados!");
                    System.out.println("O jogador " + jogador1.getNome() + " venceu!");

                    break;
                }
            }
        }
    }

    // Método para exibir a pontuação final do jogo
    private void exibirPontuacao() {
        System.out.println("Pontuação final:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao() + " vitórias.");
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao() + " vitórias.");
        System.out.println("Número total de partidas jogadas: " + numeroPartidas);
    }

    // Método principal
    public static void main(String[] args) {
        JogoDuplas jogoDuplas = new JogoDuplas();
        jogoDuplas.iniciarJogoDuplas();
    }
}
