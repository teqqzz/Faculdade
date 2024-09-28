/*
	atividade 1 de algoritmos (1.0)
	
	imagine que a disciplina de algoritmos possui estudantes do curso de BSI e do curso de ADS
	o professor precisa lancar as notas de todos os estudantes, mas gerar estatisticas separadas para cada curso
	se o estudante tirar mais que 7.0 ele eh aprovado, se tirar menos que 3.0 ele eh reprovado, caso contrario fica de final
	implemente um programa em que o usuario possa inserir uma quantidade qualquer de notas
	o programa deve comecar exibindo uma mensagem de boas-vindas e explicando o que o usuario deve fazer
	ao inserir cada nota o usuario devera informar tambem o curso do estudante
	nao eh permitido inserir primeiro os de um curso e depois do outro, as notas devem poder ser inseridas em qualquer ordem
	apos todas as notas terem sido inseridas, o programa deve informar:
		- qual a media geral de cada curso
		- quantos estudantes de cada curso foram reprovados
		- quantos estudantes de cada curso ficaram de final
		- quantos estudantes de cada curso foram aprovados
		- qual o percentual total de alunos aprovados
		- qual curso teve mais notas acima de 9.0
		- quantos estudantes tiraram zero
	por fim o programa deve perguntar se o usuario quer repetir o processo, caso sim voltar ao inicio, caso nao deve se despedir e encerrar
*/
#include<stdio.h>

#include <stdlib.h>



