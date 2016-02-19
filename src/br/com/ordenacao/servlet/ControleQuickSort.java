package br.com.ordenacao.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalField;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.JSONObject;

import br.com.ordenacao.modelo.metodos.QuickSort;
import br.com.ordenacao.modelo.metodos.Resultado;
import br.com.ordenacao.modelo.vetor.Vetor;

@WebServlet("/quicksort")
public class ControleQuickSort extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Metodo que trata o ajax para processar a ordenação
		// TODO gera ordenação buble sort
		System.out.println("Iniciando processo de ordenação Quick Sort");
		String vetor = "br.com.ordenacao.modelo.vetor." + request.getParameter("vetor");
		Class cls;
		try {
			cls = Class.forName(vetor);

			Object obj = cls.newInstance();
			Vetor vet = (Vetor) obj;

			int qtd = Integer.parseInt(request.getParameter("qtd"));

			QuickSort buble = new QuickSort();
			Resultado result = buble.sort(vet.getVetor(qtd));
			String resultadoOK = result.getMetodoOrdenacao() + ";" + result.getTamanhoVetor() + ";"
					+ formataHora(new Date(result.getTempoGasto()));
//			JSONObject j = new JSONObject();
//			j.put("tempo_gasto", result.getTempoGasto());
//			j.put("tempoformatado", formataHora(new Date(result.getTempoGasto())));
//			request.setAttribute("jsw", j);

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
