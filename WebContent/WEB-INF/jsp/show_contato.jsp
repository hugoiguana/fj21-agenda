<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contato</title>

<link href="css/jquery-ui.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>

</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>


<%-- <c:set var="actionAdiciona" value="AdicionaContato" /> --%>
<%-- <c:set var="actionEdita" value="EditaContato" /> --%>
<c:set var="tituloAddContato" value="Adiciona contato" />
<c:set var="tituloAlteraContato" value="Edita contato" />


<body>

	<c:import url="cabecalho.jsp" />

	<h1>${empty contato.id ? tituloAddContato : tituloAlteraContato}</h1>
	<hr />
	<form action="mvc">
	
		<input type="hidden" name="id" value="${contato.id}"/>
		<%--<input type="hidden" name="logica" value="${empty contato.id ? actionAdiciona : actionEdita}"/> --%>
		<input type="hidden" name="logica" value="${empty contato.id ? 'AdicionaContato' : 'EditaContato'}"/>
	
		<c:if test="${not empty contato.id}">
			Id: <span>${contato.id}</span>
			<br />
		</c:if>	
		Nome: <input type="text" name="nome" value="${contato.nome}"/>
		<br />
		E-mail: <input type="text" name="email" value="${contato.email}"/>
		<br />
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"/>
		<br />
		Data Nascimento:
		<caelum:campoData id="data_nascimento" value="${contato.dataNascimentoString}"/>
		
		<br />
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp" />

</body>

<script>

$( ".imputDisable" ).prop( "disabled", true );
$( ".imputEnable" ).prop( "disabled", false );

</script>

</html>