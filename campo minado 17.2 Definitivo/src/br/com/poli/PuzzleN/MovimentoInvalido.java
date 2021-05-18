package br.com.poli.PuzzleN;

@SuppressWarnings("serial")
public class MovimentoInvalido extends Exception {

	public MovimentoInvalido() {
		super();
	}
	
	@Override
	public String toString() {
		return "Movimento Invalido";
	}

}
