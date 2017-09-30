package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDAO;
import modelo.dominio.Cliente;


/**
 * Servlet implementation class ServletExcluirCliente
 */
@WebServlet("/excluirCliente")
public class ServeletExcluirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletExcluirCliente() {
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
		
		dao.excluir(cliente);
		
		request.getRequestDispatcher("listarClientes").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
