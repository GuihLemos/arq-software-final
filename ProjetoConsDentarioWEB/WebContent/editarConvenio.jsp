<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="css\recurso.css" />
<title>Cadastra Convenio</title>

<script>
$(function() {
    $( "#calendario" ).datepicker();
});
</script>
</head>

<jsp:useBean id="Convenio" class="modelo.dominio.Convenio" 
		scope="request"></jsp:useBean>
<%
List<String> erros = (List<String>)request.getAttribute("erros");

List<Cliente> lista = (List<Cliente>) request.getAttribute("listaCliente");
if (lista == null)
	lista = new ArrayList<Cliente>();
%>
<body>
	<header>Cadastro de Convenio</header>
<section>
	<div style="color: red">
	<ul>
<%  if (erros != null)
		for (String mensagem: erros) { %>
		<li><%=mensagem%></li>
	<% } %>
	</ul>
	</div>
	<form action="salvarConvenio" method="post">
		<input type="hidden" name="codigo" value="<%=Convenio.getCodigoStr() %>">
		<table border="0" cellpadding="4" cellspacing="15">
			<tr>
				<td>Código:</td>
				<td><%=Convenio.getCodigoStr() %></td>
			</tr>
			
			
			<tr>
				<td>Nome do Convenio:</td>
				<td><input type="text" name="nome_convenio" value="<%=Convenio.getNome_convenioStr()%>" size="30" maxlength="20"></td>
			</tr>
			<tr>
				<td>Data da Adesão:</td>
				<td><input type="Date" name="data_adesao" value="<%=Convenio.getData_adesaoStr()%>" size="20" maxlength="10"
				id="calendario" ></td>
			</tr>
			
			<tr>
				<td>Inadimplente:</td>
				<td><select name="inadimplente">
						<option value="">Selecione...</option>
						<option value="SIM">Sim</option>
						<option value="NÃO">Não</option>
						
						
					</option>
				
				</select>
				</td>
			</tr>
				
				
			
			
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar Convenio">
					<input type="button" value="Cancelar" onclick="window.location='listarConvenios'"></td>
			</tr>
		</table>
		</section>
		
	</form>
</body>
</html>