#ifndef JOGO_H_INCLUDED
#define JOGO_H_INCLUDED

void qtd_bombas();  /* função que marca as dicas nas casinhas */

void JogoFinal (int TAMBombas); /* imprime a matriz e tem toda a parte de jogabilidade */

void limpar_matriz();   /* função que faz com que os lugares que n estão com bomba por perto tenham 0 */

void gerar_bomba(int dif);      /* função que gera bomba, ela imprime uma bomba em cima da outra porem se
                                ela fizer isso ela adiciona +1 bomba, logo as bombas n serao "perdidas" */

void limpar_matriz_Novamente();  /* função que limpa totalmente a matriz para o usuario jogar novamente */

void perdeu ();  /* função que imprime aonde tem bomba e aonde a pessoa clicou e perdeu */

void verifica_Ganhador(int totalcasas, int TAMBombas);  /* verifica se a pessoa ganhou ou não */

void gotoxy(int g, int w); /* responsavel pelo cursor */

#endif // JOGO_H_INCLUDED
