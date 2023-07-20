package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import modelo.Usuario;
import conexion.UsuarioDAO;

/**
 * Servlet implementation class Registro
 */
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Inicio").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
    	String nombre = request.getParameter("nombre");
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        String rut = request.getParameter("rut");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        String sistemaDeSalud = request.getParameter("sistemaDeSalud");
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        String edadStr = request.getParameter("edad");
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException | NullPointerException e) {
            edad = 0;
        }
        if (rol.equals("2") || rol.equals("3")) {
        	sistemaDeSalud = "0";
        };
        String area = request.getParameter("area");
        String experienciaPrevia = request.getParameter("experienciaPrevia");
        String titulo = request.getParameter("titulo");
        String fechaIngreso = request.getParameter("fechaIngreso");
        
        int sistemaDeSaludInt;
        try {
            sistemaDeSaludInt = Integer.parseInt(sistemaDeSalud);
        } catch (NumberFormatException e) {
            sistemaDeSaludInt = 0;
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setRol(Integer.parseInt(rol));
        usuario.setRut(rut);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setAfp(afp);
        usuario.setSistemaDeSalud(sistemaDeSaludInt);
        usuario.setDireccion(direccion);
        usuario.setComuna(comuna);
        usuario.setEdad(edad);
        usuario.setArea(area);
        usuario.setExperienciaPrevia(experienciaPrevia);
        usuario.setTitulo(titulo);
        usuario.setFechaIngreso(fechaIngreso);
        

        UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
        usuarioDAO.agregarUsuario(usuario);

        response.sendRedirect("ListaUsuarios");
	}

}
