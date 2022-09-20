/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotas_mvc;

import controlador.controlador;
import modelo.modelo;
import vista.vista;

/**
 *
 * @author giova
 */
public class Mascotas_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelo mod = new modelo();
        vista view = new vista();
        
        controlador ctrl = new controlador(view, mod);
        ctrl.iniciar();
        view.setVisible(true);
    }
    
}
