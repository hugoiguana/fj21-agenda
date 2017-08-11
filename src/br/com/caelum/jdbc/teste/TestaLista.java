package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Mensagem;

public class TestaLista {

	public static void main(String[] args) {

		ContatoDao contatoDao = new ContatoDao();

		List<Contato> contatos = contatoDao.getContatos();

		contatos.forEach(c -> Mensagem.showMensagemContato(c));
	}

}
