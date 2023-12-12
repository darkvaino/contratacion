package edu.ucaldas.servicios;

import edu.ucaldas.servicios.DTO.PoliciaDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author willy
 */
public class TestServicioPolicia {
    
    @Test
    public void testAccesWebPage() {
        IServicioPolicia servicioPolicia = new ServicioPolicia();
        PoliciaDTO p = new PoliciaDTO();
        p.setCedula("1053771535");
        try {
            servicioPolicia.accesWebPage(p);
            Assertions.assertNotNull(p);
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(TestServicioPolicia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}
