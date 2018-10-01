/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import domain.Cosmetologa;
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
public class CosmetologaDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private Cosmetologa cosmetologa;
    private List<Cosmetologa> cosmetologas;

    public CosmetologaDAO() {
    }

    public void agregarNuevaCosmetologa(Cosmetologa cosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into cosmetologa(idCosmetologa, cedula, nombre, apellido, telefono, correo, contrasena, idGenero, idTipoDeDocumento) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, cosmetologa.getIdCosmetologa());
            prep.setString(2, cosmetologa.getCedula());
            prep.setString(3, cosmetologa.getNombre());
            prep.setString(4, cosmetologa.getApellido());
            prep.setString(5, cosmetologa.getTelefono());
            prep.setString(6, cosmetologa.getCorreo());
            prep.setString(7, cosmetologa.getContrasena());
            prep.setInt(8, cosmetologa.getIdGenero());
            prep.setInt(9, cosmetologa.getIdTipoDeDocumento());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - Agregar()!");
        }
    }

    public Cosmetologa obtenerCosmetologaPorId(int idCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from cosmetologa where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCosmetologa);
            rset = prep.executeQuery();

            if (rset.next()) {
                cosmetologa = new Cosmetologa();
                prep.setInt(1, cosmetologa.getIdCosmetologa());
                prep.setString(2, cosmetologa.getCedula());
                prep.setString(3, cosmetologa.getNombre());
                prep.setString(4, cosmetologa.getApellido());
                prep.setString(5, cosmetologa.getTelefono());
                prep.setString(6, cosmetologa.getCorreo());
                prep.setString(7, cosmetologa.getContrasena());
                prep.setInt(8, cosmetologa.getIdGenero());
                prep.setInt(9, cosmetologa.getIdTipoDeDocumento());
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerPorId()!");
        }
        return cosmetologa;
    }

    public boolean AutenticacionDeCosmetologa(String correo, String contrasena) {
        boolean Busqueda = false;
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM cosmetologa WHERE correo = ? AND contrasena = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            prep.setString(2, contrasena);
            rset = prep.executeQuery();
            if (rset.next()) {
                Busqueda = true;
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - AutenticacionDeCosmetologa()!");
        }
        return Busqueda;
    }

      public Cosmetologa obtenerCosmetologaPorCorreo(String correo) {
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM cosmetologa WHERE correo = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            rset = prep.executeQuery();

            if (rset.next()) {
                cosmetologa = new Cosmetologa();
                cosmetologa.setIdCosmetologa(rset.getInt("idCosmetologa"));
                cosmetologa.setCedula(rset.getString("cedula"));
                cosmetologa.setNombre(rset.getString("nombre"));
                cosmetologa.setApellido(rset.getString("apellido"));
                cosmetologa.setTelefono(rset.getString("telefono"));
                cosmetologa.setCorreo(rset.getString("correo"));
                cosmetologa.setIdGenero(rset.getInt("idGenero"));
                cosmetologa.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerCosmetologaPorCorreo()!");
        }
        return cosmetologa;
    }
}
