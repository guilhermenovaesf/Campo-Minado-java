package br.com.poli.PuzzleN;

@SuppressWarnings("serial")
public class TempoExcedido extends Exception{
	
	@Override
	public String toString() {
		return "N, alto demais! Muito processamento necessario para estas interações D:";
	}
	
}