package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletEditarCliente
 */
@WebServlet("/editarCliente")
public class ServeletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletEditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		Integer chave = Integer.parseInt(codigo);
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.lerPorId(chave);
		request.setAttribute("cliente", cliente);
		
		ConvenioDAO daoConv = new ConvenioDAO();
		List<Convenio> lista = daoConv.lerTodos();
		request.setAttribute("lista", lista);
		
		
		
		RequestDispatcher desp = request.getRequestDispatcher("editarCliente.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
