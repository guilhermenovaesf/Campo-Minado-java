#ifndef JOGO_H_INCLUDED
#define JOGO_H_INCLUDED

void qtd_bombas();  /* fun��o que marca as dicas nas casinhas */

void JogoFinal (int TAMBombas); /* imprime a matriz e tem toda a parte de jogabilidade */

void limpar_matriz();   /* fun��o que faz com que os lugares que n est�o com bomba por perto tenham 0 */

void gerar_bomba(int dif);      /* fun��o que gera bomba, ela imprime uma bomba em cima da outra porem se
                                ela fizer isso ela adiciona +1 bomba, logo as bombas n serao "perdidas" */

void limpar_matriz_Novamente();  /* fun��o que limpa totalmente a matriz para o usuario jogar novamente */

void perdeu ();  /* fun��o que imprime aonde tem bomba e aonde a pessoa clicou e perdeu */

void verifica_Ganhador(int totalcasas, int TAMBombas);  /* verifica se a pessoa ganhou ou n�o */

void gotoxy(int g, int w); /* responsavel pelo cursor */

#endif // JOGO_H_INCLUDED
