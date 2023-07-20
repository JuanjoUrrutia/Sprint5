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
import modelo.Capacitacion;

import java.io.IOException;

import conexion.CapacitacionDAO;


/**
 * Servlet implementation class CrearCapacitacion
 */

public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


    public CrearCapacitacion() {
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
			request.getRequestDispatcher("crearCapacitacion.jsp").forward(request, response);
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
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		
        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setTitulo(titulo);
        capacitacion.setDescripcion(descripcion);
        capacitacion.setFecha(fecha);
        capacitacion.setHora(hora);
        capacitacion.setLugar(lugar);
        
        CapacitacionDAO capacitacionDAO = CapacitacionDAO.getInstancia();
        capacitacionDAO.agregarCapacitacion(capacitacion);


	}

}
