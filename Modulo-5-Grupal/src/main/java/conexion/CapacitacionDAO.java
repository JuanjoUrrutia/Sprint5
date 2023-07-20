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

import modelo.Capacitacion;

public class CapacitacionDAO {
    private static CapacitacionDAO instancia;
    private Connection conexion;

    private CapacitacionDAO() {
        // Establecer la conexión a la base de datos en el constructor privado
        // Usar Singleton para asegurar que solo haya una instancia de CapacitacionDAO
        // y una única conexión a la base de datos en todo el proyecto
        conexion = obtenerConexion(); // Implementar este método
    }

    public static CapacitacionDAO getInstancia() {
        if (instancia == null) {
            instancia = new CapacitacionDAO();
        }
        return instancia;
    }

    // Métodos CRUD

    public List<Capacitacion> obtenerCapacitaciones() {
    	
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String consulta = "SELECT id, titulo, descripcion, fecha, hora, lugar FROM capacitacion";

        try (
        	 PreparedStatement statement = conexion.prepareStatement(consulta);
        		
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Capacitacion capacitacion = new Capacitacion();
                capacitacion.setId(resultSet.getInt("id"));
                capacitacion.setTitulo(resultSet.getString("titulo"));
                capacitacion.setDescripcion(resultSet.getString("descripcion"));
                capacitacion.setFecha(resultSet.getString("fecha"));
                capacitacion.setHora(resultSet.getString("hora"));
                capacitacion.setLugar(resultSet.getString("lugar"));
                capacitaciones.add(capacitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }

    public Capacitacion obtenerCapacitacionPorId(int id) {
        Capacitacion capacitacion = null;
        String consulta = "SELECT id, titulo, descripcion, fecha, hora, lugar FROM capacitacion WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    capacitacion = new Capacitacion();
                    capacitacion.setId(resultSet.getInt("id"));
                    capacitacion.setTitulo(resultSet.getString("titulo"));
                    capacitacion.setDescripcion(resultSet.getString("descripcion"));
                    capacitacion.setFecha(resultSet.getString("fecha"));
                    capacitacion.setHora(resultSet.getString("hora"));
                    capacitacion.setLugar(resultSet.getString("lugar"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitacion;
    }

    public void agregarCapacitacion(Capacitacion capacitacion) {
        String consulta = "INSERT INTO capacitacion (titulo, descripcion, fecha, hora, lugar) VALUES (?, ?, ?, ?, ?)";

        try (
        		
        	PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getTitulo());
            statement.setString(2, capacitacion.getDescripcion());
            statement.setString(3, capacitacion.getFecha());
            statement.setString(4, capacitacion.getHora());
            statement.setString(5, capacitacion.getLugar());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCapacitacion(Capacitacion capacitacion) {
        String consulta = "UPDATE capacitacion SET titulo = ?, descripcion = ?, fecha = ?, hora = ?, lugar = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getTitulo());
            statement.setString(2, capacitacion.getDescripcion());
            statement.setString(3, capacitacion.getFecha());
            statement.setString(4, capacitacion.getHora());
            statement.setString(5, capacitacion.getLugar());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCapacitacion(int id) {
        String consulta = "DELETE FROM capacitacion WHERE id = ?";

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