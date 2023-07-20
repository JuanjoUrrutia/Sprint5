package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.util.List;

import conexion.UsuarioDAO;

/**
 * Servlet implementation class ListaUsuarios
 */
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession user = request.getSession(false);
		if (user != null && user.getAttribute("username") != null) {
	        UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
	        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
	        request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Inicio").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
