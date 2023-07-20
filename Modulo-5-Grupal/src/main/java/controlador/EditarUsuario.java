package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import conexion.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class EditarUsuario
 */
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        request.setAttribute("usuario", usuario);
        
        int rol = usuario.getRol();
        if (rol == 1) {
            request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
        } else if (rol == 2) {
            request.getRequestDispatcher("editarProfesional.jsp").forward(request, response);
        } else if (rol == 3) {
            request.getRequestDispatcher("editarAdministrativo.jsp").forward(request, response);
		};
	};

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
