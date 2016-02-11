package br.com.ordenacao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testeajax")
public class TesteAjax extends HttpServlet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int cont =0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.cont += 1;
		System.out.println("cont: "+this.cont);
		response.getWriter().write("cont: "+this.cont);
		response.setStatus(200);
	}
		
	
}
