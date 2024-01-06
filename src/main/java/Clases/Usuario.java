/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexion.Conexion;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.DefaultCellEditor;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import java.sql.*;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Jhoan
 */
public class Usuario {
    private int id_login;
    private String username;
    private String password;
    private String rol;
     private String hash;

    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        
    }

    public Usuario(String username, String password, String rol, String hash) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.hash = hash;
    }

    public Usuario(int id_login ,String username, String password, String rol) {
        this.id_login = id_login;
        this.username = username;
        this.password = password;
        this.rol = rol;
        
    }
   

    public Usuario() {
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
     public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    
    
    public void cargartablausuarios(JTable tabla)
    {

        //Crear un modelo de datos para el JTable
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Id");
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Password");
        tableModel.addColumn("Rol");

        // Obtener los datos de la base de datos
        List<Usuario> usuarios = obtenerUsuariosDesdeBD();

        // Agregar los datos al modelo de tabla
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{usuario.getId_login(), usuario.getUsername(), usuario.getPassword(), usuario.getRol()});
        }

        // Asignar el modelo de tabla al JTable
        tabla.setModel(tableModel);

        TableColumn passwordColumn = tabla.getColumnModel().getColumn(2);
        passwordColumn.setCellEditor(new DefaultCellEditor(new JPasswordField()));
        PasswordRender cr = new PasswordRender();
        passwordColumn.setCellRenderer(cr);

    }
  

       Properties datosProps = new Properties();
        Properties jfAdminProps = new Properties();
    private List<Usuario> obtenerUsuariosDesdeBD() {
        List<Usuario> usuarios = new ArrayList<>();
     

        try {
            datosProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\datos.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties datos");
        }

        try {
            jfAdminProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\jf_admin.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties jf_admin");
        }

        try {

            // Obtener la instancia de la conexión
            Connection conexion = Conexion.getInstance(datosProps).getConnection();

//            System.out.println(conexion);
//
//            System.out.println(datosProps);

            // Obtener la consulta SQL
            String consulta = jfAdminProps.getProperty("db.consultacargatabla");

//            System.out.println(consulta);

            // Crear la consulta preparada
            PreparedStatement consultasql = conexion.prepareStatement(consulta);

            ResultSet resultado = consultasql.executeQuery();

            // Recorrer los resultados y crear objetos Usuario
            while (resultado.next()) {
                int id = resultado.getInt("id_login");
                String username = resultado.getString("username");
                String password = resultado.getString("password");
                String rol = resultado.getString("rol");

                Usuario usuario = new Usuario(id, username, password, rol);
                usuarios.add(usuario);
            }

//            // Cerrar la conexión y liberar recursos           
//            conexion.close();
        } catch (SQLException e) {
            System.out.println("no se conecto la base de datos " + " linea 189 del metodo obtenerUsuariosDesdeBD clase usuario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "no se conecto la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return usuarios;
    }

       
      

}
