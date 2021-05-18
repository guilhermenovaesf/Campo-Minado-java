#include<stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include <windows.h>
#include <conio.h>

#include "menu.h"
#include "jogo.h"

#define DINX 15 // tamanho das linhas
#define DINY 15  // tamanho das colunas
#define BOMBA 64 // caracter da bomba
#define BANDEIRA 232 // carcter da bandeira
#define CARACAMPO -2 // caracter do campo

// DIFICULDADE:
#define FACIL 10
#define MEDIO 15
#define DIFICIL 20


int totalbandeiras=0; // limitadora da bandeira
int g=0,w=0;
int totalcasas = 225; // total de casas que no final vai decidir o ganhador

extern int end;
extern int start;
extern int TAMBombas;

char matriz_bomba [DINX][DINY][2];



void gerar_bomba(int dif)

{



    srand((int)time(NULL));

    int x, y,cont = dif; // (contador)cont = numero de bombas geradas

    for(; cont>0; cont--)

    {

        x = rand()%DINX;

        y = rand()%DINY;




        if (matriz_bomba[x][y][0] == BOMBA)
        {

            cont++;

        }
        else
        {

            matriz_bomba[x][y][0] = BOMBA;

        }

    }

}

void qtd_bombas()
{

    int x, y;

    for (x = 0; x < DINX; x++)
    {

        for (y = 0; y < DINY; y++)
        {

            if (matriz_bomba[x][y][0] == BOMBA)
            {

                if (x - 1 >= 0)
                {

                    if (y - 1 >= 0 && matriz_bomba[x - 1][y - 1][0] != BOMBA)
                    {

                        matriz_bomba[x - 1][y - 1][0]++;

                    }

                    if (y + 1 < DINY && matriz_bomba[x - 1][y + 1][0] != BOMBA)
                    {

                        matriz_bomba[x - 1][y + 1][0]++;

                    }

                    if (matriz_bomba[x - 1][y][0] != BOMBA)
                    {

                        matriz_bomba[x - 1][y][0]++;

                    }

                }

                if (x + 1 < DINX)
                {

                    if (y - 1 >= 0 && matriz_bomba[x + 1][y - 1][0] != BOMBA)
                    {

                        matriz_bomba[x + 1][y - 1][0]++;

                    }

                    if (y + 1 < DINY && matriz_bomba[x + 1][y + 1][0] != BOMBA)
                    {

                        matriz_bomba[x + 1][y + 1][0]++;

                    }

                    if (matriz_bomba[x + 1][y][0] != BOMBA)
                    {

                        matriz_bomba[x + 1][y][0]++;

                    }

                }

                if (y - 1 >= 0 && matriz_bomba[x][y - 1][0] != BOMBA)
                {

                    matriz_bomba[x][y - 1][0]++;

                }

                if (y + 1 < DINY && matriz_bomba[x][y + 1][0] != BOMBA)
                {

                    matriz_bomba[x][y + 1][0]++;

                }

            }

        }

    }

}




void limpar_matriz()
{

    int i, j;

    for (i = 0; i < DINX; i++)
    {

        for(j = 0; j < DINY; j++)
        {

            if (matriz_bomba[i][j][0] != BOMBA )
            {

                matriz_bomba[i][j][0] = '0';

            }

        }

    }

}


void limpar_matriz_Novamente()
{

    int i, j;

    for (i = 0; i < DINX; i++)
    {

        for(j = 0; j < DINY; j++)
        {

            matriz_bomba[i][j][0] = '0';
        }

    }

}

void gotoxy(int g, int w)
{

    COORD coord;

    coord.X = g;

    coord.Y = w;

    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);

}

