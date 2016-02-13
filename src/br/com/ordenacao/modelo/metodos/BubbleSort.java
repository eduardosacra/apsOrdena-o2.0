package br.com.ordenacao.modelo.metodos;


public class BubbleSort extends Sort {
	int aux = 0; int i = 0, comp =0, mov=0;
	int[]vet;

	@Override
	public Resultado sort(int[] vetor) {
		this.vet = vetor;
		int vlenth = this.vet.length;
		long tInicial = System.currentTimeMillis();
		for(i = 0; i<vlenth; i++){
			for(int j = 0; j<vlenth-1; j++){
				comp += 1;//contabiliza uma comparacao
				if(vet[j] > vet[j + 1]){
					mov+=1;//contabiliza uma movimentacao
					aux = vet[j];
					vet[j] = vet[j+1];
					vet[j+1] = aux; }
				} 
			}
		long tFinal = System.currentTimeMillis();
		long tGasto = tFinal - tInicial;//Tempo gasto para ordenar
		
		Resultado result = new Resultado();
		result.setMetodoOrdenacao("BubleSort");
		result.setQtdCompacao(this.comp);
		result.setQtdMovimentacao(this.mov);
		result.setTempoGasto(tGasto);
		result.setTamanhoVetor(vlenth);
		result.setVetorUsado("Falto logica pra isso");// TODO falta implementar carregar o nome do vetor.
		return result;
	}

	@Override
	public String nomeVetor() {
		return "Bubble Sort";
		
	}

}
