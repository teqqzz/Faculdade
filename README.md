# Projetos Acadêmicos
Este repositório contém projetos desenvolvidos durante os cursos que realizei. Cada projeto foi criado com o objetivo de aplicar os conceitos aprendidos em sala de aula em situações práticas.

## Estrutura do Repositório
**UP** (sigla da Universidade Positivo)
  - **C** (Projetos desenvolvidos em C)
    - **Atividades** (Códigos das atividades)
      - **Atividade1.c**
        - **Descrição do Programa:** 
          O programa foi desenvolvido para gerenciar as notas dos estudantes dos cursos de BSI (Bacharelado em Sistemas de Informação) e ADS (Análise e Desenvolvimento de Sistemas). O objetivo é permitir que um professor registre as notas dos alunos e gere estatísticas separadas para cada curso, seguindo as regras de aprovação estabelecidas.
        - **Funcionamento do Programa:**
          - **Estrutura Inicial:** O programa começa com a exibição de uma mensagem de boas-vindas e uma breve explicação sobre como o usuário deve proceder. Ele solicita ao usuário que insira o número total de alunos para os quais as notas serão registradas.
          - **Entrada de Dados:** Um loop `while` permite que o usuário insira notas de forma contínua até que ele decida encerrar o programa. Dentro deste loop, o programa realiza as seguintes operações:
            - Pergunta qual curso o aluno pertence (1 para BSI e 2 para ADS).
            - Solicita a nota do aluno. O programa verifica se a nota inserida é maior que 10, encerrando a execução caso isso ocorra.
            - Com base na nota, o programa classifica o aluno em aprovado, reprovado ou em final, registrando a nota da final se necessário.
            - O programa também conta quantos alunos de cada curso foram aprovados, reprovados ou ficaram de final, além de coletar estatísticas como a média das notas, percentual de aprovados e quantos alunos tiraram zero.
          - **Cálculo de Estatísticas:** Após a inserção de todas as notas, o programa calcula e exibe:
            - A média geral de cada curso.
            - O número de alunos reprovados e aprovados em cada curso.
            - O percentual total de alunos aprovados.
            - O curso que teve mais notas acima de 9.0.
            - A contagem de alunos que tiraram zero.
          - **Repetição do Processo:** Ao final, o programa pergunta se o usuário deseja repetir o processo. Se o usuário escolher continuar, o programa reinicia; caso contrário, ele exibe uma mensagem de despedida e encerra.

      - **Atividade2.c**
        - **Descrição do Programa:** 
          O programa foi projetado para ajudar a gerenciar uma frota de caminhões. O usuário pode inserir informações sobre cada caminhão durante um número especificado de meses, e o programa calcula e exibe um relatório com estatísticas relevantes.
        - **Estrutura do Código:**
          - **Definições de Constantes:**
            ```c
            #define MAX_CAMINHOES 20
            #define MAX_MESES 24
            ```
            Essas constantes definem os limites máximos de caminhões e meses que podem ser registrados no sistema.
          - **Função `processaFrota`:** Esta função é responsável por coletar e processar os dados de cada caminhão ao longo dos meses.
            - **Parâmetros:** Recebe o número de caminhões (`num_caminhoes`) e o número de meses (`num_meses`).
            - **Variáveis Locais:** `consumosMensais`, `valorm`, `kmtotal`, `caminhaomvalor`: Arrays para armazenar os dados calculados para cada mês.
            - **Laços Aninhados:** O primeiro laço percorre cada mês, enquanto o segundo laço coleta dados para cada caminhão.
              - Para cada caminhão, o programa solicita ao usuário:
                - Consumo de combustível.
                - Quilometragem percorrida.
                - Valor total transportado.
              - O programa calcula:
                - O consumo médio de combustível.
                - O caminhão que transportou o maior valor.
                - A quilometragem total percorrida pela frota.
            - Após coletar os dados, os resultados são armazenados nos arrays e, ao final, um relatório é impresso.
          - **Função `pega_valor_valido`:** Garante que o usuário insira um valor válido (entre 1 e um máximo pré-definido) para o número de caminhões e meses, utilizando um loop para verificar a validade da entrada.
          - **Função `main`:** Onde a interação com o usuário começa, solicita o tamanho da frota e o número de meses, utilizando a função `pega_valor_valido`. Após a validação, chama a função `processaFrota` para processar os dados.

      - **Atividade3.c**
        - **Descrição do Programa:** 
          O jogo da velha é um jogo simples que pode ser jogado por duas pessoas. O objetivo é alinhar três de suas marcações (X ou O) em linha, coluna ou diagonal. Este programa permite que dois jogadores joguem em um console, alternando entre eles e verificando o resultado após cada jogada.
        - **Estrutura do Código:**
          - **Definições e Inclusões:**
            ```c
            #include <stdio.h>
            #include <stdlib.h>
            #include <time.h>
            #define TAM 3
            ```
            As bibliotecas padrão são incluídas para entrada/saída e manipulação de memória. `TAM` define o tamanho do tabuleiro (3x3).
          - **Declaração das Funções:** Funções do programa são declaradas, incluindo inicialização, exibição do tabuleiro, execução de jogadas, verificação de vencedor e verificação de empate.
          - **Variáveis Globais:**
            ```c
            char tabuleiro[TAM][TAM];
            char jogador1 = 'x';
            char jogador2 = 'o';
            ```
            `tabuleiro`: matriz que representa o tabuleiro do jogo. `jogador1` e `jogador2`: representam os dois jogadores.
          - **Função `main`:** Exibe uma mensagem de boas-vindas e chama a função `Iniciar` para configurar o jogo. Um loop infinito permite que os jogadores façam suas jogadas alternadamente até que um ganhador seja encontrado ou ocorra um empate.
          - **Função `Iniciar`:** Limpa o tabuleiro inicializando todas as posições com espaços vazios. Define aleatoriamente qual jogador começará a partida usando a função `rand()`.
          - **Função `MostrarTabuleiro`:** Imprime o estado atual do tabuleiro no console, mostrando as posições preenchidas por cada jogador.
          - **Função `FazerJogada`:** Solicita que o jogador atual informe a linha e a coluna para sua jogada, verificando se a posição escolhida é válida e marcando a posição no tabuleiro.
          - **Função `VerificarGanhador`:** Checa se algum jogador completou uma linha, coluna ou diagonal com suas marcações, retornando 1 se um jogador ganhou, caso contrário, retorna 0.
          - **Função `VerificarEmpate`:** Verifica se todas as posições do tabuleiro estão preenchidas e, se sim, retorna 1 (indicando empate), ou 0 se ainda há posições vazias.
        - **Considerações Finais:**
          - **Interação do Usuário:** O jogo interage diretamente com os jogadores por meio do console, solicitando entradas e fornecendo feedback sobre o estado do jogo.
          - **Aleatoriedade:** A escolha do jogador que começa o jogo é aleatória, tornando cada partida única.
          - **Validação de Entrada:** O programa valida as jogadas para garantir que os jogadores não possam fazer jogadas em posições já ocupadas.

  - **Provas** (Códigos das Provas)
