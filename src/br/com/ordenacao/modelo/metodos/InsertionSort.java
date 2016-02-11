package br.com.ordenacao.modelo.metodos;

public class InsertionSort extends Ordenacao {
	
	@Override
	public String getNameMetodo() {

		return "Insertion Sort";
	}
	
	@Override
	public int[] getOrdenar(int[] vetor) {
		this.comparacao = 0;
		this.movimentacao = 0;
		return insertionSort(vetor);
	}
	
	@Override
	public long getComparacao() {
		// TODO Auto-generated method stub
		return this.comparacao;
	}
	
	@Override
	public long getMovimentacao() {
		// TODO Auto-generated method stub
		return this.movimentacao;
	}
	
	public int[] insertionSort(int[] vetor) {  
		int i, j, eleito;
		 for (i = 1; i <= vetor.length-1; i++) {
	            eleito = vetor[i];
	            j = i - 1;
	            this.comparacao+=1;
	            while (j >= 0 && vetor[j] > eleito) {
	                vetor[j + 1] = vetor[j];
	                j = j - 1;
	                this.movimentacao+=1;
	                this.comparacao+=1;
	            }
	            vetor[j + 1] = eleito;
	        }
	
	        return vetor;
	    }
	
}
