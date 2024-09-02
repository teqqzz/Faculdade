import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
public class Jogador implements Serializable {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        // Construtor da classe Jogador
        this.nome = nome;
        this.pontuacao = 0;
    }

    public String getNome() {
        // Retorna o nome do jogador
        return nome;
    }

    public int getPontuacao() {
        // Retorna a pontuação do jogador
        return pontuacao;
    }

    public void aumentarPontuacao() {
        // Incrementa a pontuação do jogador
        pontuacao++;
    }

    public boolean atacarPosicao(int x, int y, Mapa mapa) {
        // Método para o jogador atacar uma posição no mapa
        // Verificar se as coordenadas estão dentro do mapa
        if (x < 1 || x > mapa.getTamanhoX() || y < 1 || y > mapa.getTamanhoY()) {
            System.out.println("Coordenadas fora do mapa.");
            return false;
        }
        
        char alvo = mapa.getMapa()[x - 1][y - 1]; // Ajuste para a indexação correta
        if (alvo == 'A' || alvo == 'D' || alvo == 'S' || alvo == 'F' || alvo == 'B') {
            // Navio atingido
            char[][] mapaAtual = mapa.getMapa();
            
            // Marcar toda a embarcação atingida como atingida
            marcarEmbarcacaoAtingida(mapaAtual, x - 1, y - 1, alvo);
            return true;
        } else {
            mapa.getMapa()[x - 1][y - 1] = 'E'; // Marcar a posição como Erro/água
            return false;
        }
    }
    private void marcarEmbarcacaoAtingida(char[][] mapa, int startX, int startY, char tipoEmbarcacao) {
    // Método para marcar toda a embarcação atingida como atingida
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY});
    
    while (!queue.isEmpty()) {
        int[] position = queue.poll();
        int x = position[0];
        int y = position[1];
        
        if (mapa[x][y] == tipoEmbarcacao) {
            mapa[x][y] = 'X'; // Marcar a posição como atingida
            
            // Adicionar vizinhos à fila para processamento
            if (x - 1 >= 0 && mapa[x - 1][y] == tipoEmbarcacao) {
                queue.add(new int[]{x - 1, y});
            }
            if (x + 1 < mapa.length && mapa[x + 1][y] == tipoEmbarcacao) {
                queue.add(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && mapa[x][y - 1] == tipoEmbarcacao) {
                queue.add(new int[]{x, y - 1});
            }
            if (y + 1 < mapa[0].length && mapa[x][y + 1] == tipoEmbarcacao) {
                queue.add(new int[]{x, y + 1});
            }
        }
    }
}

public boolean atacarPosicao2(int x, int y, Mapa mapa) {
    // Método para o jogador atacar uma posição no mapa
    // Verificar se as coordenadas estão dentro do mapa
    if (x < 1 || x > mapa.getTamanhoX() || y < 1 || y > mapa.getTamanhoY()) {
        System.out.println("Coordenadas fora do mapa.");
        return false;
    }
    
    char alvo = mapa.getMapa()[x - 1][y - 1]; // Ajuste para a indexação correta
    if (alvo == 'A' || alvo == 'D' || alvo == 'S' || alvo == 'F' || alvo == 'B') {
        // Navio atingido
        char[][] mapaAtual = mapa.getMapa();
        
        // Marcar toda a embarcação atingida como atingida
        marcarEmbarcacaoAtingida2(mapaAtual, x - 1, y - 1, alvo);
        return true;
    } else {
        mapa.getMapa()[x - 1][y - 1] = 'E'; // Marcar a posição como Erro/água
        return false;
    }
}

    private void marcarEmbarcacaoAtingida2(char[][] mapa, int startX, int startY, char tipoEmbarcacao) {
        // Método para marcar toda a embarcação atingida como atingida
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            
            if (mapa[x][y] == tipoEmbarcacao) {
                mapa[x][y] = 'X'; // Marcar a posição como atingida
                
                // Adicionar vizinhos à fila para processamento
                if (x - 1 >= 0 && mapa[x - 1][y] == tipoEmbarcacao) {
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < mapa.length && mapa[x + 1][y] == tipoEmbarcacao) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && mapa[x][y - 1] == tipoEmbarcacao) {
                    queue.add(new int[]{x, y - 1});
                }
                if (y + 1 < mapa[0].length && mapa[x][y + 1] == tipoEmbarcacao) {
                    queue.add(new int[]{x, y + 1});
                }
            }
        }
    }



    public boolean atacarPosicaoPc(int x, int y, Mapa mapa) {
        // Método para o jogador atacar uma posição no mapa
        // Verificar se as coordenadas estão dentro do mapa
        if (x < 1 || x > mapa.getTamanhoX() || y < 1 || y > mapa.getTamanhoY()) {
            System.out.println("Coordenadas fora do mapa.");
            return false;
        }
        
        char alvo = mapa.getMapa()[x - 1][y - 1]; // Ajuste para a indexação correta
        if (alvo == 'A' || alvo == 'D' || alvo == 'S' || alvo == 'F' || alvo == 'B') {
            // Navio atingido
            char[][] mapaAtual = mapa.getMapa();
            
            // Marcar toda a embarcação atingida como atingida
            marcarEmbarcacaoAtingidaPc(mapaAtual, x - 1, y - 1, alvo);
            return true;
        } else {
            mapa.getMapa()[x - 1][y - 1] = 'E'; // Marcar a posição como Erro/água
            return false;
        }
    }
    private void marcarEmbarcacaoAtingidaPc(char[][] mapa, int startX, int startY, char tipoEmbarcacao) {
    // Método para marcar toda a embarcação atingida como atingida
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY});
    
    while (!queue.isEmpty()) {
        int[] position = queue.poll();
        int x = position[0];
        int y = position[1];
        
        if (mapa[x][y] == tipoEmbarcacao) {
            mapa[x][y] = 'Y'; // Marcar a posição como atingida
            
            // Adicionar vizinhos à fila para processamento
            if (x - 1 >= 0 && mapa[x - 1][y] == tipoEmbarcacao) {
                queue.add(new int[]{x - 1, y});
            }
            if (x + 1 < mapa.length && mapa[x + 1][y] == tipoEmbarcacao) {
                queue.add(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && mapa[x][y - 1] == tipoEmbarcacao) {
                queue.add(new int[]{x, y - 1});
            }
            if (y + 1 < mapa[0].length && mapa[x][y + 1] == tipoEmbarcacao) {
                queue.add(new int[]{x, y + 1});
            }
        }
    }
}

