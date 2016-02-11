package br.com.ordenacao.modelo.vetor;

public class OrdenadoDecrescente implements Vetor {

	@Override
	public int[] getVetor(int tamanho) {
		
		int[] vetor = new int[tamanho];
		int j=0;
		for (int i = vetor.length; i > 0 ; i--) {
			vetor[j]=i;
			j++;
		}
		
		
		return vetor;
	}

	@Override
	public String getNomeVetor() {
		// TODO Auto-generated method stub
		return "ordenado Descrescente";
	}

}
