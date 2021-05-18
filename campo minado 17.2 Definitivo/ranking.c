#include<stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include <string.h>
#include <windows.h>

#include "ranking.h"



int start;
int end;
int segundos;
int minuto =0;
int hora = 0;
int tempodecorrido;
extern TAMBombas;




void comecarTempo()

{

    int tempodecorrido = (time(0) - start);

    segundos = tempodecorrido - (60 * minuto);

    if(segundos > 59)
    {
        minuto++;
    }

    if(minuto > 60)
    {
        minuto=0;
        hora++;
    }

    if(hora > 24)

    {
        hora = 0;
    }

    printf(" Horas:%d", hora);
    printf(" Minutos:%d", minuto);
    printf(" Segundos:%d", segundos);

}

void  Inicioranking()

{
    char nome [12];
    int tempo;

    FILE *arquivo;

    arquivo = fopen("ranking.txt","a");

    if(arquivo == NULL)
    {
        printf("Erro na abertura do arquivo!");

    }

    printf("\nDIGITE SEU NOME:");

    setbuf(stdin, NULL);

    scanf("%s", nome);

    fprintf(arquivo, "%s %d:%d:%d\t", nome,hora, minuto,segundos);




    fclose(arquivo);
}



void AbrirRanking()
{
    system("cls");

    FILE *arquivo;

    char nome[100];

    arquivo = fopen("ranking.txt","r+");

    while(!feof(arquivo))
    {

        fgets(nome, 100, arquivo);

        printf("%s",nome);

    }
    gotoxy(2,15);
    printf("PRESSIONE QUALQUER TECLA PARA RETORNAR AO MENU.");

    fclose(arquivo);

    getch();

    fMenu1();


}
