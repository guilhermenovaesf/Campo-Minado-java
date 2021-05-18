package br.com.poli.PuzzleN;

public class CalculaDificil implements CalculaScore {

	@Override
	public int pontos(Puzzle Partida) {
		if(Partida.getGridPuzzle().getQuantidadeMovimentos() == 0) {
			return 0;
		}
		else {
			return (int) 100000/Partida.getGridPuzzle().getQuantidadeMovimentos();
	    }
	}
}