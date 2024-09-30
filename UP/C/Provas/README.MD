# Provas em C

Este repositório contém uma coleção de projetos desenvolvidos em C, abordando diversos conceitos de programação e algoritmos. Abaixo estão as descrições e funcionalidades de cada projeto.

## Prova 1: Máquina de Apostas

### Descrição do Código
Este programa foi desenvolvido como parte da atividade de algoritmos e tem como objetivo gerenciar uma máquina de apostas, onde o usuário pode fazer apostas de seis números entre 1 e 60. O programa fornece feedback sobre a validade da aposta e apresenta estatísticas sobre os números inseridos.

### Funcionalidades
- **Boas-vindas e Instruções**: O programa inicia com uma mensagem de boas-vindas, orientando o usuário sobre como inserir os números de sua aposta.
  
- **Inserção de Números**: O usuário pode inserir seis números inteiros de 1 a 60. O programa verifica se todos os números estão dentro desse intervalo.
  
- **Validação da Aposta**: Se todos os números estiverem dentro do intervalo permitido, o programa informa que a aposta foi efetuada. Caso contrário, uma mensagem de "aposta inválida" é exibida, e o programa informa quais números foram inseridos.

- **Avaliação de Números**: O programa calcula e exibe o menor e o maior número inserido. A média dos números apostados também é calculada e apresentada.

- **Condições de Mensagem**: 
  - Se mais da metade dos números inseridos forem pares, o programa imprime a mensagem "boa sorte!".
  - Se menos da metade dos números forem múltiplos de três, a mensagem "vai dar boa!" é exibida.

- **Repetição do Processo**: Após a aposta, o programa pergunta ao usuário se ele deseja fazer outra aposta. O usuário pode optar por repetir o processo ou encerrar o programa. Se uma entrada inválida for fornecida, o programa continua perguntando até que uma opção válida seja escolhida.

## Prova 2: Validação de Nome, Formatação de CPF, Extração de Números do Telefone e Manipulação de Matrizes

### Descrição do Código
Este programa foi desenvolvido para realizar a validação e formatação de dados pessoais, incluindo nome, CPF, telefone e uma matriz de inteiros. Ele é dividido em quatro funções principais, cada uma responsável por uma tarefa específica.

### Funcionalidades
#### 1. Validação de Nome
- O usuário é solicitado a inserir seu nome completo.
- O programa verifica se o nome contém pelo menos dois nomes e se a primeira letra de cada um está em maiúscula.
- Se as condições forem atendidas, a mensagem "Nome válido" é exibida; caso contrário, "Nome inválido" é mostrado.

#### 2. Formatação de CPF
- O usuário insere seu CPF.
- O programa verifica se o CPF tem exatamente 11 dígitos.
- Se válido, o CPF é impresso no formato `XXX.XXX.XXX-XX`; se inválido, uma mensagem de erro é exibida.

#### 3. Extração de Números do Telefone
- O usuário insere seu telefone no formato `+55 (XX) XXXXX-XXXX`.
- O programa remove qualquer formatação e imprime apenas os números do telefone.

#### 4. Manipulação de Matrizes
- O usuário insere o número de linhas e colunas (até 10) para criar uma matriz.
- O programa solicita a inserção dos valores para cada elemento da matriz.
- A matriz é exibida, e o programa calcula e imprime a soma dos dois menores números de cada linha.
- Em seguida, a matriz transposta é impressa.
