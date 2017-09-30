<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Convenio"%>
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
<title>Cadastro de Clientes</title>

<script>
$(function() {
    $( "#calendario" ).datepicker();
});
</script>
<script type="text/javascript">

function mascara(telefone){ 
	   if(telefone.value.length == 0)
	     telefone.value = '(' + telefone.value; //quando começamos a digitar, o script irá inserir um parênteses no começo do campo.
	   if(telefone.value.length == 3)
	      telefone.value = telefone.value + ') '; //quando o campo já tiver 3 caracteres (um parênteses e 2 números) o script irá inserir mais um parênteses, fechando assim o código de área.
	 
	 if(telefone.value.length == 9)
	     telefone.value = telefone.value + '-'; //quando o campo já tiver 8 caracteres, o script irá inserir um tracinho, para melhor visualização do telefone.
	  
	}

</script>



</head>



</head>

<jsp:useBean id="cliente" class="modelo.dominio.Cliente" 
		scope="request"></jsp:useBean>
<%
List<String> erros = (List<String>)request.getAttribute("erros");

List<Convenio> lista = (List<Convenio>) request.getAttribute("lista");
if (lista == null)
	lista = new ArrayList<Convenio>();
%>


<body>
	<header>Cadastro de Cliente</header>
<section>

<div style="color: red">
	<ul>
<%  if (erros != null)
		for (String mensagem: erros) { %>
		<li><%=mensagem%></li>
	<% } %>
	</ul>
	</div>



	<form name="form" action="salvarCliente" method="post">
	
	
		<input type="hidden" name="codigo" value="<%=cliente.getCodigoStr() %>">
		<table border="0" cellpadding="7" cellspacing="20">
			<tr>
				<td>Código:</td>
				<td><%=cliente.getCodigoStr() %></td>
			</tr>
			
			<tr>
				<td>Convenio:</td>
				<td><select name="idConvenio">
						<option value="">Selecione...</option>
				<% for (Convenio forn:lista) { %>
					<option value="<%=forn.getCodigoStr()%>"><%=forn.getNome_convenioStr()%>
					</option>
				<% } %>
				</select>
				</td>
			</tr>
			
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="<%=cliente.getNomeStr()%>" size="80" maxlength="100"></td>
			</tr>
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" value="<%=cliente.getEnderecoStr()%>" size="80" maxlength="100"></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td>
				<input type="text" name="telefone" maxlength="14" value="<%=cliente.getTelefoneStr()%>" 
				 onkeypress="mascara(telefone);" />
				
				</td>
			</tr>
			<tr>
				<td>Data de Nascimento:</td>
				<td><input type="text" name="data_nascimento"  value="<%=cliente.getData_nascimentoStr()%>" size="15" maxlength="10" 
				id="calendario"></td>
			</tr>
			<tr>
				<td>Profissão:</td>
				<td><input type="text" name="profissao" value="<%=cliente.getProfissaoStr()%>" size="80" maxlength="100"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Salvar Cliente" >
					<input type="button" value="Cancelar" onclick="window.location='listarClientes'"></td>
			</tr>
		</table>
		</section>
		
	</form>
</body>
</html>