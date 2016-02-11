package br.com.ordenacao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/oi")
public class OiMundo extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("teste");
		PrintWriter out = response.getWriter();
	
		
		
		
		out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Primeira Servlet</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Hello word!</h1>");
	    out.println("<h4>Um clássico</h4>");
	    out.println("</body>");
	    out.println("</html>");
	}
}
