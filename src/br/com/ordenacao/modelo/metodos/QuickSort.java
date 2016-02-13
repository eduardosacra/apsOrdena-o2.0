package br.com.ordenacao.modelo.metodos;

public class QuickSort extends Sort {
	public static int[] array;
	long comparacao, movimentacao;

	public QuickSort() {

	}

	public void quickSort(int v[], int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		int pivo = v[(esq + dir) / 2];
		int troca;

		while (esq <= dir) {
			this.comparacao += 1;

			while (v[esq] < pivo) {
				this.comparacao += 1;
				esq = esq + 1;
			}

			while (v[dir] > pivo) {
				dir = dir - 1;
				this.comparacao += 1;
			}

			if (esq <= dir) {
				this.comparacao += 1;
				this.movimentacao += 1;
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;

			}
		}
		if (dir > esquerda) {
			this.comparacao += 1;
			quickSort(v, esquerda, dir);
		}
		if (esq < direita) {
			this.comparacao += 1;
			quickSort(v, esq, direita);
		}
	}

	@Override
	public Resultado sort(int[] vetor) {
		int qtdElemento = vetor.length;
		this.comparacao = 0;
		this.movimentacao = 0;
		long tInicial = System.currentTimeMillis();
		quickSort(vetor, 0, vetor.length - 1);
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
	public String nomeVetor() {
		return "Quick Sort";
	}

}
