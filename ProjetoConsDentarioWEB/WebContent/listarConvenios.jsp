<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.util.ArrayList"%>
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
<title>Cadastra Convenio</title>

<script type="text/javascript">
function mascaraData( campo, e )
{
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var data = campo.value;
	
	if( kC!=8 && kC!=46 )
	{
		if( data.length==2 )
		{
			campo.value = data += '/';
		}
		else if( data.length==5 )
		{
			campo.value = data += '/';
		}
		else
			campo.value = data;
	}
}
</script>
<script type="text/javascript">
	function excluir(codigo) {
		if (confirm('Deseja realmente apagar este Convenio?'))
			window.location = 'excluirConvenio?codigo=' + codigo;
	}
</script>

<script type="text/javascript">
	function buscar(nome) {

		window.location = 'buscarConvenio?nome_convenio=' + nome;
	}
</script>
</head>
<body>
	<header>Cadastro de Convenio</header>
	<section> <%
 	List<Convenio> lista = (List<Convenio>) request.getAttribute("lista");
 	if (lista == null)
 		lista = new ArrayList<Convenio>();
 %> <!-- botoes -->
	<table border="0" cellpadding="6" cellspacing="20">
		<tr>
			<td><nav id="menu">
				<ul class="menu">


					<li><a href="abrirInclusaoConvenio">Novo Convenio</a></li>
					<li><a href="index.jsp">Voltar</a></li>

				</ul>
				</nav></td>
		</tr>

		<table>

			<td align="left">Nome:</td>
			<td><input type="text" value="" name="txtNome" /> <input
				type="submit" id="meu-submit" value="Buscar"
				onclick="buscar(txtNome.value);" /></td>

		</table>
	</table>




	<table border="1" cellpadding="6" cellspacing="0" class="tabela">
		<tr>
			<td>Opções</td>
			<td>Código</td>
			<td>Nome</td>
			<td>Data Adesao</td>
			<td>Inadimplente</td>


		</tr>
		<%
			for (Convenio Convenio : lista) {
		%>
		<tr>
			<td><a href="editarConvenio?codigo=<%=Convenio.getCodigo()%>">Alterar</a>
				<a href="#" onclick="excluir('<%=Convenio.getCodigo()%>');">Excluir</a>
			</td>
			<td><%=Convenio.getCodigo()%></td>
			<td><%=Convenio.getNome_convenio()%></td>
			<td><%=Convenio.getData_adesao()%></td>
			<td><%=Convenio.getInadiplente()%></td>


		</tr>
		<%
			}
		%>
	</table>
	</section>

</body>
</html>