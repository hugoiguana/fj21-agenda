<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona Contatos</title>

<link href="css/jquery-ui.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>

</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<body>

	<c:import url="cabecalho.jsp" />

	<h1>Adiciona Contatos</h1>
	<hr />
	<form action="adicionaContato">
		Nome: <input type="text" name="nome" />
		<br />
		E-mail: <input type="text" name="email" />
		<br />
		Endereço: <input type="text" name="endereco" />
		<br />
		Data Nascimento:
		<!-- <input type="text" name="data_nascimento" /> -->
		<caelum:campoData id="data_nascimento" />
		<br />
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>