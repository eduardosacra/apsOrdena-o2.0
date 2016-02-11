package br.com.ordenacao.modelo.metodos;

public class QuickSort extends Ordenacao {
	public static int[] array;
	

	public QuickSort() {
		
	}

	@Override
	public int[] getOrdenar(int[] v) {
		this.comparacao = 0;
		this.movimentacao = 0;
		quickSort(v, 0, v.length - 1);

		return array;

	}

	@Override
	public String getNameMetodo() {

		return "Quick Sort";
	}

	@Override
	public long getMovimentacao() {
		// TODO Auto-generated method stub
		return this.movimentacao;
	}

	@Override
	public long getComparacao() {
		return this.comparacao;
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
				this.movimentacao +=1;
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
				
			}
		}
		if (dir > esquerda){
			this.comparacao+=1;
			quickSort(v, esquerda, dir);
		}
		if (esq < direita){
			this.comparacao+=1;
			quickSort(v, esq, direita);
		}
	}

}