int main(){



int continuar = 1;



//Repetição do programa

 while  (continuar){

  float nota;

  int aluno=0;

  int alunobsi=0;

  int alunoads=0;

  

  int curso=0;



  float mediageral=0;

  float mediageralads=0;



  int reprovado=0;

  int reprovadoads=0;



  int aprovado=0;

  int aprovadoads=0;



  int zero=0;

  int zeroads=0;



  int novebsi=0;

  int noveads=0;



  int final=0;

  int finalads=0;



  printf("Boas Vindas Ao Boletim Geral Do Curso BSI e ADS\n ");

  printf("Digite a quantidade de aluno: \n");

  scanf("%i",&aluno);



   //começo do laço de notas e relatorios

  for(int i=1;i<=aluno;i++){



   //menu

  printf("Selecione a Opcao:\n 1 - BSI \n 2 - ADS \n: ");

  scanf("%i",&curso);



//bsi 

  if(curso==1){

   alunobsi++;

    printf("\n");

    printf("Voce Selecionou o Curso BSI\n");

     printf("Digite a nota aluno BSI %i (nao pode ser maior que 10) \n",i);

     scanf("%f",&nota);



     //encerra o programa caso usuario inserir nota maior que 10

     if(nota>10){

      printf("Voce Inseriu um Valor maior que 10");

      return 0;

     }



     //contagem de aluno aprovado

   if(nota>=7){

      printf("Aluno Aprovado BSI %i \n",i);

      aprovado++;

      mediageral=(nota+mediageral)/alunobsi;

     }



     //teste final

      else if(nota>=3){

        printf("Aluno Reprovado, Aluno foi pra final\n");

         printf("Digite a nota da final\n");

          scanf("%f",&nota);

          final++;

       //contagem de alunos aprovados apos final bsi

       if(nota>=7){

        printf("Aluno Aprovado BSI %i \n",i);

        aprovado++;

        mediageral=(nota+mediageral)/alunobsi;

       }

         else {

         printf("Aluno Reprovado BSI %i \n",i);

         reprovado++;

         mediageral=(nota+mediageral)/alunobsi;

        }

     }

       //contagem reprovado

       else {

         printf("Aluno Reprovado BSI %i \n",i);

         reprovado++;

         mediageral=(nota+mediageral)/alunobsi;

        }

     //contagem de 0

      if(nota==0){

        zero++;

       }

     //contagem de nota apartir de 9

      if(nota>=9){

        novebsi++;

       }

   }



//ads 

  if(curso==2){

   alunoads++;

    printf("\n");

    printf("Voce Selecionou o Curso ADS\n");

     printf("Digite a nota aluno ADS %i (nao pode ser maior que 10)\n",i);

     scanf("%f",&nota);

     

     //encerra o programa caso usuario inserir nota maior que 10

     if(nota>10){

      printf("Voce Inseriu um Valor maior que 10");

      return 0;

     }

    

   //contagem de aluno aprovado ads

   if(nota>=7){

      printf("Aluno Aprovado ADS %i \n",i);

      aprovadoads++;

      mediageralads=(nota+mediageralads)/aluno;

     }

       //teste final

      else if(nota>=3){

        printf("Aluno Reprovado, Aluno foi pra final\n");

         printf("Digite a nota da final\n");

          scanf("%f",&nota);

          finalads++;

       //contagem de alunos aprovados apos final ads 

           if(nota>=7){

             printf("Aluno Aprovado ADS %i  \n",i);

             aprovadoads++;

             mediageralads=(nota+mediageralads)/aluno;

         }

         else {

         printf("Aluno Reprovado ADS %i \n",i);

         reprovadoads++;

         mediageralads=(nota+mediageral)/alunoads;

        }



       }



         //contagem de alunos Reprovados

       else {

         printf("Aluno Reprovado ADS %i \n",i);

         mediageralads=(nota+mediageralads)/aluno;

         reprovadoads++;

        }



       //contagem para notas nove em bsi

      if(nota==0){

        zeroads++;

       }



       //contagem para notas nove em ads

      if(nota>=9){

        noveads++;

       }

   }



  }//cabo o laço



   printf("\n");

//BSI caso tiver 0 aluno em ADS não Aparece o relatorio

  if(alunobsi>0){  

    printf("Media Geral BSI: %0.1f\n",mediageral);

    printf("Reprovados BSI: %i\n",reprovado);

    printf("Aprovados BSI: %i\n",aprovado);

    printf("Final BSI: %i\n",final);

    float bsi= (aprovado*100)/alunobsi;

    printf("Percentual de Alunos Aprovados BSI: %0.0f\n", bsi);    

}



else{

  printf("Nao a Alunos de BSI para Mostrar");

}





printf("\n");



//ADS caso tiver 0 aluno em ADS não Aparece o relatorio

  if(alunoads>0){  

    printf("Media Geral ADS: %0.1f\n",mediageralads);

    printf("Reprovados ADS: %i\n",reprovadoads);

    printf("Aprovados ADS: %i\n",aprovadoads);

    printf("Final ADS: %i\n",finalads);

    float ads= (aprovadoads*100)/alunoads;

    printf("Percentual de Alunos Aprovados ADS: %0.0f \n", ads);

} 



else{

  printf("Nao a Alunos de ADS para Mostrar");

}





//Verifica se existe alunoads ou alunobsi

if(alunoads || alunobsi > 0){

//Quem tirou mais 9

    if(novebsi>noveads){printf("BSI teve mais 9\n"); }

     else if(novebsi<noveads){printf("ADS Teve Mais 9\n"); }

      else if(novebsi==noveads){printf("BSI e ADS Tiveram a mesma quantidade de 9\n");}

       else{printf("BSI e ADS ninguem tirou 9\n");}

}



//Relatorio de 0

if(alunobsi>0){printf("Tiraram 0 BSI: %i\n",zero);}

if(alunoads>0){printf("Tiraram 0 ADS: %i\n",zeroads);}



printf("\n");



printf("\n");



//Parte para repetir o while caso usuario digite 0 quebra o loop

     printf("Deseja repetir o programa?\n -1 para continuar\n -0 para sair): ");

     scanf("%i", &continuar);

       if (curso == 0) {

         continuar = 0;

         break;

       }

}

return 0;

}