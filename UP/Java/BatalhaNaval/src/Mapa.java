import java.io.Serializable;

public class Mapa implements Serializable {
    private char[][] mapa;
    private int tamanhoX;
    private int tamanhoY;

    public Mapa(int tamanhoX, int tamanhoY) {
        // Construtor da classe Mapa
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.mapa = new char[tamanhoX][tamanhoY];
        inicializarMapa();
    }

    public void setMapa(char[][] novoMapa) {
        // Método para definir um novo mapa
        this.mapa = novoMapa;
    }

    private void inicializarMapa() {
        // Método para inicializar o mapa com espaços vazios ('V')
        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = 'V';
            }
        }
    }

    public int getTamanhoX() {
        // Retorna o tamanho X do mapa
        return tamanhoX;
    }

    public int getTamanhoY() {
        // Retorna o tamanho Y do mapa
        return tamanhoY;
    }

    public char[][] getMapa() {
        // Retorna o mapa
        return mapa;
    }

    public void imprimirMapa() {
        // Método para imprimir o mapa completo
        System.out.print("       ");
        for (int i = 1; i <= tamanhoY; i++) {
            System.out.printf(" [%2d ] ", i);
        }                                                    
        System.out.println();

        for (int i = 0; i < tamanhoX; i++) {
            System.out.printf(" [%2d ] ", i + 1);
            for (int j = 0; j < tamanhoY; j++) {
                if (mapa[i][j] == 'V') {
                    System.out.print(" [ O ] ");
                } else {
                    System.out.printf(" [ %c ] ", mapa[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    public void atualizarMapaParcial(int x, int y, char symbol) {
        // Método para atualizar uma posição específica do mapa com um símbolo específico
        mapa[x][y] = symbol;
    }
    
    public void imprimirMapaParcial() {
        // Método para imprimir uma versão parcial do mapa (com símbolos específicos)
        System.out.print("       ");
        for (int i = 1; i <= tamanhoY; i++) {
            System.out.printf(" [%2d ] ", i);
        }
        System.out.println();
    
        for (int i = 0; i < tamanhoX; i++) {
            System.out.printf(" [%2d ] ", i + 1);
            for (int j = 0; j < tamanhoY; j++) {
                char symbol = mapa[i][j];
                if (symbol == 'X' || symbol == 'Y' || symbol == 'J' || symbol =='C') {
                    System.out.printf(" [ %c ] ", symbol);
                } else if (symbol == 'E') {
                    System.out.printf(" [ %c ] ", symbol); 
                } else {
                    System.out.print(" [   ] ");
                }
            }
            System.out.println();
        }
    }

    public String toString() {
        // Método para representar o mapa como uma string
        StringBuilder sb = new StringBuilder();
        
        // Adiciona os números das colunas
        sb.append("     ");
        for (int i = 1; i <= tamanhoY; i++) {
            sb.append(String.format("[%2d ]", i));
        }
        sb.append("\n");
    
        // Adiciona o conteúdo do mapa com os números das linhas
        for (int i = 0; i < tamanhoX; i++) {
            sb.append(String.format("[%2d ]", i + 1));
            for (int j = 0; j < tamanhoY; j++) {
                sb.append("[ ");
                if (mapa[i][j] == 'V') {
                    sb.append("O"); // Exibe "O" para espaços Ocultos
                } else {
                    sb.append(mapa[i][j]);
                }
                sb.append(" ]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void limparMapa() {
        // Método para limpar o mapa, redefinindo todas as posições para espaços vazios ('V')
        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = 'V';
            }
        }
    }
}