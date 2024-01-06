/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jhoan
 */
public class PasswordRender extends JPasswordField implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) 
    {
        setText((String) table.getValueAt(row, column));
       setBorder(null);        
        if (value instanceof String) 
        {
            setText("********"); // Enmascarar password en asterisco
        }
        return this;
    }

   
}

