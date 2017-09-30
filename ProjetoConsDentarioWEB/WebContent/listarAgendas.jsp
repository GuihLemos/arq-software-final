<%@page import="modelo.dominio.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dominio.Agenda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"  href="css\recurso.css" />
<link rel="stylesheet" type="text/css"  href="css\menu.css" />
<link rel="stylesheet" type="text/css"  href="css\tabela.css" />
<title>Cadastra Agenda</title>
<script type="text/javascript">
function excluir(codigo)
{
	if (confirm('Deseja realmente apagar este Agenda?'))
		window.location = 'excluirAgenda?codigo=' + codigo;
}
</script>
</head>

<%
List<String> erros = (List<String>)request.getAttribute("erros");

List<Cliente> listaCli = (List<Cliente>) request.getAttribute("lista");
if (listaCli == null)
	listaCli = new ArrayList<Cliente>();
%>
<body>
	<header>Agendar Cliente</header>
<section>
<%
	List<Agenda> lista = (List<Agenda>)request.getAttribute("lista");
	if (lista == null)
		lista = new ArrayList<Agenda>();
%>

<!-- botoes -->
<table border="0" cellpadding="6" cellspacing="20">
		<tr>
			<td><nav id="menu">
				<ul class="menu">

			
		<li><a href="abrirInclusaoAgenda">Novo Agenda</a></li>	  		
		<li><a href="index.jsp">Voltar</a></li>
		               
</ul>
</nav></td>
		</tr>
		
		</table>




<table border="1" cellpadding="10" cellspacing="0" class="tabela"> 
	<tr>
		<td>Opções</td>
		<td>Código</td>
		<td>Data</td>
		<td>Hora</td>
		<td>Cliente</td>
		
	</tr>
<%
for (Agenda agenda : lista) {
%>
	<tr>
		<td><a href="editarAgenda?codigo=<%=agenda.getCodigo()%>">Alterar</a>
		    <a href="#" onclick="excluir('<%=agenda.getCodigo()%>');">Excluir</a>
		</td>
		<td><%=agenda.getCodigo()%></td>
		<td><%=agenda.getData()%></td>
		<td><%=agenda.getHorario()%></td>
		<td><%=agenda.getCliente().getNome()%></td>
		
	</tr>
<%	}
%>
</table>
</section>

</body>
</html>