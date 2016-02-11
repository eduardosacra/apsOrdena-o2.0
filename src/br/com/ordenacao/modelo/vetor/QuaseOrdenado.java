package br.com.ordenacao.modelo.vetor;

import java.util.Random;

public class QuaseOrdenado implements Vetor {

	@Override
	public int[] getVetor(int tamanho) {
		//Aqui Crio um vetor ordenado
		int[] vetor = new int[tamanho];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i;
		}
		
		//Aqui bagunço algumas posiçoes
		Random rd1 = new Random();
		int aux = 0;
		int indice2 = 0;
		//Aqui defino que isso ocorre apenas 5 vezes
		for (int i = 0; i < tamanho/5; i++) {
			int indice1 = rd1.nextInt(tamanho);
			do{
				indice2 = rd1.nextInt(tamanho); 
			}while(indice1 == indice2);
			
			aux =  vetor[indice1];
			vetor[indice1] = vetor[indice2];
			vetor[indice2] = aux;
			
			
		}
		
		return vetor;
	}

	@Override
	public String getNomeVetor() {
		// TODO Auto-generated method stub
		return "Vetor parcialmente ordenado";
	}

}
