package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class EditaContato implements ILogica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("data_nascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data
		if (dataEmTexto != null) {
			try {

				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);

			} catch (ParseException e) {
				out.println("Erro de conversão da data");
			}
		}

		Connection con = (Connection) request.getAttribute("conexao");
		ContatoDao contatoDao = new ContatoDao(con);
		Contato contato = contatoDao.getById(id);

		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		contatoDao.altera(contato);

		request.setAttribute("mensagem", "Contato (" + contato.getId() +") alterado com sucesso!");

		return "mvc?logica=ListaContatosLogic";
	}

}
