package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ShowAlteraContatoLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		Connection con = (Connection) request.getAttribute("conexao");
		ContatoDao contatoDao = new ContatoDao(con);
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Contato contato = contatoDao.getById(id.longValue());
		
		request.setAttribute("contato", contato);
		
		return "show_contato.jsp";
	}

}
