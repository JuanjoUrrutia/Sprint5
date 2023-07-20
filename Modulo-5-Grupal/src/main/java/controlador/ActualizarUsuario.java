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
 * Servlet implementation class ActualizarUsuario
 */
public class ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        int id = Integer.parseInt(request.getParameter("id"));
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
 
        usuario.setId(id);
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
        
        System.out.println("Atributos del objeto Usuario:");
        System.out.println("Id: " + usuario.getId());
        System.out.println("Fecha de nacimiento: " + usuario.getFechaNacimiento());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Teléfono: " + usuario.getTelefono());
        System.out.println("AFP: " + usuario.getAfp());
        System.out.println("Sistema de salud: " + usuario.getSistemaDeSalud());
        System.out.println("Direccion: " + usuario.getDireccion());
        System.out.println("Comuna: " + usuario.getComuna());
        System.out.println("Edad: " + usuario.getEdad());
        System.out.println("Area: " + usuario.getArea());
        System.out.println("Experiencia Previa: " + usuario.getExperienciaPrevia());
        System.out.println("Titulo: " + usuario.getTitulo());
        System.out.println("Fecha de ingreso: " + usuario.getFechaIngreso());


        UsuarioDAO usuarioDAO = UsuarioDAO.getInstancia();
        usuarioDAO.actualizarUsuario(usuario);

        response.sendRedirect("ListaUsuarios");}

}
