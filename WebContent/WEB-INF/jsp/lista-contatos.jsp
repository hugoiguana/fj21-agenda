<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de contatos</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:import url="cabecalho.jsp" />

<!-- cria o DAO -->
<%-- <jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/> --%>

<c:if test="${not empty mensagem}">
	<h3>${mensagem}</h3>
</c:if>

<br/>

<table>
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereço</th>
		<th>Data nascimento</th>
		<th>Alterar</th>
		<th>Remover</th>
		</tr>
	
	<!-- percorre contatos montando as linhas da tabela -->
<%-- 	<c:forEach var="contato" items="${dao.contatos}" varStatus="id"> --%>
	<c:forEach var="contato" items="${contatos}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
			<td>${id.count}</td>
			<td>${contato.nome}</td>
			<td>
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>		
				<c:if test="${empty contato.email}">
					E-mail não informado
				</c:if>
			<%-- <c:if test="${contato.email == null}"> --%>
			<!-- E-mail não informado -->
			<%-- </c:if> --%>
			</td>
			<td>${contato.endereco}</td>
			<%-- <td>${contato.dataNascimento.time}</td> --%>
			<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
			<td><a href="mvc?logica=ShowAlteraContatoLogic&id=${contato.id}">Alterar</a></td>
			<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
		</tr>
	</c:forEach>
	</table>
	

<br/>
<a href="mvc?logica=ShowCadastroLogic">Novo contato</a>	

<c:import url="rodape.jsp" />

</body>
</html>