<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<table>
<tr>
<th>Nome</th>
<th>Email</th>
<th>Endereço</th>
<th>Data nascimento</th>
</tr>

<%
ContatoDao dao = new ContatoDao();
List<Contato> contatos = dao.getContatos();
for (Contato contato : contatos ) {
%>
<tr>
	<td><%=contato.getNome() %></td>
	<td><%=contato.getEmail() %></td>
	<td><%=contato.getEndereco() %></td>
	<td><%=contato.getDataNascimento().getTime() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>