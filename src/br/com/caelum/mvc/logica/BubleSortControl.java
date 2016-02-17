package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ordenacao.modelo.vetor.Vetor;

public class BubleSortControl implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// // TODO Auto-generated method stub
		String paramVetor = request.getParameter("vetor");
		String classeNome = "br.com.ordenacao.modelo.vetor"+paramVetor;
		
		Class classe = Class.forName(classeNome);
		Vetor vetor = (Vetor) classe.newInstance();
		
		int qtdElementos =Integer.parseInt(request.getParameter("qtd"));
		//TODO continuar apartir da qui.
		return null;
	}

	

}
