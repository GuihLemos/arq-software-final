<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="css\recurso.css" />
<title>Cadastra Agenda</title>
</head>

<jsp:useBean id="agenda" class="modelo.dominio.Agenda" 
		scope="request"></jsp:useBean>
<%
List<String> erros = (List<String>)request.getAttribute("erros");

List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
if (lista == null)
	lista = new ArrayList<Cliente>();
%>
<body>
	<header>Agendar Cliente</header>
<section>
	<div style="color: red">
	<ul>
<%  if (erros != null)
		for (String mensagem: erros) { %>
		<li><%=mensagem%></li>
	<% } %>
	</ul>
	</div>
	<form action="salvarAgenda" method="post">
		<input type="hidden" name="codigo" value="<%=agenda.getCodigoStr() %>">
		<table border="0" cellpadding="4" cellspacing="15">
			<tr>
				<td>Código:</td>
				<td><%=agenda.getCodigoStr() %></td>
			</tr>
			<tr>
				<td>Cliente:</td>
				<td><select name="idCliente">
						<option value="">Selecione...</option>
				<% for (Cliente forn:lista) { %>
					<option value="<%=forn.getCodigo()%>"><%=forn.getNome()%></option>
				<% } %>
				</select>
				</td>
			</tr>
			
			<tr>
				<td>Data:</td>
				<td><input type="text" name="data" value="<%=agenda.getDataStr() %>" size="40" maxlength="10"></td>
			</tr>
			<tr>
				<td>horario:</td>
				<td><input type="text" name="horario" value="<%=agenda.getHorarioStr() %>" size="20" maxlength="10"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar Agenda">
					<input type="button" value="Cancelar" onclick="window.location='listarAgendas'"></td>
			</tr>
		</table>
		</section>
		
	</form>
</body>
</html>