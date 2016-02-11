package br.com.ordenacao.modelo.metodos;

import javax.swing.JOptionPane;

import br.com.ordenacao.controler.ControleModelo;
import br.com.ordenacao.visao.Visao;

public class BubbleSort extends Ordenacao {
	

	@Override
	public int[] getOrdenar(int[] vetor) {
		this.comparacao = 0;
		this.movimentacao = 0;		
		
		return bubleSort(vetor);
	}
	
	private int[] bubleSort(int[]vetor) {
		 // coloca em ordem crescente (1,2,3,4,5...)  
		  for(int x = 0; x < vetor.length; x++ )
		  {	this.comparacao+=1;
		    for(int y = x + 1; y < vetor.length; y++ ) // sempre 1 elemento à frente
		    {
		    	this.comparacao+=1;
		      // se o (x > (x+1)) então o x passa pra frente (ordem crescente)
		      if ( vetor[x] > vetor[y] )
		      {
		        int aux = vetor[x];
		         vetor[x] = vetor[y];
		         vetor[y] = aux;
		         this.comparacao+=1;
		         this.movimentacao+=1;
		      }
		    }
		  } // fim da ordenação
		  
	     return vetor;
	}
	 
	@Override
	public String getNameMetodo() {

		return "BubbleSort";
	}

	@Override
	public long getComparacao() {
		// TODO Auto-generated method stub
		return this.comparacao;
	}
	
	@Override
	public long getMovimentacao() {
		return movimentacao;
	}
}
/*
 * for (int i = vetor.length; i >= 1; i--) {
			this.comparacao += 1;
			for (int j = 1; j < i; j++) {
				this.comparacao += 1;
				this.movimentacao+=1;
				if (vetor[j - 1] > vetor[j]) {
					int aux = vetor[j];
					vetor[j] = vetor[j - 1];
					vetor[j - 1] = aux;
				}
			}
			
		}
*/