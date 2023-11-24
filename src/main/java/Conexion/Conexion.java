

package Conexion;

import java.sql.*;
/**
 *
 * @author Jhoan
 */
public class Conexion {
    
     private static Conexion instance;
    Connection connection;

    private Conexion(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

   public static Conexion getInstance(String url, String username, String password) throws SQLException {
    if (instance == null) {
        instance = new Conexion(url, username, password);
    }

    // Agregar mensaje

    if (instance.connection != null) {
        System.out.println("La conexión se realizó correctamente");
    } else {
        System.out.println("La conexión no se realizó correctamente");
    }

    return instance;
}

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public PreparedStatement prepareStatement(String select__from_login_WHERE_username___AND_p) {
        throw new UnsupportedOperationException("la consulta no se ejecuto."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
}
