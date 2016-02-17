package br.com.ordenacao.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ordenacao.modelo.metodos.BubbleSort;
import br.com.ordenacao.modelo.metodos.Resultado;
import br.com.ordenacao.modelo.vetor.Vetor;

@WebServlet("/bublesort")
public class ControleBubleSort extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO gera ordenação buble sort

		String vetor = "br.com.ordenacao.modelo.vetor." + request.getParameter("vetor");
		Class cls;
		try {
			cls = Class.forName(vetor);

			Object obj = cls.newInstance();
			Vetor vet = (Vetor) obj;

			int qtd = Integer.parseInt(request.getParameter("qtd"));

			BubbleSort buble = new BubbleSort();
		Resultado result=	buble.sort(vet.getVetor(qtd));
		String resultadoOK=result.getMetodoOrdenacao()+";"+result.getTamanhoVetor()+";"+formataHora(new Date(result.getTempoGasto()));
		System.out.println(resultadoOK);
		response.getWriter().write(resultadoOK);
		response.setStatus(200);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static String formataHora(Date data) {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("mm:ss,SSS"); // HH:mm:ss
		return dataFormatada.format(data);
	}
}
