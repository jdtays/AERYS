/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utils.Conexion;

/**
 *
 * @author josed
 */
public class AdminDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private Admin admin;
    private List<Admin> admins;
    
    public AdminDAO(){
    }
    
        public boolean AutenticacionDeAdmin(String correo, String contrasena) {
        boolean Busqueda = false;
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM admin WHERE correo = ? AND contrasena = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            prep.setString(2, contrasena);
            rset = prep.executeQuery();
            if (rset.next()) {
                Busqueda = true;
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - AutenticacionDeAdmin()!");
        }
        return Busqueda;
    }
        
            public Admin optenerAdminPorCorreo(String correo) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from admin where correo = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            rset = prep.executeQuery();

            if (rset.next()) {
                admin = new Admin();
                admin.setIdAmind(rset.getInt("idAdmin"));
                admin.setCorreo(rset.getString("correo"));
                admin.setContrasena(rset.getString("contrasena"));
            
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - optenerPorCorreo()!");
        }
        return admin;
    }
}
