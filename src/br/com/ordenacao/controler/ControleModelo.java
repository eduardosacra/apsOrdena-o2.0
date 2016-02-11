package br.com.ordenacao.controler;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.ordenacao.modelo.metodos.BubbleSort;
import br.com.ordenacao.modelo.metodos.Ordenacao;
import br.com.ordenacao.modelo.metodos.QuickSort;
import br.com.ordenacao.modelo.metodos.InsertionSort;
import br.com.ordenacao.modelo.metodos.SelectionSort;
import br.com.ordenacao.modelo.vetor.Aleatorio;
import br.com.ordenacao.modelo.vetor.OrdenadoCrescente;
import br.com.ordenacao.modelo.vetor.OrdenadoDecrescente;
import br.com.ordenacao.modelo.vetor.Vetor;

public class ControleModelo {

	int tamanho, metodoUtilizado;
	public ArrayList<Vetor> vetores;
	public ArrayList<Ordenacao> metodos;
	public long tempos[];
	public ControlerVisao controleVisao;
	public int indiceDoMetodoUtilizado;

	public ControleModelo(ControlerVisao controleVisao) {
		// TODO Auto-generated constructor stub
		this.controleVisao = controleVisao;

		//Aqui é gerenciado os vetores
		vetores = new ArrayList<Vetor>();
		vetores.add(new Aleatorio());
		vetores.add(new OrdenadoCrescente());
		vetores.add(new OrdenadoDecrescente());
		
		//Aqui é gerenciado os metodos
		metodos = new ArrayList();
		metodos.add(new BubbleSort());
		metodos.add(new QuickSort());
		metodos.add(new InsertionSort());
		metodos.add(new SelectionSort());
		
		

	}

	//este metodo retorna um vetor com o nome dos metodos.
	public String[] getMetodos() {
		// retorna o nome dos metodos
		String[] nome = new String[this.metodos.size()];

		int i = 0;

		for (Ordenacao ordenacao : this.metodos) {
			nome[i] = ordenacao.getNameMetodo();
			i++;
		}

		return nome;
	}

	//Retorna um vetor com o nome dos vetores.
	public String[] getNomeVetores() {
		// retorna o nome dos vetores

		String[] nome = new String[this.vetores.size()];

		int aux = 0;
		for (Vetor vetor : this.vetores) {
			nome[aux] = vetor.getNomeVetor();
			aux += 1;
		}

		return nome;

	}

	//Aqui é feita a chamada para iniciar o processo de ordenacao
	public void getOrdenacao(int tamanho, int qualVetor) {
		
		
		int[] vetor = vetores.get(qualVetor).getVetor(tamanho);	
		
		
		for (int i = 0; i < metodos.size(); i++) {
			this.indiceDoMetodoUtilizado = i;//aqui popula o indice para saber qual das linhas sera alterado
			
			
			int[] vetorClone = vetor.clone();
			

			this.controleVisao.situacaoAtualiza("Processando",i);
			this.controleVisao.alertaUsario(
					"Processando: \n Metodo: "+metodos.get(i).getNameMetodo()+"\n"+
			"Vetor: "+vetores.get(qualVetor).getNomeVetor()
			);
			//Aqui capitura a hora atual do SO em formato long
			long tempoInicial = Calendar.getInstance().getTimeInMillis();
			metodos.get(i).getOrdenar(vetorClone);//realiza o processo de ordenacao
			long tempoFinal = Calendar.getInstance().getTimeInMillis();
			//aqui faz a diferenca dos valores para ser calculado o perido de processamento
			long diferenca =  tempoFinal - tempoInicial;
					
			this.controleVisao.atualizaDetalhesOrdenacao(diferenca,metodos.get(i).getComparacao(),metodos.get(i).getMovimentacao(), i);
			this.controleVisao.situacaoAtualiza("Pronto",i);
			this.controleVisao.alertaUsario("Metodo "+metodos.get(i).getNameMetodo()+" pronto.");
		}
	}

	//aqui retorna um vetor com as quantidades utilizada para definir o tamanho do vetor.
	public int[] getQtdDeVetores() {
		
		return Vetor.qtdVetores;
	}

	//aqui é feita a chamada para aletar o usuario que foi feita uma atualição necessaria de aviso
	public void alertaUsuario(String texto) {
		this.controleVisao.alertaUsario(texto);
	}
}
