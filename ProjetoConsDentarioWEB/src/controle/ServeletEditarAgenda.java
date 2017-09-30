package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AgendaDAO;
import modelo.dao.ClienteDAO;
import modelo.dominio.Agenda;
import modelo.dominio.Cliente;


/**
 * Servlet implementation class ServeletEditarAgenda
 */
@WebServlet("/editarAgenda")
public class ServeletEditarAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletEditarAgenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		Integer chave = Integer.parseInt(codigo);
		
		AgendaDAO dao = new AgendaDAO();
		Agenda agenda = dao.lerPorId(chave);
		request.setAttribute("agenda", agenda);
		
		ClienteDAO daoCli= new ClienteDAO();
		List<Cliente> lista = daoCli.lerTodos();
		request.setAttribute("lista", lista);
		
		RequestDispatcher desp = request.getRequestDispatcher("editarAgenda.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
