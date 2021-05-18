#include<stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include <string.h>
#include <windows.h>

#include "ranking.h"
#include "menu.h"


#define DINX 15 // tamanho das linhas
#define DINY 15  // tamanho das colunas
#define BOMBA 64 // caracter da bomba

// DIFICULDADE:
#define FACIL 10
#define MEDIO 15
#define DIFICIL 20


//Variavel global

int TAMBombas;





void fMenu1()
{
    system("mode con:cols=150 lines=40");
    system("color 7");
    system("cls");
    fflush(stdin);



    char escolha;

    int x= BOMBA;
    printf("%c%c%c%c%c%c%c         %c         %c           %c   %c%c%c%c%c%c%c%c   %c%c%c%c%c%c%c%c%c             %c           %c   %c%c    %c      %c        %c        %c%c%c%c%c%c      %c%c%c%c%c%c%c%c%c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c              %c %c        %c%c         %c%c   %c      %c   %c       %c             %c%c         %c%c   %c%c    %c%c     %c       %c %c       %c     %c     %c       %c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c             %c   %c       %c %c       %c %c   %c      %c   %c       %c             %c %c       %c %c   %c%c    %c %c    %c      %c   %c      %c      %c    %c       %c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c            %c     %c      %c  %c     %c  %c   %c%c%c%c%c%c%c%c   %c       %c             %c  %c     %c  %c   %c%c    %c  %c   %c     %c     %c     %c       %c   %c       %c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c           %c%c%c%c%c%c%c%c%c     %c   %c   %c   %c   %c          %c       %c             %c   %c   %c   %c   %c%c    %c   %c  %c    %c%c%c%c%c%c%c%c%c    %c       %c   %c       %c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c          %c         %c    %c    %c %c    %c   %c          %c       %c             %c    %c %c    %c   %c%c    %c    %c %c   %c         %c   %c      %c    %c       %c\n",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);
    printf("%c%c%c%c%c%c%c   %c           %c   %c     %c     %c   %c          %c%c%c%c%c%c%c%c%c             %c     %c     %c   %c%c    %c     %c%c  %c           %c  %c%c%c%c%c%c%c     %c%c%c%c%c%c%c%c%c",x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x);

    printf("\n\n                                                              MENU INICIAL:\n                                                      ESCOLHA UMA DAS ALTERNATIVAS:\n                                                   ");
    printf("           (C)Comecar\n                                                              (S)Sair\n ");
    printf("                                                             (I)Instrucoes\n                                                              (R)Ranking\n");

    escolha = getch();
    escolha=toupper(escolha);


    switch(escolha)
    {

    case 'C':
        fConfigurar();

        break;

    case 'I':
        finstrucoes();

        break;

    case 'R':
        AbrirRanking();
        break;

    case'S':
        exit(1);

        break;

    default:

        fMenu1();

        break;

        return;

    }

}



void finstrucoes()
{


    system("cls");


    char decisao;



    printf("\n");

    printf("Objetivo:Encontrar os quadrados vazios e evitar as minas. Quanto mais rapido voce esvaziar o tabuleiro, melhor sera a sua pontuacao.\n");

    printf("O Tabuleiro:O Campo Minado possui tres opcoees de tabuleiros, cada um deles progressivamente mais dificil que o outro.\n");

    printf("Facil: 225 quadrados e 10 minas\nMedio: 225 quadrados e 15 minas\nDificil: 225 quadrados e 20 minas\n");

    printf("Como jogar:\nAs regras do Campo Minado sao simples:\n1-Se voce descobrir uma mina, o jogo acaba.\n2-Se descobrir um quadrado vazio, o jogo continua.\n3-Se aparecer um numero, ele informara quantas minas estao escondidas nos oito quadrados que o cercam. Voce usa essa informacao para deduzir em que quadrados proximos   eh seguro clicar.\n");

    printf("Dicas:\n1-Marque as minas. Se voce suspeita que um quadrado contem uma mina,clicar 'P'. Isso marca o quadrado com uma bandeira.\n2-Estude os padroes: Se tres quadrados seguidos exibirem os números 2,3 e 2, provavelmente havera tres minas alinhadas ao lado desses numeros.\n3:Explore o desconhecido: Nao sabe onde clicar em seguida? Tente esvaziar algum territorio inexplorado. Eh melhor clicar no meio dos quadrados que nao estao marcados do que em uma area que voce suspeita estar minada.\n\n");

    printf("\n");



    printf("Pressione qualquer tecla para retornar ao menu: ");

    getch();

    fMenu1();
}



void fConfigurar()
{


    int quantBombas;

    char DificuldadeJogo;

    system("cls");

    printf("Digite a dificuldade do jogo \n \n");

    fflush(stdin);

    printf("(F) Facil  (M) Medio (D) Dificil):  \n");

    printf("\n");
    do
    {
        DificuldadeJogo = getch();
        DificuldadeJogo=toupper(DificuldadeJogo);

    }
    while(DificuldadeJogo != 'F' && DificuldadeJogo != 'M' && DificuldadeJogo != 'D');


    switch (DificuldadeJogo)
    {

    case 'F':

        system("cls");
        TAMBombas = FACIL;
        fMenu2();
        break;
    case 'M':

        system("cls");
        TAMBombas = MEDIO;
        fMenu2();
        break;
    case 'D' :

        system("cls");
        TAMBombas = DIFICIL;
        fMenu2();
        break;

    default :
        printf("\n\n ERRO: escolha as opcoes de acordo com o menu...\n");

        system("PAUSE");

        fConfigurar();

    }

}



void fMenu2()
{

    fflush(stdin);

    char escolha;

    printf("Selecione a opcao \n\n");

    printf(" (C) Configurar\n (J) Jogar\n (S) Sair\n");

    do
    {

        escolha = getch();
        escolha=toupper(escolha);

    }
    while(escolha != 'C' && escolha != 'J' && escolha != 'S');

    switch (escolha)
    {

    case 'C':

        fConfigurar();

        break;

    case 'J':

        fJogar(TAMBombas);

        break;

    case'S':

        exit(1);

        break;

    default:
        printf("Opcao invalida!!!\nC - Configurar e S - Sair\n");

        system("PAUSE");

        fMenu1();

    }



}

void fJogar(int NumeroBomba)
{


    system("cls");

    fflush(stdin);

    if (TAMBombas == FACIL)
    {



        gerar_bomba(FACIL);

        limpar_matriz();

        qtd_bombas();

        JogoFinal(TAMBombas);

        JogarNovamente();

    }

    else if (TAMBombas == MEDIO)
    {



        gerar_bomba(MEDIO);

        limpar_matriz();

        qtd_bombas();

        JogoFinal(TAMBombas);

        JogarNovamente();
    }

    else
    {

        gerar_bomba(DIFICIL);

        limpar_matriz();

        qtd_bombas();

        JogoFinal(TAMBombas);

        JogarNovamente();
    }

}

void JogarNovamente()
{

    char decisaojogarnovamente;

    system("mode con:cols=150 lines=40");
    printf("Voce deseja jogar novamente? (S - SAIR J - JOGAR NOVAMENTE)");

    do
    {
        decisaojogarnovamente = getch();
        decisaojogarnovamente = toupper(decisaojogarnovamente);
    }
    while(decisaojogarnovamente != 'S' && decisaojogarnovamente != 'J');


    switch (decisaojogarnovamente)
    {

    case 'J' :

        limpar_matriz_Novamente();
        fMenu1();
        break;

    case 'S':
        exit(1);
        break;

    default :
        printf("opção invalida");

    }

}


