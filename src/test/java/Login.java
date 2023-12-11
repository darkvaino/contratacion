/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import UI.JF_Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author Jhoan
 */
public class Login 
{
  
 
    @Test
    public void testLoginCorrecta() {
        // Simular la entrada de usuario y contraseña
        String usuario = "johan";
        String contraseña = "asdf";

        // Ejecutar el método de autenticación y comprobar si el inicio de sesión es exitoso
        assertTrue(Login(usuario,contraseña),"ingreso correctamente");
    
    }

    @Test
    public void testLoginFallido() {
        // Simular la entrada de usuario y contraseña incorrectos
        String usuario = "test_user";
        String contraseña = "incorrect_password";

        // Ejecutar el método de autenticación y comprobar si el inicio de sesión falla
        assertFalse(Login(usuario,contraseña),"ingreso es fallido usaurio y contraseña incorrectos");
        
    }
    
     @Test
    public void testLoginVacio() {
        // Simular la entrada de usuario y contraseña vacios
        String usuario = "";
        String contraseña = "";

        // Ejecutar el método de autenticación y comprobar si el inicio de sesión falla
        assertFalse(Login(usuario,contraseña),"Los campos de usuario y contraseña estan vacios");
        
    }
    
     @Test
    public void testLoginContraseñaMal() {
        // Simular la entrada de usuario y la contraseña = mal
        String usuario = "johan";
        String contraseña = "qaz";

        // Ejecutar el método de autenticación y comprobar si el inicio de sesión falla
        
        assertFalse(Login(usuario,contraseña),"la contraseña esta incorrecta");
        
    }    
    

    
private boolean Login(String usuario, String contraseña) 
{
    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contratacion", "postgres", "1")) 
    {
        PreparedStatement consulta = connection.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
        consulta.setString(1, usuario);
        consulta.setString(2, contraseña);
        ResultSet resultado = consulta.executeQuery();

        if (resultado.next())
        {
            String hash = resultado.getString("hash");
            boolean passwordMatches = BCrypt.checkpw(contraseña, hash);
            if (passwordMatches) 
            {
                // Autenticación exitosa
//                connection.close();
                return true;
            }
             else 
            {
                // Contraseña incorrecta
//                connection.close();
               return false;
            }  
           
        }
       
     
    } 
    catch (SQLException e) 
    {
        // Manejo robusto de la excepción
        e.printStackTrace();
        // Loggear el error y devolver un mensaje de error genérico
        return false;
    }

    return false;
}
   

}
