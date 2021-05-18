package br.com.poli.PuzzleN;


public class PuzzleInsano extends Puzzle {

	
	public PuzzleInsano(Jogador jogador, Dificuldade dificuldade) {
		super(jogador, dificuldade);
		setScore(new CalculaInsano());
		
	}

	public void geraTabuleiro() {
		
	}
	
	public void resolveTabuleiro () throws TempoExcedido{
		
		
	}

}
