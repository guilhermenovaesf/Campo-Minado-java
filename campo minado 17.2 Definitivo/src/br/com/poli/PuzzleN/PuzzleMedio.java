package br.com.poli.PuzzleN;

import java.util.ArrayList;
import java.util.Arrays;

import application.Controladora;

public class PuzzleMedio extends Puzzle {

	private static long tempoinicio;

	public PuzzleMedio(Jogador jogador, Dificuldade dificuldade) {
		super(jogador, dificuldade);
		setScore(new CalculaMedio());
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
					System.out.println("++++++++++++resolução+++++++++++++");
					return revisar;
				}
				
				ArrayList<Nodo> filhos = new ArrayList<Nodo>();
				visitados.add(revisar);
				if ((!(revisar.getEstado()[0][0]==1 && revisar.getEstado()[0][1]==2 && revisar.getEstado()[0][2]==3 && revisar.getEstado()[0][3]==4) && !(revisar.getEstado()[1][0]==5 && revisar.getEstado()[1][1]==6 && revisar.getEstado()[1][2]==7 && revisar.getEstado()[1][3]==8) || pzero[0] != 1)) {
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
				if(pzero [0] != 3) {
					Nodo filho = new Nodo(clonar(revisar.getEstado()));
					int baixo =filho.getEstado() [pzero[0]+1][pzero[1]];
					filho.getEstado() [pzero[0]][pzero[1]] = baixo;
					filho.getEstado() [pzero[0]+1][pzero[1]]=0;
					if(!estaEmVisitados(visitados,filho)) {
					expandidos.add(filho);
					}
					filhos.add(filho);				
				}
				
				
				if ((!(revisar.getEstado()[0][0]==1 && revisar.getEstado()[1][0]==5 && revisar.getEstado()[2][0]==9 && revisar.getEstado()[3][0]==13) && !(revisar.getEstado()[0][1]==2 && revisar.getEstado()[1][1]==6 && revisar.getEstado()[2][1]==10 && revisar.getEstado()[3][1]==12)  || pzero[1] != 1)) {				
				
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
				if(pzero [1] != 3) {
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
	public static int[][] clonar(int[][] estado) {
		 int [][] clon = new int [estado.length][estado.length];
		 for (int i = 0; i < estado.length; i++) {
			 for (int j = 0; j < estado.length; j++) {
				clon[i][j] = estado [i][j];
			}
			
	}
		 return clon;
	 }
		
	public static int[] localizarPosicionZero(int[][] estado) {
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
	
	public static void resoluçãoMedio() {
		
		tempoinicio = System.currentTimeMillis();
		int [] [] inicio = {{Controladora.puzzle.getGridPuzzle().getGrids(0, 0).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(0, 1).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(0, 2).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(0, 3).getValor()},{Controladora.puzzle.getGridPuzzle().getGrids(1, 0).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(1, 1).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(1, 2).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(1, 3).getValor()},{Controladora.puzzle.getGridPuzzle().getGrids(2, 0).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(2, 1).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(2, 2).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(2, 3).getValor()},{Controladora.puzzle.getGridPuzzle().getGrids(3, 0).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(3, 1).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(3, 2).getValor(),Controladora.puzzle.getGridPuzzle().getGrids(3, 3).getValor()}};      
		int [] [] soluc = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
				
		Nodo inicial = new Nodo(inicio);
		Nodo sol = buscarSolucion(inicial, soluc);
		
		while (sol.pai != null) {
			
			imprimirEstado(sol.getEstado());
			System.out.println("+++++++++++movimentos++++++++++");
			sol = sol.pai;
					
		}
	}
		
	}

