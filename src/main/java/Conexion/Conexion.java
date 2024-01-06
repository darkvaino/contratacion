

package Conexion;

import java.sql.*;
import java.util.Properties;
/**
 *
 * @author Jhoan
 */
public class Conexion {
    
  private static Conexion instance;
    private Connection connection;

    private Conexion(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static synchronized Conexion getInstance(Properties props) throws SQLException {
        // Verificar si la instancia de conexión ya existe
        if (instance == null) {
            // Obtener los valores de URL, nombre de usuario y contraseña de las propiedades del archivo de configuración
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Crear una nueva instancia de la clase Conexion con los valores obtenidos
            instance = new Conexion(url, username, password);
        }

        // Verificar el estado de la conexión y mostrar un mensaje correspondiente
        if (instance.connection != null) 
        {
            // Obtener el mensaje de conexión correcta de las propiedades del archivo de configuración
            String mensajeConexionCorrecta = props.getProperty("mensaje.conexion.correcta");

            // Mostrar el mensaje de conexión correcta en la consola
            System.out.println(mensajeConexionCorrecta);
        } else 
        {
            // Obtener el mensaje de conexión incorrecta de las propiedades del archivo de configuración
            String mensajeConexionIncorrecta = props.getProperty("mensaje.conexion.incorrecta");

            // Mostrar el mensaje de conexión incorrecta en la consola
            System.out.println(mensajeConexionIncorrecta);
        }

        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    Properties props = new Properties();
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
            String mensajeconexioncerrocorrectamente = props.getProperty("mensaje.conexion.cerro.correctamente");
           System.out.println(mensajeconexioncerrocorrectamente);
        }
    }

    public PreparedStatement prepareStatement(String select__from_login_WHERE_username___AND_p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

} //llave que cierra clase conexion


