package controle;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ServletSalvarCliente
 */
@WebServlet("/salvarCliente")
public class ServeletSalvarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletSalvarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "N�o � permitido enviar requisi��o via GET.");
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		String data_nascimento = request.getParameter("data_nascimento");
		String profissao = request.getParameter("profissao");
		String idConvenio = request.getParameter("idConvenio"); 
		
		List<String> erros = new ArrayList<String>();
		
		Integer codigoInt = null;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			codigoInt = null;
		}
		
		Convenio convenio = null;
		ConvenioDAO daoConv = new ConvenioDAO();
		try {
			convenio = daoConv.lerPorId(Integer.parseInt(idConvenio));
		} catch (NumberFormatException e) {
			convenio = null;
		}
	

		if ((nome == null) || (nome.isEmpty()))
			erros.add("O campo nome � obrigat�rio.");

		if ((endereco == null) || (endereco.isEmpty()))
			erros.add("O campo endereco � obrigat�rio.");
		
		if ((telefone == null) || (telefone.isEmpty()))
			erros.add("O campo telefone � obrigat�rio.");
		
		if ((data_nascimento == null) || (data_nascimento.isEmpty()))
			erros.add("O campo data_nascimento � obrigat�rio.");
		
		if ((profissao == null) || (profissao.isEmpty()))
			erros.add("O campo profissao � obrigat�rio.");
			
		Cliente cliente = new Cliente(codigoInt, nome, endereco, telefone,data_nascimento,profissao);
		cliente.setConvenio(convenio);
		
		if (erros.isEmpty()) {
		
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			
			response.sendRedirect("listarClientes");
		}
		else
		{
			request.setAttribute("cliente", cliente);
			request.setAttribute("erros", erros);
			request.getRequestDispatcher("editarCliente.jsp").forward(request, response);;
		}
	}

		
	
		

	
}
	
