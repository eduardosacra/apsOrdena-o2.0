package br.com.ordenacao.modelo.vetor;

import java.util.Random;

public class Aleatorio implements Vetor {

	
	private int[] gereVetorAleatorioNaoRepetido(int tamanho) {
		int[] vetor = new int[tamanho];
		Random rd = new Random();
		int valor=0;	
		for (int i = 0; i < vetor.length; i++) {
					
			
			vetor[i]=rd.nextInt(tamanho);
		}
		
		return vetor;
	}

	private boolean testaValorCasoExista(int[] vetor, int valor) {
		for (int i = 0; i < vetor.length; i++) {
			if(valor == vetor[i]){
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getVetor(int tamanho) {
		
		return gereVetorAleatorioNaoRepetido(tamanho);
	}

	@Override
	public String getNomeVetor() {
		// TODO Auto-generated method stub
		return "Aleatorio";
	}

}
