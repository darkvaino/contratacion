/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.grafica;

import Clases.Usuario;
import Conexion.Conexion;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jhoan
 */
public class JF_Editar_Usuario extends javax.swing.JFrame {

    
    
    Properties datosProps = new Properties();
    Properties jfEditarProps = new Properties();

    public void cargarpropertiesdatos() {

        try {
            datosProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\datos.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties datos" + e.getMessage());
        }

    }

    public void cargarpropertiesjf_editar() {
        try {
            jfEditarProps.load(new FileInputStream("D:\\Documentos\\NetBeansProjects\\contratacion\\src\\main\\java\\packagesproperties\\jf_editar.properties"));
        } catch (IOException e) {
            System.out.println("error de cargar las properties jf_admin" + e.getMessage());
        }

    }
    
    /**
     * Creates new form JF_Editar_Usaurio
     */
    private String NombreUsuario_admin;

    public void setDatonombre(String NombreUsuario_admin) {
        this.NombreUsuario_admin = NombreUsuario_admin;
        lb_nombre.setText(NombreUsuario_admin);
    }

    private int v_id_usuario;
    private String v_nombreusuario;
    private String v_contraseña;
    private String v_rol;

    //resive los datos enviados del boton editar del jframe admin
    public void enviardato(int id_usuario, String nombreusuario, String Password, String rol)
    {
        this.v_id_usuario = id_usuario;
        this.v_nombreusuario = nombreusuario;
       this.v_contraseña = Password;
        this.v_rol = rol;
        
//        //se asiga los valores que llegan a los campos del formulario editar
//        txt_id_usuario.setText(idUsuarioCadena);
        txt_nombre.setText(v_nombreusuario);
        pss_contraseña.setText(v_contraseña);
        cb_rol.setSelectedItem(v_rol);

    }

   
 Usuario usuario = new Usuario();
    
    public JF_Editar_Usuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btm_Guardar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        cb_rol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        pss_contraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDICIÓN DE USUARIO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btm_Guardar.setText("Guardar");
        btm_Guardar.setPreferredSize(new java.awt.Dimension(64, 24));
        btm_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_GuardarActionPerformed(evt);
            }
        });

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        cb_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel2.setText(" Usuario");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Rol");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Editar Usuario:");

        lb_nombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb_nombre.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel4)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btm_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lb_nombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(pss_contraseña)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_nombre))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pss_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_regresar)
                    .addComponent(btm_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("EDITAR USUARIO");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btm_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_GuardarActionPerformed
       
         cargarpropertiesdatos();
         cargarpropertiesjf_editar();
      
        // Obtenemos los datos del formulario
        int idUsuario = v_id_usuario;
        String txt_usuarioNuevo = txt_nombre.getText();
        String txt_contraseñaNueva = new String(pss_contraseña.getPassword());        
        String rolNuevo = cb_rol.getSelectedItem().toString();
        
        

        if (txt_usuarioNuevo.equals("")) {
             String campovaciousuario = jfEditarProps.getProperty("mensaje.elcampousuarionopuedevacio");
            JOptionPane.showMessageDialog(null,campovaciousuario);
            return;
        }

        if (txt_contraseñaNueva.equals("")) {
            String campovacioucontraseña = jfEditarProps.getProperty("mensaje.elcampocontraseñanopuedevacio");
            JOptionPane.showMessageDialog(null, campovacioucontraseña);
            return;
        }
        
        
        Usuario usuario = new Usuario(txt_usuarioNuevo, txt_contraseñaNueva, rolNuevo);

        // Actualizamos los datos del usuario en la base de datos
        try 
        
        {
            
                // Obtener la instancia de la conexión
            Connection conexion = Conexion.getInstance(datosProps).getConnection();
            
         

            // Obtener la consulta SQL
            String consulta = jfEditarProps.getProperty("db.consultaupdateusuario");
            
//               System.out.print(consulta);

            // Crear la consulta preparada
            PreparedStatement consultasql = conexion.prepareStatement(consulta);
            
            
            

            consultasql.setString(1, txt_usuarioNuevo);
            consultasql.setString(2, txt_contraseñaNueva);
            consultasql.setString(3, rolNuevo);
            
            //                       && contraseñaNueva !=(contraseña)            
            if (usuario.getHash()!= "") {
                // Generar un nuevo hash BCrypt para la contraseña
                String hashnuevo = BCrypt.hashpw(txt_contraseñaNueva, BCrypt.gensalt());
                             
               consultasql.setString(4, hashnuevo);
//               JOptionPane.showMessageDialog(null, "se guardara con el nuevo hash");
                
            } else {
                // No se ha modificado la contraseña, por lo que no es necesario generar un nuevo hash
               consultasql.setString(4, usuario.getHash());
//                JOptionPane.showMessageDialog(null, "se guardo con el hash igual");
            }           
                consultasql.setInt(5, idUsuario);

                consultasql.executeUpdate();               
                
                String losdatoseguardaronexitoso = jfEditarProps.getProperty("mensaje.losdatoseguardaronexitoso");
                JOptionPane.showMessageDialog(null, losdatoseguardaronexitoso);
        
                 conexion.close();              
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
            
       
       
        // Cierra el formulario
        this.dispose();


    }//GEN-LAST:event_btm_GuardarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

   
   

    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Editar_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btm_Guardar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> cb_rol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JPasswordField pss_contraseña;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}