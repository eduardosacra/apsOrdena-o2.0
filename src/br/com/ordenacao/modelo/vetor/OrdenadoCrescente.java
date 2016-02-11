package br.com.ordenacao.modelo.vetor;

import java.util.ArrayList;

public class OrdenadoCrescente implements Vetor {

	@Override
	public  int[] getVetor(int tamanho) {
		int[] vetor = new int[tamanho];
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i]=i;
		}
		
		return vetor;
	}

	@Override
	public String getNomeVetor() {
		
		return "Ordenado Crescente";
	}

}
