package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import conexion.CapacitacionDAO;
import modelo.Capacitacion;

/**
 * Servlet implementation class ListaCapacitaciones
 */

public class ListaCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCapacitaciones() {
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
	        CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();
	        
	        List<Capacitacion> capacitaciones = capacitacionDAO.obtenerCapacitaciones();
	        
	        request.setAttribute("capacitaciones", capacitaciones);
			request.getRequestDispatcher("listaCapacitaciones.jsp").forward(request, response);
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
