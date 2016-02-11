package br.com.ordenacao.modelo.metodos;

public class SelectionSort extends Ordenacao {

	@Override
	public String getNameMetodo() {

		return "Selection Sort";
	}
	
	@Override
	public int[] getOrdenar(int[] vetor) {
		
		this.comparacao = 0;
		this.movimentacao = 0;
		return selectionSort(vetor);
	}
	@Override
	public long getComparacao() {
		
		return this.comparacao;
	}

	@Override
	public long getMovimentacao() {
		
		return this.movimentacao;
	}
	private int[] selectionSort(int[] vetor) {
		
		
	        int  j, eleito, menor, pos;
	        
	 
	        for (int i = 0; i <= vetor.length-2; i++) {
	        	this.comparacao +=1;
	        	eleito = vetor[i];
	            menor = vetor[i + 1];
	            pos = i + 1;
	            for (j = i + 2; j <= vetor.length-1; j++) {
	            	this.comparacao +=1;
	                if (vetor[j] < menor) {
	                    menor = vetor[j];
	                    pos = j;
	                    
	                    
	                }else{
	                	this.movimentacao +=1;
	                }
	            }
	            this.comparacao +=1;
	            if (menor < eleito) {
	                vetor[i] = vetor[pos];
	                vetor[pos] = eleito;	                
	                this.movimentacao +=1;
                }
	        }
	 
	       
	    
		return vetor;
	}
}
