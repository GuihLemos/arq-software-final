<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Cliente"%>
<%@page import="modelo.dominio.Convenio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css\recurso.css" />
<link rel="stylesheet" type="text/css" href="css\tabela.css" />
<link rel="stylesheet" type="text/css" href="css\menu.css" />
<title>Cadastro de Clientes</title>
<script type="text/javascript">
	function excluir(codigo) {
		if (confirm('Deseja realmente apagar este cliente?'))
			window.location = 'excluirCliente?codigo=' + codigo;
	}
</script>

<script type="text/javascript">
	function buscar(nome) {
		
			window.location = 'buscarCliente?nome=' + nome;
	}
</script>
</head>
<body>

	<header>Cadastro de Cliente</header>

	<section> <%
 	List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
 	if (lista == null)
 		lista = new ArrayList<Cliente>();
 %> <!-- <a href="abrirInclusaoCliente">Novo Cliente</a>
<a href="index.jsp">Voltar</a>
 --> <!-- botoes -->
	<table border="0" cellpadding="6" cellspacing="20">
		<tr>

			<td><nav id="menu">
				<ul class="menu">


					<li><a href="abrirInclusaoCliente">Novo Cliente</a></li>
					<li><a href="index.jsp">Voltar</a></li>

				</ul>
				</nav></td>
		</tr>


	</table>

	<table>
	
	<td>
	Nome
    <input type="text"  value="" name="txtNome" />
    <input type="submit" id="meu-submit" value="Buscar" onclick="buscar(txtNome.value);"/>
    
		
	
	
	  </td>
	
	</table>
	
	<table border="1" cellpadding="7" cellspacing="0" class="tabela">
		<tr>
			<td>Opções</td>
			<td>Código</td>
			<td>Nome</td>
			<td>Endereço</td>
			<td>Telefone</td>
			<td>Data de nascimento</td>
			<td>Profissão</td>
			<td>Convenio</td>
		</tr>
		<%
			for (Cliente cliente : lista) {
		%>
		<tr>

			<td><a href="editarCliente?codigo=<%=cliente.getCodigo()%>">Alterar</a>
				<a href="#" onclick="excluir('<%=cliente.getCodigo()%>');">Excluir</a>
			</td>
			<td><%=cliente.getCodigo()%></td>
			<td><%=cliente.getNome()%></td>
			<td><%=cliente.getEndereco()%></td>
			<td><%=cliente.getTelefone()%></td>
			<td><%=cliente.getData_nascimento()%></td>
			<td><%=cliente.getProfissao()%></td>
			<td><%=cliente.getConvenio().getNome_convenio()%></td>
		</tr>
		<%
			}
		%>
	</table>
	</section>

</body>
</html>