public boolean atacarPosicaoPc2(int x, int y, Mapa mapa) {
    // Método para o jogador atacar uma posição no mapa
    // Verificar se as coordenadas estão dentro do mapa
    if (x < 1 || x > mapa.getTamanhoX() || y < 1 || y > mapa.getTamanhoY()) {
        System.out.println("Coordenadas fora do mapa.");
        return false;
    }
    
    char alvo = mapa.getMapa()[x - 1][y - 1]; // Ajuste para a indexação correta
    if (alvo == 'A' || alvo == 'D' || alvo == 'S' || alvo == 'F' || alvo == 'B') {
        // Navio atingido
        char[][] mapaAtual = mapa.getMapa();
        
        // Marcar toda a embarcação atingida como atingida
        marcarEmbarcacaoAtingidaPc2(mapaAtual, x - 1, y - 1, alvo);
        return true;
    } else {
        mapa.getMapa()[x - 1][y - 1] = 'E'; // Marcar a posição como Erro/água
        return false;
    }
}
private void marcarEmbarcacaoAtingidaPc2(char[][] mapa, int startX, int startY, char tipoEmbarcacao) {
// Método para marcar toda a embarcação atingida como atingida
Queue<int[]> queue = new LinkedList<>();
queue.add(new int[]{startX, startY});

while (!queue.isEmpty()) {
    int[] position = queue.poll();
    int x = position[0];
    int y = position[1];
    
    if (mapa[x][y] == tipoEmbarcacao) {
        mapa[x][y] = 'Y'; // Marcar a posição como atingida
        
        // Adicionar vizinhos à fila para processamento
        if (x - 1 >= 0 && mapa[x - 1][y] == tipoEmbarcacao) {
            queue.add(new int[]{x - 1, y});
        }
        if (x + 1 < mapa.length && mapa[x + 1][y] == tipoEmbarcacao) {
            queue.add(new int[]{x + 1, y});
        }
        if (y - 1 >= 0 && mapa[x][y - 1] == tipoEmbarcacao) {
            queue.add(new int[]{x, y - 1});
        }
        if (y + 1 < mapa[0].length && mapa[x][y + 1] == tipoEmbarcacao) {
            queue.add(new int[]{x, y + 1});
        }
    }
}
}

    public boolean todosNaviosAfundados(Mapa mapa) {
        // Método para verificar se todos os navios do jogador foram afundados
        char[][] mapaAtual = mapa.getMapa();
        for (int i = 0; i < mapa.getTamanhoX(); i++) {
            for (int j = 0; j < mapa.getTamanhoY(); j++) {
                if (mapaAtual[i][j] == 'A' || mapaAtual[i][j] == 'D' || mapaAtual[i][j] == 'S' || mapaAtual[i][j] == 'F'
                        || mapaAtual[i][j] == 'B') {
                    return false; // Se ainda houver algum navio não afundado, retorna false
                }
            }
        }
        return true; // Se todos os navios foram afundados, retorna true
    }
}