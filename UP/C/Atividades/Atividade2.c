/*

[Valor 0.1]



Implementar um programa de controle de uma frota de caminhões

Na função main, o programa de pedir ao usuário o tam da frota e o número de meses

A main deve chamar uma função que leia os seguintes valores para cada caminhão em cada mês:



(1) consumo de combustível

(2) quilometragem percorrida

(3) valor total transportado



Ao final o programa deve imprimir um relatório contendo:



(1) consumo médio de combustível em cada mês

(2) caminhão que transportou o maior valor naquele mês

(3) quilometragem total percorrida pela frota naquele mês

*/



#define MAX_CAMINHOES 20
#define MAX_MESES 24
#include <stdio.h>
#include <stdlib.h> 

void processaFrota(int num_caminhoes, int num_meses){
   float consumosMensais[MAX_MESES];
   float valorm[MAX_MESES];
   float kmtotal[MAX_MESES];
   int caminhaomvalor[MAX_MESES];

   for(int i = 0; i < num_meses; i++){
     float soma_consumos = 0.0;
     float max_valor = 0.0;
     float km_total = 0.0;
     int caminhao_max_valor = -1;
     for(int j = 0; j < num_caminhoes; j++){
       float consumo, percurso, valor;
       printf("\nInsira o consumo do caminhao %i no mes %i: ", j+1, i+1);
       scanf("%f", &consumo);
       soma_consumos += consumo;
       printf("\nInsira a quantidade de km percorridos pelo caminhao %i no mes %i: ", j+1, i+1);
       scanf("%f", &percurso);
       km_total += percurso;
       printf("\nInsira o valor total transportado pelo caminhao %i no mes %i: ", j+1, i+1);
       scanf("%f", &valor);
       if (valor > max_valor) {
         max_valor = valor;
         caminhao_max_valor = j+1;
       }
       system("cls");
     }
     consumosMensais[i] = soma_consumos / num_caminhoes;
     valorm[i] = max_valor;
     kmtotal[i] = km_total;
     caminhaomvalor[i] = caminhao_max_valor;
   }

   // Imprime o relatório
   printf("\nRelatorio:\n");
   for (int i = 0; i < num_meses; i++) {
     printf("Mes %d:\n", i + 1);
     printf("Consumo medio de combustível: %.2f\n", consumosMensais[i]);
     printf("Caminhao que transportou o maior valor: Caminhao %d\n", caminhaomvalor[i]);
     printf("Total percorrida pela frota: %.2fKM\n\n", kmtotal[i]);
   }
}

int pega_valor_valido(int valor_max)
{
   int num_desejado = 0;
   while(1)
   {
     scanf("%i", &num_desejado);
     if(num_desejado >=1  && num_desejado <= valor_max)
     {
       break;
     }
     else
     {
       printf("O numero deve estar entre 1 e %i\n", valor_max);
     }
   }
   return num_desejado;
}

int main(){
   printf("Bem vindo ao sistema de controle de caminhoes!\n");
   printf("Insira o tamanho da frota (max. %i)\n", MAX_CAMINHOES);
   int num_caminhoes = pega_valor_valido(MAX_CAMINHOES);
   printf("Insira o numero de meses (max. %i)\n", MAX_MESES);
   int num_meses = pega_valor_valido(MAX_MESES);
   system("cls");
   processaFrota(num_caminhoes, num_meses);
   return 0;
}