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

import modelo.Contacto;

public class ContactoDAO {
    private static ContactoDAO instancia;
    private Connection conexion;

    private ContactoDAO() {
        // Establecer la conexión a la base de datos en el constructor privado
        // Usar Singleton para asegurar que solo haya una instancia de ContactoDAO
        // y una única conexión a la base de datos en todo el proyecto
        conexion = obtenerConexion(); // Implementar este método
    }

    public static ContactoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ContactoDAO();
        }
        return instancia;
    }

    // Métodos CRUD

    public List<Contacto> obtenerContactos() {
    	
        List<Contacto> contactos = new ArrayList<>();
        String consulta = "SELECT id, nombre, email, mensaje FROM usuario";

        try (
        	 PreparedStatement statement = conexion.prepareStatement(consulta);
        		
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Contacto contacto = new Contacto();
                contacto.setId(resultSet.getInt("id"));
                contacto.setNombre(resultSet.getString("nombre"));
                contacto.setEmail(resultSet.getString("email"));
                contacto.setMensaje(resultSet.getString("mensaje"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contactos;
    }

    public Contacto obtenerContactoPorId(int id) {
        Contacto contacto = null;
        String consulta = "SELECT id, nombre, email, mensaje FROM contacto WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    contacto = new Contacto();
                    contacto.setId(resultSet.getInt("id"));
                    contacto.setNombre(resultSet.getString("nombre"));
                    contacto.setEmail(resultSet.getString("email"));
                    contacto.setMensaje(resultSet.getString("mensaje"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacto;
    }

    public void agregarContacto(Contacto contacto) {
        String consulta = "INSERT INTO contacto (nombre, email, mensaje) VALUES (?, ?, ?)";

        try (
        		
        	PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, contacto.getNombre());
            statement.setString(2, contacto.getEmail());
            statement.setString(3, contacto.getMensaje());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarContacto(Contacto contacto) {
        String consulta = "UPDATE contacto SET nombre = ?, email = ?, mensaje = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, contacto.getNombre());
            statement.setString(2, contacto.getEmail());
            statement.setString(3, contacto.getMensaje());
            statement.setInt(4, contacto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        String consulta = "DELETE FROM contacto WHERE id = ?";

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