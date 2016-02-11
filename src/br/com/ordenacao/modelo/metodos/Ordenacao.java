package br.com.ordenacao.modelo.metodos;


public abstract class Ordenacao {
	protected long movimentacao;
	protected long comparacao;
	
	protected Ordenacao() {
		this.movimentacao= 0;
		this.comparacao=0;
	}
	public int[] getOrdenar(int[] vetor) {

		return null;

	}

	public String getNameMetodo() {
		return null;
	}
	
	public long getMovimentacao(){
		return 0;
	}
	
	public long getComparacao(){
		return 0;
	}
}
