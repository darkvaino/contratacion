/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.grafica;

import Clases.PasswordRender;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Conexion.Conexion;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;


import javax.swing.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Jhoan
 */
public class JF_Admin extends javax.swing.JFrame
{

    Properties datosProps = new Properties();
    Properties jfAdminProps = new Properties();

    public void cargarpropertiesdatos() {

        try {
            datosProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\datos.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties datos" + e.getMessage());
        }

    }

    public void cargarpropertiesjf_admin() {
        try {
            jfAdminProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\jf_admin.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties jf_admin" + e.getMessage());
        }

    }
       
 
    public JF_Admin() {
        initComponents();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB_tablaUsuarios = new javax.swing.JTable();
        btncrear = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btnrecargar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBrol = new javax.swing.JComboBox<>();
        pss_contraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ADMINISTRADOR DE USUARIOS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema Administrador de Usuarios");

        TB_tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TB_tablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TB_tablaUsuarios);

        btncrear.setText("Crear Nuevo Usuario");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        btneditar.setText("Editar Usuario");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnborrar.setText("Borrar Usuario");
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });

        btnrecargar.setText("Recarga Tabla");
        btnrecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecargarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario :");

        jLabel3.setText("Contraseña :");

        jLabel4.setText("Rol :");

        CBrol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        CBrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBrolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(CBrol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pss_contraseña))
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrecargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pss_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CBrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

       
    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        
         // Leer el fichero de propiedades       
       cargarpropertiesjf_admin();  
      
        int selectedRow = TB_tablaUsuarios.getSelectedRow();

    if (selectedRow == -1) 
    {
        String selecionarusuario = jfAdminProps.getProperty("mensaje.selecionarusuario");
        JOptionPane.showMessageDialog(null, selecionarusuario, "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }
    else 
    {
        //obtenner el nombre del elemento 
        
        int id_usuario = Integer.parseInt((String.valueOf(TB_tablaUsuarios.getValueAt(TB_tablaUsuarios.getSelectedRow(),0))));
        String nombreusuario = String.valueOf(TB_tablaUsuarios.getValueAt(TB_tablaUsuarios.getSelectedRow(), 1));
        String contraseña = String.valueOf(TB_tablaUsuarios.getValueAt(TB_tablaUsuarios.getSelectedRow(), 2));
         String rol = String.valueOf(TB_tablaUsuarios.getValueAt(TB_tablaUsuarios.getSelectedRow(), 3));

        //Esta línea crea una nueva instancia de la ventana de edición de usuario.
        JF_Editar_Usuario var_jf_editar = new JF_Editar_Usuario();
        
        // Esta línea establece el nombre del usuario en la ventana de edición de usuario.
        //se llama el metodo setdatonombre que se creo en el jframen editar
        var_jf_editar.setDatonombre(nombreusuario);
       
      var_jf_editar.enviardato(id_usuario,nombreusuario,contraseña,rol);
      
       
        
        //Esta línea hace que la ventana de edición de usuario sea visible para el usuario.
        var_jf_editar.setVisible(true);
    }
        

  
        
    }//GEN-LAST:event_btneditarActionPerformed

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        //cargar fichero properties
        cargarpropertiesdatos();
        cargarpropertiesjf_admin();

        String txtusuario = txtusername.getText();
        String txtcontraseña = new String(pss_contraseña.getPassword());
        String txtrol = CBrol.getSelectedItem().toString();

        if (txtusuario.isEmpty()) {
            String campousuariovacio = jfAdminProps.getProperty("mensaje.campousuariovacio");

            JOptionPane.showMessageDialog(null, campousuariovacio);
            return;
        }

        if (txtcontraseña.isEmpty()) {

            String campocontraseñavacio = jfAdminProps.getProperty("mensaje.campocontraseñavacio");
            JOptionPane.showMessageDialog(null, campocontraseñavacio);
            return;
        }

//        if (txtrol.isEmpty()) {
//            String camporolvacio = props.getProperty("mensaje.elrolestavacio");
//            JOptionPane.showMessageDialog(null,camporolvacio);
//            return;
//        }

//expresion resular
//        String expresionresular = props.getProperty("expresionresular");
//        String regex = expresionresular;
//
//        if (!txtcontraseña.matches(regex)) {
//            String contraseñacorrecta = props.getProperty("mensaje.contraeñacorrecta");
//            JOptionPane.showMessageDialog(null, contraseñacorrecta);
//            return;
//        }

        //llamado al contructor de la clase usuario
        Usuario usuario = new Usuario(txtusuario, txtcontraseña, txtrol);

        try {

            // Obtener la instancia de la conexión
            Connection conexion = Conexion.getInstance(datosProps).getConnection();
            
         

            // Obtener la consulta SQL
            String consulta = jfAdminProps.getProperty("db.consultacrearusuario");
            
//               System.out.print(consulta);

            // Crear la consulta preparada
            PreparedStatement consultasql = conexion.prepareStatement(consulta);

//                     // Hashear la contraseña
            String hash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());

            consultasql.setString(1, usuario.getUsername());
//                   consulta.setString(2, usuario.getPassword());
            consultasql.setString(2, usuario.getPassword());
            consultasql.setString(3, usuario.getRol());
            consultasql.setString(4, hash);

            // int resultado = consulta.executeUpdate();  
            int resultado = consultasql.executeUpdate();

            if (resultado > 0) {
                limpiar();

                String registroexitoso = jfAdminProps.getProperty("mensaje.registroexitoso");
                
                JOptionPane.showMessageDialog(null, registroexitoso, "Alerta", JOptionPane.WARNING_MESSAGE);

                cargarTabla();

                conexion.close();
               
            } else {
                String registronoexitoso = jfAdminProps.getProperty("mensaje.registronoexitoso");
                System.out.println(registronoexitoso);
                JOptionPane.showMessageDialog(null, registronoexitoso, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            String erroriniciarsesion = jfAdminProps.getProperty("mensaje.erroriniciarsesion");
            System.out.println(erroriniciarsesion + e.getMessage());
            JOptionPane.showMessageDialog(null, erroriniciarsesion, "ERROR", JOptionPane.ERROR_MESSAGE);
        }


                
    }//GEN-LAST:event_btncrearActionPerformed

    private void CBrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBrolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBrolActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
         cargarTabla();
       
    }//GEN-LAST:event_formWindowOpened

    private void btnrecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecargarActionPerformed
         cargarTabla();       
       
    }//GEN-LAST:event_btnrecargarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
        
         cargarpropertiesdatos();
        cargarpropertiesjf_admin();
        //validar que la tabla  tenga datos

        if (TB_tablaUsuarios.getRowCount() > 0) {
            //que se halla selecionado el usuarios conrespondiente
            // trae la fila selecionada
            if (TB_tablaUsuarios.getSelectedRow() != -1) {
                //obtenner la id del elemento eliminar
                int id_usuario = Integer.parseInt((String.valueOf(TB_tablaUsuarios.getValueAt(TB_tablaUsuarios.getSelectedRow(), 0))));

                try {

                    // Obtener la instancia de la conexión
                    Connection conexion = Conexion.getInstance(datosProps).getConnection();

                    // Obtener la consulta SQL
                    String consulta = jfAdminProps.getProperty("db.consulta_borrar_usuario");

                    // Crear la consulta preparada
                    PreparedStatement consultasql = conexion.prepareStatement(consulta);

                    consultasql.setInt(1, id_usuario);
                    int result = consultasql.executeUpdate();

                    if (result > 0) {
                        cargarTabla();
                        String usuarioeliminadoexitoso = jfAdminProps.getProperty("mensaje.usuarioeliminadoexitoso");
                        System.out.println(usuarioeliminadoexitoso);
                        JOptionPane.showMessageDialog(null, usuarioeliminadoexitoso);
                    } else {
                        String erroeliminarusuario = jfAdminProps.getProperty("mensaje.erroeliminarusuario");
                        System.out.println(erroeliminarusuario);
                        JOptionPane.showMessageDialog(null, erroeliminarusuario, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    conexion.close();

                } catch (SQLException e) {
                    String errorconexionbasedatos = jfAdminProps.getProperty("mensaje.errorconexionbasedatos");
                    System.out.println(errorconexionbasedatos + e.getMessage());
                    JOptionPane.showMessageDialog(null, errorconexionbasedatos, "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
        
    
    }//GEN-LAST:event_btnborrarActionPerformed

    private void cargarTabla(){
     Usuario usuario = new Usuario();
     usuario.cargartablausuarios(TB_tablaUsuarios);// 
    
    }
    
    
    
  

    private void limpiar()    
    {
        txtusername.setText("");
        pss_contraseña.setText("");
                
              
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBrol;
    private javax.swing.JTable TB_tablaUsuarios;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btncrear;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnrecargar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pss_contraseña;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
