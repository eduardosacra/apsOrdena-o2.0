package br.com.ordenacao.modelo.metodos;

public class Resultado {
	private long tempoGasto;
	private long qtdMovimentacao;
	private long qtdCompacao;
	private String vetorUsado;
	private String metodoOrdenacao;
	private int tamanhoVetor;
	
	public long getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(long tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	public long getQtdMovimentacao() {
		return qtdMovimentacao;
	}
	public void setQtdMovimentacao(long qtdMovimentacao) {
		this.qtdMovimentacao = qtdMovimentacao;
	}
	public long getQtdCompacao() {
		return qtdCompacao;
	}
	public void setQtdCompacao(long qtdCompacao) {
		this.qtdCompacao = qtdCompacao;
	}
	public String getVetorUsado() {
		return vetorUsado;
	}
	public void setVetorUsado(String vetorUsado) {
		this.vetorUsado = vetorUsado;
	}
	public String getMetodoOrdenacao() {
		return metodoOrdenacao;
	}
	public void setMetodoOrdenacao(String metodoOrdenacao) {
		this.metodoOrdenacao = metodoOrdenacao;
	}
	public int getTamanhoVetor() {
		return tamanhoVetor;
	}
	public void setTamanhoVetor(int tamanhoVetor) {
		this.tamanhoVetor = tamanhoVetor;
	}
}
