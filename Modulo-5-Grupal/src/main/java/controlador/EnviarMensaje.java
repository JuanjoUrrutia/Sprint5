package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Contacto;
import java.io.IOException;

import conexion.CapacitacionDAO;
import conexion.ContactoDAO;
import java.io.IOException;

/**
 * Servlet implementation class EnviarMensaje
 */
@WebServlet(name = "EnviarMensaje", urlPatterns = {"/Contacto/*"})

public class EnviarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMensaje() {
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
			request.getRequestDispatcher("contacto.jsp").forward(request, response);
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
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setEmail(email);
        contacto.setMensaje(mensaje);
        
        ContactoDAO contactoDAO = ContactoDAO.getInstancia();
        contactoDAO.agregarContacto(contacto);
        response.sendRedirect("ListaCapacitaciones");


	}

}