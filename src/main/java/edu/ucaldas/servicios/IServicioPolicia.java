/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucaldas.servicios;

import edu.ucaldas.servicios.DTO.PoliciaDTO;
import java.io.IOException;

/**
 *
 * @author ucaldas
 */
public interface IServicioPolicia {
    
    public void accesWebPage(PoliciaDTO p) throws IOException, InterruptedException;
    
}
