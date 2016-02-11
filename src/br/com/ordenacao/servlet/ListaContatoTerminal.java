package br.com.ordenacao.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/listacontato")
public class ListaContatoTerminal extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
		// Crie um ContatoDao:
				ContatoDao dao;
				try {
					dao = new ContatoDao();

					// Liste os contatos com o DAO:
					List<Contato> contatos = dao.getLista();

					// Itere nessa lista e imprima as informações dos contatos:
					for (Contato contato : contatos) {
						System.out.println("Nome: " + contato.getNome());
						System.out.println("Email: " + contato.getEmail());
						System.out.println("Endereço: " + contato.getEndereco());
						System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
