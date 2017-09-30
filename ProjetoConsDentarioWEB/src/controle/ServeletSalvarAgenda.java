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
import modelo.dominio.Agenda;
import modelo.dominio.Cliente;


/**
 * Servlet implementation class ServeletSalvarAgenda
 */
@WebServlet("/salvarAgenda")
public class ServeletSalvarAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletSalvarAgenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403, "Não é permitido enviar requisição via GET.");
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String data = request.getParameter("data");
		String horario = request.getParameter("horario");
		
		String idCliente = request.getParameter("idCliente"); 
		
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
			
		
		
		Cliente cliente = null;
		ClienteDAO daoCli = new ClienteDAO();
		try {
			cliente = daoCli.lerPorId(Integer.parseInt(idCliente));
		} catch (NumberFormatException e) {
			cliente = null;
		}

		

		if ((data == null) || (data.isEmpty()))
			erros.add("O campo data é obrigatório.");
		
		if ((horario == null) || (horario.isEmpty()))
			erros.add("O campo horario é obrigatório.");

		
			
		Agenda agenda = new Agenda(codigoInt, data, horario);
		agenda.setCliente(cliente);
		
		if (erros.isEmpty()) {
		
			AgendaDAO dao = new AgendaDAO();
			dao.salvar(agenda);
			
			response.sendRedirect("listarAgendas");
		}
		else
		{
			request.setAttribute("agenda", agenda);
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarAgenda.jsp").forward(request, response);;
		}
	}



}
