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

public class AdicionaContato implements ILogica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		
		request.setAttribute("mensagem", "Contato (" + contato.getId() +") adicionado com sucesso!");
		
		return "mvc?logica=ListaContatosLogic";
	}

}
