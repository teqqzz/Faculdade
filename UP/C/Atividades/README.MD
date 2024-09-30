# Atividades em C

Este repositório contém uma coleção de projetos desenvolvidos em C, abordando diversos conceitos de programação e algoritmos. Abaixo estão as descrições e funcionalidades de cada atividade.

## Atividade 1: Lançamento de Notas

### Descrição do Código
Este programa foi desenvolvido como parte da atividade 1 de algoritmos e tem como objetivo gerenciar o lançamento de notas de estudantes dos cursos de BSI (Bacharelado em Sistemas de Informação) e ADS (Análise e Desenvolvimento de Sistemas). O programa permite ao usuário inserir uma quantidade variável de notas, juntamente com a informação sobre o curso do estudante, e fornece estatísticas separadas para cada curso.

### Funcionalidades
- **Boas-vindas e instruções**: O programa inicia com uma mensagem de boas-vindas, orientando o usuário sobre como inserir as notas.
  
- **Inserção de notas**: 
  O usuário pode inserir as notas de estudantes de ambos os cursos (BSI e ADS) em qualquer ordem, especificando o curso correspondente a cada nota. O programa verifica se a nota inserida não é superior a 10.

- **Avaliação de resultados**:
  - Alunos com notas acima de 7.0 são considerados aprovados.
  - Alunos com notas entre 3.0 e 7.0 ficam de final, onde é solicitada uma nova nota para avaliação final.
  - Alunos com notas abaixo de 3.0 são reprovados.
  - O programa também contabiliza quantos alunos tiraram zero e quantos tiveram notas acima de 9.0.

- **Relatórios**: 
  Após todas as notas serem inseridas, o programa gera um relatório que inclui:
  - Média geral de notas para cada curso.
  - Número de alunos aprovados, reprovados e de final para cada curso.
  - Percentual total de alunos aprovados.
  - Curso que teve mais notas acima de 9.0.
  - Quantidade de alunos que tiraram zero.
  
- **Repetição do processo**: O programa pergunta ao usuário se ele deseja repetir o processo, permitindo que o usuário volte ao início ou encerre o programa.

## Atividade 2: Controle de Frota de Caminhões

### Descrição do Código
Este programa implementa um sistema de controle para gerenciar uma frota de caminhões. Ele permite ao usuário inserir dados sobre o consumo de combustível, quilometragem percorrida e o valor total transportado por cada caminhão em um determinado número de meses.

### Funcionalidades
- **Entrada de Dados**: O usuário é solicitado a inserir:
  - O número de caminhões na frota (com um limite máximo definido).
  - O número de meses para os quais deseja registrar os dados (com um limite máximo definido).
  
  Para cada caminhão e para cada mês, o programa coleta:
  - O consumo de combustível.
  - A quilometragem percorrida.
  - O valor total transportado.

- **Processamento dos Dados**: Após a coleta dos dados, o programa calcula:
  - O consumo médio de combustível para cada mês.
  - O caminhão que transportou o maior valor em cada mês.
  - A quilometragem total percorrida pela frota em cada mês.

- **Relatório**: 
  Ao final do processamento, o programa exibe um relatório que inclui:
  - O consumo médio de combustível para cada mês.
  - O caminhão que transportou o maior valor em cada mês.
  - A quilometragem total percorrida pela frota em cada mês.

- **Validação de Entrada**: O programa valida as entradas do usuário, garantindo que o número de caminhões e meses esteja dentro de limites especificados.

## Atividade 3: Jogo da Velha

### Descrição
Este projeto implementa o jogo da velha (também conhecido como "Tic-Tac-Toe") em C, permitindo que dois jogadores se revezem para jogar em um tabuleiro 3x3. O objetivo do jogo é conseguir alinhar três símbolos iguais (X ou O) em linha, coluna ou diagonal.

### Funcionalidades
- **Tabuleiro de Jogo**: O jogo é jogado em um tabuleiro de 3x3, que é inicialmente vazio.
  
- **Jogadores**: Os jogadores podem ser identificados como 'X' e 'O'. O jogo decide aleatoriamente qual jogador começa.

- **Jogadas**: Cada jogador insere a linha e a coluna onde deseja colocar seu símbolo. O programa valida a entrada para garantir que a jogada seja em uma posição válida e vazia.

- **Verificação de Vencedor**: O jogo verifica após cada jogada se um dos jogadores venceu ou se ocorreu um empate. O jogo termina quando há um vencedor ou quando todas as posições do tabuleiro estão preenchidas.