void JogoFinal (int TAMBombas)
{


    int i, j;
    char tecla;


    start = time(0);



    for (i = 0; i < DINX; i++)
    {

        for(j = 0; j < DINY; j++)
        {
            matriz_bomba[i][j][1] = CARACAMPO;

        }

    }



    for (i = 0; i < DINX; i++)
    {



        for(j = 0; j < DINY; j++)
        {

            printf("%c", matriz_bomba[i][j][1]);

        }

        printf("\n");

    }




    gotoxy(0,0); // cursor para (0,0)

    while(matriz_bomba[g][w][1] != BOMBA)
    {

        if(g>14)
        {

            gotoxy(g=0,w);
        }
        else if(g<0)
        {
            gotoxy(g=14,w);
        }
        else if(w>14)
        {
            gotoxy(g,w=0);
        }
        else if(w<0)
        {
            gotoxy(g,w=14);
        }


        else
        {
            tecla = getch();
            tecla = toupper(tecla);
            if(tecla == 'W')
            {

                w--;
                gotoxy(g,w);


            }
            else if(tecla == 'S')
            {
                w++;
                gotoxy(g,w);

            }
            else if(tecla == 'A')
            {
                g--;
                gotoxy(g,w);

            }
            else if(tecla == 'D')
            {
                g++;
                gotoxy(g,w);

            }




            else if (tecla == 13)
            {
                if(matriz_bomba[g][w][1]!=CARACAMPO&&matriz_bomba[g][w][1]!='0'&&matriz_bomba[g][w][1]!='2'&& matriz_bomba[g][w][1]!='1'&& matriz_bomba[g][w][1]!='3'&& matriz_bomba[g][w][1]!='4'&& matriz_bomba[g][w][1]!='5'&& matriz_bomba[g][w][1]!='6'&& matriz_bomba[g][w][1]!='7'&& matriz_bomba[g][w][1]!='8')
                {
                    totalbandeiras--;
                }
                --totalcasas;
                matriz_bomba[g][w][1] = matriz_bomba[g][w][0];
                gotoxy(g,w);
                printf ("%c", matriz_bomba[g][w][1]);
                gotoxy(g,w);
                verifica_Ganhador(totalcasas,TAMBombas);
            }



            else if (tecla == 'P' && totalbandeiras < TAMBombas)
            {


                if(matriz_bomba[g][w][1]=='0'||matriz_bomba[g][w][1]=='1'||matriz_bomba[g][w][1]=='2'||matriz_bomba[g][w][1]=='3'||matriz_bomba[g][w][1]=='4'||matriz_bomba[g][w][1]=='5'||matriz_bomba[g][w][1]=='6'||matriz_bomba[g][w][1]=='7'||matriz_bomba[g][w][1]=='8')
                {
                    gotoxy(g,w);
                }

                else
                {
                    if(matriz_bomba[g][w][1] == CARACAMPO)
                    {
                        gotoxy(g,w);
                        matriz_bomba[g][w][1] = BANDEIRA;
                        totalbandeiras++;
                        printf ("%c", matriz_bomba[g][w][1]);
                        gotoxy(g,w);
                    }

                    else
                    {
                        totalbandeiras--;
                        gotoxy(g,w);
                        matriz_bomba[g][w][1] = CARACAMPO;
                        printf ("%c", matriz_bomba[g][w][1]);
                        gotoxy(g,w);
                    }

                }

            }


            else if (tecla == 'P' && totalbandeiras == TAMBombas)
            {


                if(matriz_bomba[g][w][1]=='0'||matriz_bomba[g][w][1]=='1'||matriz_bomba[g][w][1]=='2'||matriz_bomba[g][w][1]=='3'||matriz_bomba[g][w][1]=='4'||matriz_bomba[g][w][1]=='5'||matriz_bomba[g][w][1]=='6'||matriz_bomba[g][w][1]=='7'||matriz_bomba[g][w][1]=='8')
                {
                    gotoxy(g,w);
                }
                else if (matriz_bomba[g][w][1]== CARACAMPO)
                {
                    gotoxy(g,w);
                }

                else
                {

                    gotoxy(g,w);
                    matriz_bomba[g][w][1] = CARACAMPO;
                    totalbandeiras--;
                    printf ("%c", matriz_bomba[g][w][1]);
                    gotoxy(g,w);
                }



            }




            else
            {
                gotoxy(g,w);
            }

        }

        gotoxy(g,w);
    }



    perdeu();
    totalcasas=225;
    totalbandeiras=0;
    system("PAUSE");


}


void perdeu ()
{


    system("cls");
    system("color 4");

    for (w = 0; w < DINX; w++)
    {

        for(g = 0; g < DINY; g++)
        {
            if (matriz_bomba[g][w][0] == BOMBA )
            {
                printf("%c", matriz_bomba[g][w][0]);
            }
            else
            {
                printf("%c", matriz_bomba[g][w][1]);
            }
        }

        printf("\n");

    }




    printf("\n");
    printf("Voce perdeu! ");
    printf("\n");

}

void verifica_Ganhador(int totalcasas, int TAMBombas)
{



    if (totalcasas == FACIL && TAMBombas == FACIL)
    {


        end = time(0);
        comecarTempo();
        system("cls");
        printf("Voce Ganhou o jogo no modo facil, parabens! ");
        printf("\n");
        Inicioranking();
        totalcasas=225;
        totalbandeiras=0;
        system("PAUSE");
        fMenu1();
    }

    else if (totalcasas == MEDIO && TAMBombas == MEDIO)
    {

        end = time(0);
        system("cls");
        printf("Voce Ganhou o jogo no modo Medio, parabens! ");
        printf("\n");
        Inicioranking();
        totalcasas=225;
        totalbandeiras=0;
        system("PAUSE");
        fMenu1();


    }

    else if (totalcasas == DIFICIL && TAMBombas == DIFICIL)
    {

        end = time(0);
        system("cls");
        printf("Voce Ganhou o jogo no modo dificil, parabens! ");
        printf("\n");
        Inicioranking();
        totalcasas=225;
        totalbandeiras=0;
        system("PAUSE");
        fMenu1();
    }


}

