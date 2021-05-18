package br.com.poli.PuzzleN;

public enum Dificuldade {

	Facil(8),Medio(15),Dificil(24),Insano(0);
	private int valor;

	private Dificuldade(int valor) {
		this.valor = valor;
	}
	// pegar nivel selecionado
	public int getNivel() {
		return this.valor;
	}
}