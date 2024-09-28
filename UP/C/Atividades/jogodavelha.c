#include <stdio.h>

#include <stdlib.h>

#include <time.h>



#define TAM 3



// Declaração das funções

void Iniciar();

void MostrarTabuleiro();

void FazerJogada(char jogador);

int VerificarGanhador();

int VerificarEmpate();



// Variáveis globais

char tabuleiro[TAM][TAM];

char jogador1 = 'x';

char jogador2 = 'o';



int main() {

 // Mensagem de boas-vindas

 printf("Bem-vindo ao jogo da velha\n");



 // Inicialização

 Iniciar();



 // Loop principal do jogo

 while (1) {

  // Mostrar o tabuleiro

  MostrarTabuleiro();



  // Fazer a jogada do jogador atual

  FazerJogada(jogador1);



  // Verificar se o jogo terminou

  if (VerificarGanhador()) {

   // O jogo terminou

   MostrarTabuleiro();

   printf("O jogador %c venceu!\n", jogador1);

   break;

  } else if (VerificarEmpate()) {

   // Empate

   MostrarTabuleiro();

   printf("O jogo empatou!\n");

   break;

  }



  // Trocar de jogador

  char temp = jogador1;

  jogador1 = jogador2;

  jogador2 = temp;

 }



 return 0;

}



// Função para iniciar o jogo

void Iniciar() {

 // Limpar o tabuleiro

 for (int i = 0; i < TAM; i++) {

  for (int j = 0; j < TAM; j++) {

   tabuleiro[i][j] = ' ';

  }

 }



 // Escolher o jogador que começa

 srand(time(NULL));

 if (rand() % 2 == 0) {

  char temp = jogador1;

  jogador1 = jogador2;

  jogador2 = temp;

 }

}



// Função para mostrar o tabuleiro

void MostrarTabuleiro() {

 // Imprimir as linhas do tabuleiro

 for (int i = 0; i < TAM; i++) {

  for (int j = 0; j < TAM; j++) {

   printf(" | %c", tabuleiro[i][j]);

  }

  printf(" |\n");

 }

}



// Função para fazer uma jogada

void FazerJogada(char jogador) {
 int linha, coluna;
 while (1) {
  printf("Jogador %c, informe a linha da sua jogada (1 a 3): ", jogador);
  scanf("%d", &linha);
  printf("Jogador %c, informe a coluna da sua jogada (1 a 3): ", jogador);
  scanf("%d", &coluna);

  if (linha >= 1 && linha <= 3 && coluna >= 1 && coluna <= 3 && tabuleiro[linha - 1][coluna - 1] == ' ') {
   // Fazer a jogada
   tabuleiro[linha - 1][coluna - 1] = jogador;
   break;
  } else {
   printf("Posição inválida. Tente novamente.\n");
  }
 }
}

// Função para verificar se o jogo terminou
int VerificarGanhador() {
 // Verificar linhas e colunas
 for (int i = 0; i < TAM; i++) {
  if ((tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') ||
    (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ')) {
   return 1;
  }
 }

 // Verificar diagonais
 if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') ||
   (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ')) {
  return 1;
 }
 return 0;
}

// Função para verificar se houve empate
int VerificarEmpate() {
 for (int i = 0; i < TAM; i++) {
  for (int j = 0; j < TAM; j++) {
   if (tabuleiro[i][j] == ' ') {
    return 0; // Ainda há pelo menos uma posição vazia
   }
  }
 }
 return 1; // Todas as posições estão preenchidas (empate)
}