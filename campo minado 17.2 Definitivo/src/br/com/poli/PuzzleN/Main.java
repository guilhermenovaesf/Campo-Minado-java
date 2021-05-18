package br.com.poli.PuzzleN;

import java.util.Scanner;

public class Main { 
	
	private static Scanner col;
	private static Scanner lin;


	public static void imprimirMatriz(Tabuleiro gridPuzzle) {

		for(int lin=0;lin < gridPuzzle.tamanhoMatriz();lin++) {
			System.out.println();
			for(int col =0;col < gridPuzzle.tamanhoMatriz();col++) {
				System.out.print("[" + gridPuzzle.matriz(lin,col)+"]"+"\t");
			}
			System.out.println();
		}
	}
	
	public static void Insano() {
		
		Tabuleiro tabuleiro = new Tabuleiro(Dificuldade.Insano);
		Jogador jogador =  new Jogador ("");
		Puzzle teste = new Puzzle(jogador, Dificuldade.Insano);
		
		jogador.getNome();
		teste.iniciaPartida();
		teste.getGridPuzzle().geraTabuleiro(teste.getDificuldade());
		imprimirMatriz(teste.getGridPuzzle());
		
		System.out.println();
		
		do {
		System.out.println("Selecione uma linha:\n");
		lin = new Scanner(System.in);
		tabuleiro.setLin((int)(lin.nextInt()));
		System.out.println("===============================================================================================================================================");
		System.out.println("Selecione uma coluna:\n");
		col = new Scanner(System.in);	
		tabuleiro.setCol((int)(col.nextInt()));
		System.out.println("===============================================================================================================================================\n");
		teste.getGridPuzzle().executaMovimento(tabuleiro.getLin(), tabuleiro.getCol());
		imprimirMatriz(teste.getGridPuzzle());
		System.out.println();
		
		}while( teste.isFimDeJogo() == false);
	}

	public static void main(String [] args) {
	
	}		
}