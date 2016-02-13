package br.com.ordenacao.modelo.metodos;


public abstract class Ordenacao {
	protected long movimentacao;
	protected long comparacao;
	protected long tempoGasto;
	protected long tempoInicial;
	protected long tempoFinal;
	
	protected void iniciaOrdenacao(){
		this.tempoInicial = System.currentTimeMillis();
		
	}
	
	protected void terminouOrdenacao(){
		this.tempoFinal = System.currentTimeMillis();
		this.tempoGasto = this.tempoFinal - this.tempoInicial; 
	}
	
	protected long getTempoGasto(){
		return this.tempoGasto;
	}
	
	protected Ordenacao() {
		this.movimentacao= 0;
		this.comparacao=0;
	}
	public Resultado getOrdenar(int[] vetor) {

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
