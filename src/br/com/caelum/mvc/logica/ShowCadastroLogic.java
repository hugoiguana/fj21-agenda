package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCadastroLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return "/WEB-INF/jsp/show_contato.jsp";
	}

}
