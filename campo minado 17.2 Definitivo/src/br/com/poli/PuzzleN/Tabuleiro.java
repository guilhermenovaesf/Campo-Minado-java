package br.com.poli.PuzzleN;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {	

	int k;
	Bloco [][] grids;
	int lin , col;//linha e coluna da matriz	
	String sentido;
	private Scanner num;
	private int quantidadeMovimentos;


	public Tabuleiro(Dificuldade dificuldade) {

		k = dificuldade.getNivel();
		k = (int) ((k+1)/Math.sqrt(k+1));
		grids = new Bloco [k][k]; //grid tamanho
	}
	
	public int getQuantidadeMovimentos() {
		return quantidadeMovimentos;
	}


	public void setQuantidadeMovimentos(int quantidadeMovimentos) {
		this.quantidadeMovimentos = quantidadeMovimentos;
	}
				
			
		public int getLin() {
		return lin;
	}

		public void setLin(int lin) {
		this.lin = lin;
	}

		public int getCol() {
			return col;
	}

		public void setCol(int col) {
		this.col = col;
	}

		public String getSentido() {
		return sentido;
	}

		public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public int getK(){
		return k;
	}
	
	public void setK(int k) {
		this.k = k;
	}

	//pegar valores da matriz
	public Bloco[][] getGrids() {
		return grids;
	}

	//valores setados para matriz
	public void setGrids(Bloco[][] grids) {
		this.grids = grids;
	}
	//metodo auxiliar para imprimir a matriz
	public int matriz(int lin, int col){

		return grids[lin][col].valor;

	}
	//metodo auxiliar para imprimir a matriz
	public int tamanhoMatriz() {

		return this.grids.length;

	}
	
	public Bloco getGrids(int x ,int y) {
	return grids[x][y];
	}

	public void executaMovimento(int lin, int col) {
		
		try {
		isMovimentoValido(lin, col);
		
		//movimento para cima (teste)
		if(lin > 0 && this.grids[lin-1][col].getValor() == 0) {

			this.grids[lin-1][col].setValor(this.grids[lin][col].getValor());
			this.grids[lin-1][col].setValido(false);
			this.grids[lin][col].setValor(0);
			this.grids[lin][col].setValido(true);
			this.quantidadeMovimentos++;
		}			 

		//movimento para baixo (teste)
		if( lin < k-1 && this.grids[lin+1][col].getValor() == 0) {

			this.grids[lin+1][col].setValor(this.grids[lin][col].getValor());
			this.grids[lin+1][col].setValido(false);
			this.grids[lin][col].setValor(0); 
			this.grids[lin][col].setValido(true);
			this.quantidadeMovimentos++;
		}			 

		//movimento para esquerda (teste)
		if(col > 0 && this.grids[lin][col-1].getValor() == 0) {

			this.grids[lin][col-1].setValor(this.grids[lin][col].getValor());
			this.grids[lin][col-1].setValido(false);
			this.grids[lin][col].setValor(0);
			this.grids[lin][col].setValido(true);
			this.quantidadeMovimentos++;
		}

		//movimento para direita (teste)
		if( col < k-1 && this.grids[lin][col+1].getValor() == 0) {

			this.grids[lin][col+1].setValor(this.grids[lin][col].getValor());
			this.grids[lin][col+1].setValido(false);
			this.grids[lin][col].setValor(0);
			this.grids[lin][col].setValido(true);
			this.quantidadeMovimentos++;
		}
		}
		catch(MovimentoInvalido erro) {
		
		}
		
	}
	
	// metodo para saber quando uma matriz está na ordem correta
	
	public boolean isTabuleiroOrdenado() {									

		int casa = 1;

		for(int lin = 0; lin < grids.length; lin++) {

			for(int col = 0; col < grids.length; col++) {

				if( grids [lin][col].getValor() == casa) {
					casa++;
					
					if(casa==(grids.length)*(grids.length)) {
						casa=0;
					}
					
				}
			}
		}
		if(casa==1) {
			return true;
	}else {
			return false;
		}
	}		
		public boolean isMovimentoValido(int lin, int col) throws MovimentoInvalido {
				
				if( lin > 0 && this.grids[lin-1][col].isValido() == true) {
				}			 

				else if( lin < k-1 && this.grids[lin+1][col].isValido() == true) {
				}			 

				else if(col > 0 && this.grids[lin][col-1].isValido() == true) {
				}

				else if( col < k-1 && this.grids[lin][col+1].isValido() == true) {
				}
				else {throw new MovimentoInvalido();}
				return true;
				
		}

			public void modoficarTabuleiro() {
		        
		        String sentido;
		        Random random = new Random();
		        
		        for (int movimentos = 0; movimentos < 50; movimentos++) {
		            
		            String[] direção = {"cima", "baixo", "esquerda", "direita"};
		            sentido = direção[(random.nextInt(direção.length))];
		            
		            int lin = k-1;
		        	int col = k-1;
		        	
		            for (int i = 0; i < k ; i++) {
		                for (int j = 0; j < k ; j++) {
		                    if (getGrids()[i][j].getValor()==0) {
		                    	lin=i;
		                    	col=j;
		                    	break;
		                    }
		                }
		            }
		            // Sentido
		            switch (sentido) {
		                case "cima"://cima
		                    if (lin < (k-1)) {
		                        lin = lin+1;
		                    }
		                    break;
		                case "baixo":
		                    if (lin > 0 ) {
		                        lin = lin-1;
		                    }
		                    break;
		                case "esquerda":
		                    if (col < (k-1) ) {
		                        col = col+1;
		                    }
		                    break;
		                case "direita":
		                    if (col > 0) {
		                        col = col-1;
		                    }
		                    break;
		            }       
		            executaMovimento(lin, col);
		            
			}
		        setQuantidadeMovimentos(0);
		        }
			
		public void geraTabuleiro(Dificuldade dificuldade) {
	         
			
			if(dificuldade == Dificuldade.Facil) {
	           this.setK(Dificuldade.Facil.getNivel() + 1);
	        }
	        else if(dificuldade == Dificuldade.Medio) {
	                this.setK(Dificuldade.Medio.getNivel() + 1);
	        }        
	        else if(dificuldade == Dificuldade.Dificil) {
	                this.setK(Dificuldade.Dificil.getNivel() + 1);
	        }
	        else if(dificuldade == Dificuldade.Insano) {
	        	do {
                    System.out.println("\tModo Insano!!!!");
                    System.out.println("\tEscolha um valor de 6 a 25:\n");
                    num = new Scanner(System.in);
                    this.setK((int)Math.pow(num.nextInt(), 2));
                } while (this.getK() <= 35 || this.getK() > 675);

	        }
			
			int[] valor = new int[this.getK()];
	        for (int i = 0; i < this.getK(); i++) {
	            valor[i] = i + 1;
	        }
	        valor[this.getK()-1] = 0;
	        this.setK((int) Math.sqrt(k+1));
	        setGrids(new Bloco[k][k]);
	        int contador = 0;
	        for (int lin = 0; lin < k ; lin++) {
	            for (int col = 0; col < k ; col++) {
	                this.getGrids()[lin][col] = new Bloco(valor[contador], false);
	                if (this.getGrids()[lin][col].getValor() == 0) {
	                    this.getGrids()[lin][col].setValido(true);
	                }
	                contador++;
	            }
	        }
	        modoficarTabuleiro();
			
			
	    }
}
