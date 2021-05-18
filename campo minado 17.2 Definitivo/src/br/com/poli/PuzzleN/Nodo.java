package br.com.poli.PuzzleN;

import java.util.ArrayList;

public class Nodo {
	int[][] estado;
	ArrayList<Nodo> filhos = new ArrayList<Nodo>();
	Nodo pai;

	public Nodo(int [][] estado) {
		super();
		this.estado = estado;
		filhos = null;
		pai = null;
	}

	public int[][] getEstado() {
		return estado;
	}

	public void setEstado(int[][] estado) {
		this.estado = estado;
	}

	public ArrayList<Nodo> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Nodo> filhos) {
		this.filhos = filhos;
		if(filhos!=null) {
			for (Nodo h : filhos) {
				h.pai = this;
			}
		}
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

}