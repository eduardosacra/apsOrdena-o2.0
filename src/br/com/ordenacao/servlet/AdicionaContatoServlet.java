package br.com.ordenacao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int contChamada=0;

	protected void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException {
		this.contChamada +=1;
        // busca o writer
        PrintWriter out = response.getWriter();
                        
        // buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request
                .getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        // fazendo a conversão da data
        try {
            Date date = 
                    new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (Exception e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }
        
        // monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        // salva o contato
        ContatoDao dao;
		try {
			dao = new ContatoDao();
			dao.adiciona(contato);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
        // imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() +
                " adicionado com sucesso");
        out.println("</body>");
        out.println("</html>");
        
        //TODO AdicionaContatoServlet line.86 Mudar a forma que é mostrado o teste de que foi salvo no banco
		try {
			dao = new ContatoDao();
			// Liste os contatos com o DAO:
			List<Contato> contatos = dao.getLista();

			// Itere nessa lista e imprima as informações dos contatos:
			for (Contato ct : contatos) {
				System.out.println("Nome: " + ct.getNome());
				System.out.println("Email: " + ct.getEmail());
				System.out.println("Endereço: " + ct.getEndereco());
				System.out.println("Data de Nascimento: " + ct.getDataNascimento().getTime() + "\n");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}