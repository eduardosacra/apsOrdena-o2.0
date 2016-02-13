package br.com.ordenacao.modelo.metodos;

public class InsertionSort extends Sort {
	long comparacao, movimentacao;

	public Resultado insertionSort(int[] vetor) {
		int i, j, eleito, qtdElemento;
		qtdElemento = vetor.length;
		long tInicial = System.currentTimeMillis();
		for (i = 1; i <= vetor.length - 1; i++) {
			eleito = vetor[i];
			j = i - 1;
			this.comparacao += 1;
			while (j >= 0 && vetor[j] > eleito) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
				this.movimentacao += 1;
				this.comparacao += 1;
			}
			vetor[j + 1] = eleito;
		}
		long tFinal = System.currentTimeMillis();
		long tGasto = tFinal - tInicial;// Tempo gasto para ordenar

		Resultado result = new Resultado();
		result.setTempoGasto(tGasto);
		result.setTamanhoVetor(qtdElemento);
		result.setQtdCompacao(this.comparacao);
		result.setQtdMovimentacao(this.movimentacao);
		result.setMetodoOrdenacao(this.nomeVetor());
		return result;
	}

	@Override
	public Resultado sort(int[] vetor) {

		this.comparacao = 0;
		this.movimentacao = 0;
		return insertionSort(vetor);
	}

	@Override
	public String nomeVetor() {

		return "Insertion Sort";
	}

}
