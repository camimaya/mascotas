/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import modelo.modelo;
import vista.vista;

/**
 *
 * @author giova
 */
public class controlador implements ActionListener{
    
    private vista view;
    private modelo model;
    
    public controlador(vista view, modelo model){
        this.view = view;
        this.model = model;
        this.view.aceptar.addActionListener(this);
        this.view.registrar.addActionListener(this);
        this.view.consultar.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("ventana");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        model.setMascota(view.mascota.getText());
        model.setPropietario(view.propietario.getText());
        
    }
}
