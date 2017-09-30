package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AgendaDAO;
import modelo.dominio.Agenda;




/**
 * Servlet implementation class ServeletExcluirAgenda
 */
@WebServlet("/excluirAgenda")
public class ServeletExcluirAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletExcluirAgenda() {
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
		
		dao.excluir(agenda);
		
		request.getRequestDispatcher("listarAgendas").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
