package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDAO;
import modelo.dao.ConvenioDAO;
import modelo.dominio.Cliente;
import modelo.dominio.Convenio;


/**
 * Servlet implementation class ServletAbrirInclusaoCliente
 */
@WebServlet("/abrirInclusaoCliente")
public class ServeletAbrirInclusaoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletAbrirInclusaoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ConvenioDAO daoConv= new ConvenioDAO();
		List<Convenio> lista = daoConv.lerTodos();
		request.setAttribute("lista", lista);
		
		
		Cliente cliente = new Cliente();

		request.setAttribute("cliente", cliente);

		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
