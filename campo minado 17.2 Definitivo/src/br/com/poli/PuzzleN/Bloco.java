package br.com.poli.PuzzleN;

public class Bloco {

	public int valor;
	public boolean valido; // 


	public Bloco(int valor, boolean valido) {

		this.valor = valor;
		this.valido = valido;

	}

	public Bloco() {

	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public boolean isValido() {
		return valido;
	}


	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
}
