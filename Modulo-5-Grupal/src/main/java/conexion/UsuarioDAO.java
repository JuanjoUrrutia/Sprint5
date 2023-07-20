package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {
    private static UsuarioDAO instancia;
    private Connection conexion;

    private UsuarioDAO() {
        // Establecer la conexión a la base de datos en el constructor privado
        // Usar Singleton para asegurar que solo haya una instancia de UsuarioDAO
        // y una única conexión a la base de datos en todo el proyecto
        conexion = obtenerConexion(); // Implementar este método
    }

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    // Métodos CRUD

    public List<Usuario> obtenerUsuarios() {
    	
        List<Usuario> usuarios = new ArrayList<>();
        String consulta = "SELECT id, nombre, username, password, rol, rut, fechaNacimiento, apellido, telefono, afp, sistemaDeSalud, direccion, comuna, edad, area, experienciaPrevia, titulo, fechaIngreso FROM usuario";

        try (
        	 PreparedStatement statement = conexion.prepareStatement(consulta);
        		
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setPassword(resultSet.getString("password"));
                int rol = resultSet.getInt("rol");
                usuario.setRol(resultSet.getInt("rol"));
                usuario.setRut(resultSet.getString("rut"));
                usuario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setAfp(resultSet.getString("afp"));
                usuario.setSistemaDeSalud(resultSet.getInt("sistemaDeSalud"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setComuna(resultSet.getString("comuna"));
                usuario.setEdad(resultSet.getInt("edad"));
                usuario.setArea(resultSet.getString("area"));
                usuario.setExperienciaPrevia(resultSet.getString("experienciaPrevia"));
                usuario.setTitulo(resultSet.getString("titulo"));
                usuario.setFechaIngreso(resultSet.getString("fechaIngreso"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String consulta = "SELECT id, nombre, username, password, rol, rut, fechaNacimiento, apellido, telefono, afp, sistemaDeSalud, direccion, comuna, edad, area, experienciaPrevia, titulo, fechaIngreso FROM usuario WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setUsername(resultSet.getString("username"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setRol(resultSet.getInt("rol"));
                    usuario.setRut(resultSet.getString("rut"));
                    usuario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    usuario.setApellido(resultSet.getString("apellido"));
                    usuario.setTelefono(resultSet.getString("telefono"));
                    usuario.setAfp(resultSet.getString("afp"));
                    usuario.setSistemaDeSalud(resultSet.getInt("sistemaDeSalud"));
                    usuario.setDireccion(resultSet.getString("direccion"));
                    usuario.setComuna(resultSet.getString("comuna"));
                    usuario.setEdad(resultSet.getInt("edad"));
                    usuario.setArea(resultSet.getString("area"));
                    usuario.setExperienciaPrevia(resultSet.getString("experienciaPrevia"));
                    usuario.setTitulo(resultSet.getString("titulo"));
                    usuario.setFechaIngreso(resultSet.getString("fechaIngreso"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public void agregarUsuario(Usuario usuario) {
        String consulta = "INSERT INTO usuario (nombre, username, password, rol, rut, fechaNacimiento, apellido, telefono, afp, sistemaDeSalud, direccion, comuna, edad, area, experienciaPrevia, titulo, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
        		
        	PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getUsername());
            statement.setString(3, usuario.getPassword());
            statement.setInt(4, usuario.getRol());
            statement.setString(5, usuario.getRut());
            statement.setString(6, usuario.getFechaNacimiento());
            statement.setString(7, usuario.getApellido());
            statement.setString(8, usuario.getTelefono());
            statement.setString(9, usuario.getAfp());
            statement.setInt(10, usuario.getSistemaDeSalud());
            statement.setString(11, usuario.getDireccion());
            statement.setString(12, usuario.getComuna());
            statement.setInt(13, usuario.getEdad());
            statement.setString(14, usuario.getArea());
            statement.setString(15, usuario.getExperienciaPrevia());
            statement.setString(16, usuario.getTitulo());
            statement.setString(17, usuario.getFechaIngreso());


            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        String consultaActualizarUsuario = "UPDATE usuario SET apellido = ?, telefono = ?, afp = ?, sistemaDeSalud = ?, direccion = ?, comuna = ?, edad = ?, area = ?, experienciaPrevia = ?, titulo = ?, fechaIngreso = ? WHERE id = ?";

        try (PreparedStatement statementActualizarUsuario = conexion.prepareStatement(consultaActualizarUsuario)) {
            statementActualizarUsuario.setString(1, usuario.getApellido());
            statementActualizarUsuario.setString(2, usuario.getTelefono());
            statementActualizarUsuario.setString(3, usuario.getAfp());
            statementActualizarUsuario.setInt(4, usuario.getSistemaDeSalud());
            statementActualizarUsuario.setString(5, usuario.getDireccion());
            statementActualizarUsuario.setString(6, usuario.getComuna());
            statementActualizarUsuario.setInt(7, usuario.getEdad());
            statementActualizarUsuario.setString(8, usuario.getArea());
            statementActualizarUsuario.setString(9, usuario.getExperienciaPrevia());
            statementActualizarUsuario.setString(10, usuario.getTitulo());
            statementActualizarUsuario.setString(11, usuario.getFechaIngreso());
            statementActualizarUsuario.setInt(12, usuario.getId());
            statementActualizarUsuario.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public void eliminarUsuario(int id) {
        String consulta = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

    private Connection obtenerConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/modulo5grupal";
            String usuario = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
}