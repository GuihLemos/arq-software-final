package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDAO;
import modelo.dominio.Agenda;
import modelo.dominio.Cliente;

/**
 * Servlet implementation class ServeletAbrirInclusaoAgenda
 */
@WebServlet("/abrirInclusaoAgenda")
public class ServeletAbrirInclusaoAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletAbrirInclusaoAgenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDAO daoCli = new ClienteDAO();
		List<Cliente> lista = daoCli.lerTodos();
		request.setAttribute("lista", lista);

		Agenda agenda = new Agenda();
		request.setAttribute("agenda", agenda);
		request.getRequestDispatcher("editarAgenda.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
