package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("data_nascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		if(dataEmTexto != null){
			try {

				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);

			} catch (ParseException e) {
				out.println("Erro de conversão da data");
				return; // para a execução do método
			}
	
		}
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// (procure o ContatoDao no código existente)
		// busca a conexão pendurada na requisição
		Connection connection = (Connection) request.getAttribute("conexao");		
		
		// salva o contato
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);

		RequestDispatcher rd = request.getRequestDispatcher("/contato_adicionado.jsp");
		rd.forward(request, response);
		
		// imprime o nome do contato que foi adicionado
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
//		out.println("</body>");
//		out.println("</html>");
	}
}
