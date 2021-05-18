package br.com.poli.PuzzleN;

import java.util.Calendar;

public class Puzzle {

	private CalculaScore score; //pontuação
	private boolean venceu; // avaliar fim de jogo
	private Jogador jogador;
	private Tabuleiro gridPuzzle;
	private Dificuldade dificuldade; //nivel selecionado da partida
	private Calendar tempo; //tempo de partida
	
	public Puzzle(Jogador jogador, Dificuldade dificuldade) {
		
		this.jogador=jogador;
		this.dificuldade=dificuldade;
	}

	public Calendar getTempo() {
		return tempo;
	}

	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}

	public void iniciaPartida() {

		this.venceu=false;
		this.tempo=Calendar.getInstance();
		this.gridPuzzle=new Tabuleiro(this.dificuldade);

	}

	public boolean isFimDeJogo() {

		return gridPuzzle.isTabuleiroOrdenado();
        
	}

	public CalculaScore getScore() {
		return score;
	}

	public void setScore(CalculaScore score) {
		this.score = score;
	}

	public boolean isVenceu() {
		return venceu;
	}


	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}


	public Tabuleiro getGridPuzzle() {
		return gridPuzzle;
	}


	public void setGridPuzzle(Tabuleiro gridPuzzle) {	
		this.gridPuzzle = gridPuzzle;
	}


	public Dificuldade getDificuldade() {
		return dificuldade;
	}


	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}


}