package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<Contato> contatos = new ContatoDao().getContatos();

		req.setAttribute("contatos", contatos);

		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
