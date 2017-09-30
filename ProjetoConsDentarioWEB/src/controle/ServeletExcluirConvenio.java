package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.dao.ConvenioDAO;

import modelo.dominio.Convenio;

/**
 * Servlet implementation class ServeletExcluirConvenio
 */
@WebServlet("/excluirConvenio")
public class ServeletExcluirConvenio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletExcluirConvenio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		Integer chave = Integer.parseInt(codigo);
		
		ConvenioDAO dao = new ConvenioDAO();
		Convenio convenio = dao.lerPorId(chave);
		
		dao.excluir(convenio);
		
		request.getRequestDispatcher("listarConvenios").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
