package br.com.poli.PuzzleN;

import java.util.ArrayList;
import java.util.Arrays;

import application.Controladora;



public class PuzzleDificil extends Puzzle {
	
	private static long tempoinicio;
	
	public PuzzleDificil(Jogador jogador, Dificuldade dificuldade) {
		super(jogador, dificuldade);
		setScore(new CalculaDificil());
		
	}
	
	public void geraTabuleiro(Dificuldade dificuldade) {

	}

		 public static  Nodo  buscarSolucion(Nodo inicio,int [] [] solucion) {
		 ArrayList<Nodo>expandidos = new ArrayList<Nodo>();
		 ArrayList<Nodo> visitados = new ArrayList<Nodo>();
		 expandidos.add(inicio);
		 int [] apagador = new int[2];
		 while (expandidos.size() != 0) {
				if(System.currentTimeMillis() - tempoinicio>10000) {
					try {
						throw new TempoExcedido();
					} catch (TempoExcedido e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			Nodo revisar= expandidos.remove(0);
		//	imprimirEstado(revisar.getEstado()); // imprimir possibilidades
			int [] pzero=localizarPosicionZero(revisar.getEstado());
			
			if(Arrays.deepEquals(revisar.getEstado(), solucion)) {
				System.out.println("+++++++++++++resolução+++++++++++++++");
				return revisar;
			}
			
			ArrayList<Nodo> filhos = new ArrayList<Nodo>();
			visitados.add(revisar);
			if ((!(revisar.getEstado()[0][0]==1 && revisar.getEstado()[0][1]==2 && revisar.getEstado()[0][2]==3 && revisar.getEstado()[0][3]==4 && revisar.getEstado()[0][4]==5) && !(revisar.getEstado()[1][0]==6 && revisar.getEstado()[1][1]==7 && revisar.getEstado()[1][2]==8 && revisar.getEstado()[1][3]==9 && revisar.getEstado()[1][4]==10) && !(revisar.getEstado()[2][0]==11 && revisar.getEstado()[2][1]==12 && revisar.getEstado()[2][2]==13 && revisar.getEstado()[2][3]==14 && revisar.getEstado()[2][4]==15) || pzero[0] != 1)) {
			if(pzero [0] != 0) {
				Nodo filho = new Nodo(clonar(revisar.getEstado()));
				int cima =filho.getEstado() [pzero[0]-1][pzero[1]];
				filho.getEstado() [pzero[0]][pzero[1]] = cima;
				filho.getEstado() [pzero[0]-1][pzero[1]]=0;
				if(!estaEmVisitados(visitados,filho)) {
				expandidos.add(filho);}
				filhos.add(filho);
			}
			} else if(apagador[0]>=0)
			{			
			}
			else {
				++apagador[0];
				expandidos.clear();
				visitados.clear();
			}
			if(pzero [0] != 4) {
				Nodo filho = new Nodo(clonar(revisar.getEstado()));
				int baixo =filho.getEstado() [pzero[0]+1][pzero[1]];
				filho.getEstado() [pzero[0]][pzero[1]] = baixo;
				filho.getEstado() [pzero[0]+1][pzero[1]]=0;
				if(!estaEmVisitados(visitados,filho)) {
				expandidos.add(filho);
				}
				filhos.add(filho);				
			}
			
			
			if ((!(revisar.getEstado()[0][0]==1 && revisar.getEstado()[1][0]==6 && revisar.getEstado()[2][0]==11 && revisar.getEstado()[3][0]==16 && revisar.getEstado()[4][0]==21) && !(revisar.getEstado()[0][1]==2 && revisar.getEstado()[1][1]==7 && revisar.getEstado()[2][1]==12 && revisar.getEstado()[3][1]==17 && revisar.getEstado()[4][1]==22) && !(revisar.getEstado()[0][2]==3 && revisar.getEstado()[1][2]==8 && revisar.getEstado()[2][2]==13 && revisar.getEstado()[3][2]==18 && revisar.getEstado()[4][2]==23) || pzero[1] != 1)) {				
			
			if(pzero [1] != 0) {
				Nodo filho = new Nodo(clonar(revisar.getEstado()));
				int esquerda =filho.getEstado() [pzero[0]][pzero[1]-1];
				filho.getEstado() [pzero[0]][pzero[1]] = esquerda;
				filho.getEstado() [pzero[0]][pzero[1]-1]=0;
				if(!estaEmVisitados(visitados,filho)) {
				expandidos.add(filho);
				}
				filhos.add(filho);				
			}
			
			} else if(apagador[1]>=1)
			{			
			}
			else {
				++apagador[1];
				expandidos.clear();
				visitados.clear();
			}
			if(pzero [1] != 4) {
				Nodo filho = new Nodo(clonar(revisar.getEstado()));
				int direita =filho.getEstado() [pzero[0]][pzero[1]+1];
				filho.getEstado() [pzero[0]][pzero[1]] = direita;
				filho.getEstado() [pzero[0]][pzero[1]+1]=0;
				if(!estaEmVisitados(visitados,filho))
				expandidos.add(filho);
				filhos.add(filho);
				
			}
			
			revisar.setFilhos(filhos);
		}
		return null;
		}
		 private static boolean estaEmVisitados(ArrayList<Nodo> visitados, Nodo hijo) {
			for (Nodo v : visitados) {
				if(Arrays.deepEquals(v.getEstado(),hijo.getEstado())) {
					return true;
				}
				
			}
			return false;
		}
		private static int[][] clonar(int[][] estado) {
			 int [][] clon = new int [estado.length][estado.length];
			 for (int i = 0; i < estado.length; i++) {
				 for (int j = 0; j < estado.length; j++) {
					clon[i][j] = estado [i][j];
				}
				
		}
			 return clon;
		 }
			
		private static int[] localizarPosicionZero(int[][] estado) {
			 int [] posicion = new int[2];// paraguardar a posiçao i e j
			 for (int i = 0; i < estado.length; i++) {
				 for (int j = 0; j < estado.length; j++) {
					if(estado[i][j] == 0){
						posicion[0]=i;
						posicion[1]=j;
					}
				}
				
			}
		return posicion;
		}
		public static void imprimirEstado(int estado [][]) {
			 for (int i = 0; i < estado.length; i++) {
				 for (int j = 0; j < estado.length; j++) {
					System.out.print("["+ estado[i][j]+"]");
				}
				System.out.println();
			}
			
		}
		
	public static void resoluçãoDificil() {
		
		tempoinicio = System.currentTimeMillis();
		
		int [] [] inicio = {{Controladora.puzzle.getGridPuzzle().getGrids()[0][0].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[0][1].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[0][2].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[0][3].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[0][4].getValor()},{Controladora.puzzle.getGridPuzzle().getGrids()[1][0].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[1][1].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[1][2].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[1][3].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[1][4].getValor()},{Controladora.puzzle.getGridPuzzle().getGrids()[2][0].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[2][1].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[2][2].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[2][3].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[2][4].getValor()},{Controladora.puzzle.getGridPuzzle().getGrids()[3][0].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[3][1].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[3][2].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[3][3].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[3][4].getValor()},{Controladora.puzzle.getGridPuzzle().getGrids()[4][0].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[4][1].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[4][2].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[4][3].getValor(),Controladora.puzzle.getGridPuzzle().getGrids()[4][4].getValor()}};     
		int [] [] soluc = {{1,3,5,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,0}};
		
		Nodo inicial = new Nodo(inicio);
		Nodo sol = buscarSolucion(inicial, soluc);
			
		while (sol.pai != null) {
			imprimirEstado(sol.getEstado());
			System.out.println("+++++++++++movimentos++++++++++");
			sol = sol.pai;
		}

    }

	}
