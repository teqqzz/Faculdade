import java.util.Random;

public class Embarcacao {

    public void posicionarEmbarcacoes(Mapa mapa) {
        // Método para posicionar todas as embarcações no mapa
        posicionarPA(mapa, 2); // Posiciona 2 Porta Aviões
        posicionarDestroyer(mapa, 3); // Posiciona 3 Destroyers
        posicionarSubmarino(mapa, 4); // Posiciona 4 Submarinos
        posicionarFragata(mapa, 5); // Posiciona 5 Fragatas
        posicionarBote(mapa, 6); // Posiciona 6 Fragatas
       
    }

    private void posicionarPA(Mapa mapa, int quantidade) {
        // Método para posicionar Porta Aviões no mapa
        posicionarEmbarcacao(mapa, quantidade, 8); // Chama o método genérico para posicionar embarcações
    }

    private void posicionarDestroyer(Mapa mapa, int quantidade) {
        // Método para posicionar Destroyers no mapa
        posicionarEmbarcacao(mapa, quantidade, 5); // Chama o método genérico para posicionar embarcações
    }

    private void posicionarSubmarino(Mapa mapa, int quantidade) {
        // Método para posicionar Submarinos no mapa
        posicionarEmbarcacao(mapa, quantidade, 4); // Chama o método genérico para posicionar embarcações
    }

    private void posicionarFragata(Mapa mapa, int quantidade) {
        // Método para posicionar Fragatas no mapa
        posicionarEmbarcacao(mapa, quantidade, 3); // Chama o método genérico para posicionar embarcações
    }

    private void posicionarBote(Mapa mapa, int quantidade) {
        // Método para posicionar Botes no mapa
        posicionarEmbarcacao(mapa, quantidade, 2); // Chama o método genérico para posicionar embarcações
    }

    private void posicionarEmbarcacao(Mapa mapa, int quantidade, int tamanho) {
        // Método genérico para posicionar uma embarcação específica no mapa
        Random random = new Random();
        char tipo = determinarTipoEmbarcacao(tamanho); // Determina o tipo da embarcação com base no tamanho
        for (int i = 0; i < quantidade; i++) {
            boolean alocado = false;
            while (!alocado) {
                int x = random.nextInt(mapa.getTamanhoX());
                int y = random.nextInt(mapa.getTamanhoY());
                boolean horizontal = random.nextBoolean();
                if (podePosicionarEmbarcacao(mapa, x, y, tamanho, horizontal)) {
                    alocarEmbarcacao(mapa, x, y, tamanho, horizontal, tipo); // Aloca a embarcação no mapa
                    alocado = true;
                }
            }
        }
    }

    private boolean podePosicionarEmbarcacao(Mapa mapa, int startX, int startY, int tamanho, boolean horizontal) {
        // Verifica se é possível posicionar uma embarcação na posição especificada
        if (horizontal) {
            if (startY + tamanho > mapa.getTamanhoY()) {
                return false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (mapa.getMapa()[startX][startY + i] != 'V') {
                    return false;
                }
            }
        } else {
            if (startX + tamanho > mapa.getTamanhoX()) {
                return false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (mapa.getMapa()[startX + i][startY] != 'V') {
                    return false;
                }
            }
        }
        return true;
    }

    private void alocarEmbarcacao(Mapa mapa, int startX, int startY, int tamanho, boolean horizontal, char tipo) {
        // Aloca a embarcação no mapa
        if (horizontal) {
            for (int i = 0; i < tamanho; i++) {
                mapa.getMapa()[startX][startY + i] = tipo;
            }
        } else {
            for (int i = 0; i < tamanho; i++) {
                mapa.getMapa()[startX + i][startY] = tipo;
            }
        }
    }

    private char determinarTipoEmbarcacao(int tamanho) {
        // Determina o tipo da embarcação com base no tamanho
        switch (tamanho) {
            case 8:
                return 'A'; // 'A' representa o Porta Aviões
            case 5:
                return 'D'; // 'D' representa o Destroyer
            case 4:
                return 'S'; // 'S' representa o Submarino
            case 3:
                return 'F'; // 'F' representa a Fragata
            case 2:
                return 'B'; // 'B' representa o Bote
            default:
                return ' '; // Retorna espaço vazio caso o tamanho não seja reconhecido
        }
    }
}