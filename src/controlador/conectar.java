/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author GIOVANNY
 */
public class conectar {
Connection conect=null;
    public Connection conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:81/mascotas","root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error "+ e);
        }
    return conect;
    }
    
}
