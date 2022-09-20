/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.conectar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.vista;

/**
 *
 * @author giova
 */
public class modelo {
    private String propietario;
    private String mascota;
    Socket server = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    
    public String consultar(){
        conectar cc =new conectar();
        Connection cn = cc.conexion();
        
        String msg = this.propietario;
        String slq="SELECT * FROM `afiliados` WHERE `propietario` LIKE '%" + this.propietario + "%'";
        try {
        PreparedStatement pst= cn.prepareStatement(slq);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String mensaje= rs.getString(1);
                this.propietario = mensaje;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE,null,ex);
        } 
        return this.propietario;
    }
    
    public String registrar(){
        conectar cc =new conectar();
        Connection cn = cc.conexion();

        String prop = this.propietario;
        String masc = this.mascota;
        String slq;
        slq = "INSERT INTO afiliados (mascota,propietario) VALUES (?)(?)";
        try {
        PreparedStatement pst= cn.prepareStatement(slq);
        pst.setString(1, masc);
        pst.setString(2, prop);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE,null,ex);
        } 
        //fin de subir a base de datos 
        
        
        try {
            dos.writeUTF(this.propietario);
        } catch (IOException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE,null,ex);
        }
        return "registro exitoso";
    }
    
}
