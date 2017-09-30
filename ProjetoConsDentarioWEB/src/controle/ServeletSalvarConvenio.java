package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AgendaDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.ConvenioDAO;
import modelo.dominio.Agenda;
import modelo.dominio.Cliente;
import modelo.dominio.Convenio;

/**
 * Servlet implementation class ServeletSalvarConvenio
 */
@WebServlet("/salvarConvenio")
public class ServeletSalvarConvenio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletSalvarConvenio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "Não é permitido enviar requisição via GET.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String nome_convenio = request.getParameter("nome_convenio");
		String data_adesao = request.getParameter("data_adesao");
		String inadimplente = request.getParameter("inadimplente");
				
		
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
				

		

		if ((nome_convenio == null) || (nome_convenio.isEmpty()))
			erros.add("O campo nome convenio é obrigatório.");
		
		if ((data_adesao == null) || (data_adesao.isEmpty()))
			erros.add("O campo data adesao é obrigatório.");
		
		if ((inadimplente == null) || (inadimplente.isEmpty()))
			erros.add("O campo data inadiplente é obrigatório.");

		
			
		Convenio convenio = new Convenio(codigoInt, nome_convenio, data_adesao,inadimplente);
		
		
		if (erros.isEmpty()) {
		
			ConvenioDAO dao = new ConvenioDAO();
			dao.salvar(convenio);
			
			response.sendRedirect("listarConvenios");
		}
		else
		{
			request.setAttribute("convenio", convenio);
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarConvenio.jsp").forward(request, response);;
		}
	}

	

}
