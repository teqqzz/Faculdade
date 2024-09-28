#include <stdio.h>

#include <stdlib.h>

#include <time.h>

#include <windows.h>



/*/////////////////////////////////////////////////////////////////////////////////////////////////////////////



PROVA 1



individual e sem consulta

respostas com cola ou plagio serão anuladas

fazer tudo neste arquivo e subir novamente no blackboard

valor total 4.0



MAQUINA DE APOSTAS



(1.0)



implemente um programa em que o usuario possa fazer apostas de seis numeros de 1 a 60

o programa deve imprimir uma mensagem de apresentacao e depois ler os numeros

se qualquer um dos numeros estiver fora do intervalo, o programa deve imprimir "aposta invalida"

caso contrario, o programa deve imprimir "aposta efetuada"



(1.0)



caso a aposta tenha sido efetuada, o programa deve tambem imprimir:

qual foi o menor numero inserido

qual foi o maior numero inserido

qual eh a media dos numeros inseridos



(1.0)



ainda caso a aposta tenha sido efetuada,

se mais da metade dos numeros forem pares, o programa deve imprimir a mensagem "boa sorte!"

se menos da metade dos numeros forem multiplos de tres, o programa deve imprimir a mensagem "vai dar boa!"



(1.0)



em seguida o programa deve perguntar se o usuario deseja fazer outra aposta

caso o usuario digite 1, voltar ao inicio

caso digite 2, encerrar programa

caso contrario, continuar perguntando se ele deseja fazer outra aposta



//////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

int main(){
   int n=0;
   int n2=0;
   int n3=0;
   int n4=0;
   int n5=0;
   int n6=0;
   printf("Bem vindo ao Programa de Aposta de 6 numeros:\n");
while(1){
    printf("digite um Numero:\n");
   scanf("%i",&n);
    printf("digite outro Numero:\n");
   scanf("%i",&n2);
    printf("digite outro Numero:\n");
   scanf("%i",&n3);
     printf("digite outro Numero:\n");
   scanf("%i",&n4);
     printf("digite outro Numero:\n");
   scanf("%i",&n5);
       printf("digite outro Numero:\n");
   scanf("%i",&n6);
//verificaçao entre 1 a 60
   if(n >0 && n<60 && n2 >0 && n2<60 && n3 >0 && n3<60 && n4 >0 && n4<60 && n5 >0 && n5<60 && n6 >0 && n6<60){
     printf("Aposta Efetuada \n");
     printf("Seus numero e : %i %i %i %i %i %i\n",n,n2,n3,n4,n5,n6);

//numero menor
     if(n<n2&&n<n3&&n<n4&&n<n5&&n<n6){printf("O numero menor e %i\n",n);}

       else if(n2<n&&n2<n3&&n2<n4&&n2<n5&&n2<n6){printf("O numero menor e %i\n",n2);}

         else if(n3<n2&&n3<n&&n3<n4&&n3<n5&&n3<n6){printf("O numero menor e %i\n",n3);}

           else if(n4<n2&&n4<n3&&n4<n&&n4<n5&&n4<n6){printf("O numero menor e %i\n",n4);}

                 else if(n5<n2&&n5<n3&&n5<n4&&n5<n&&n5<n6){printf("O numero menor e %i\n",n5);}

                   else if(n6<n2&&n6<n3&&n6<n4&&n6<n5&&n6<n){printf("O numero menor e %i\n",n6);}

//numero maior
     if(n>n2&&n>n3&&n>n4&&n>n5&&n>n6){printf("O numero maior e %i\n",n);}

       else if(n2>n&&n2>n3&&n2>n4&&n2>n5&&n2>n6){printf("O numero maior e %i\n",n2);}

         else if(n3>n2&&n3>n&&n3>n4&&n3>n5&&n3>n6){printf("O numero maior e %i\n",n3);}

           else if(n4>n2&&n4>n3&&n4>n&&n4>n5&&n4>n6){printf("O numero maior e %i\n",n4);}

             else if(n5>n2&&n5>n3&&n5>n4&&n5>n&&n5>n6){printf("O numero maior e %i\n",n5);}

               else if(n6>n2&&n6>n3&&n6>n4&&n6>n5&&n6>n){printf("O numero maior e %i\n",n6);}

//media

   int media = (n+n2+n3+n4+n5+n6)/6;
     printf("A media e: %i \n",media);

//par
     if(n2%2==0 && n%2==0 && n3%2==0 && n4% 2 == 0){printf("Boa Sorte\n");}
       else if(n%2==0 && n2%2==0 && n3%2==0 && n5%2==0){printf("Boa Sorte\n");}
         else if(n2%2==0 && n%2==0 && n3%2==0 && n6%2==0){printf("Boa Sorte\n");}
     else{printf("Passou Longe\n");}

//multiplo
     if(n2%3==0 && n%3==0 && n3%3==0 && n4%3==0){printf("Vai dar Boa\n");}
       else if(n%3==0 && n2%3==0 && n3%3==0 && n5%3==0){printf("Vai dar Boa\n");}
         else if(n2%3==0 && n%3==0 && n3%3==0 && n6%3==0){printf("Vai dar Boa\n");}
     else{printf("Passou Longe\n");}
  }
   else{
     printf("Seus numeros e : %i %i %i %i %i %i\n",n,n2,n3,n4,n5,n6);
     printf("Erro voce digitou um numero maior ou menor que 1 \n");
     printf("Aposta Invalida\n");
  }

//continuacao do programa
   int l;
   printf("Deseja Refazer a Aposta:\n 0 - Para nao \n 1 - Para sim \n ");
   scanf("%i",&l);
   if(l==0){
     break;
  }
   else if(l>1 || l<0){
     printf("Opcao Invalida");
     break;
  }
}
   return 0;
}