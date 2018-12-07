/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.net.httpserver.HttpServer;
import domain.Cosmetologa;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletResponse;
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

    public List<Cosmetologa> obtenerTodasLasCosmetologas() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from cosmetologa";
            prep = conn.prepareStatement(sql);
            rset = prep.executeQuery();

            cosmetologas = new ArrayList<>();

            while (rset.next()) {
                cosmetologa = new Cosmetologa();
                cosmetologa.setIdCosmetologa(rset.getInt("idCosmetologa"));
                cosmetologa.setCedula(rset.getString("cedula"));
                cosmetologa.setNombre(rset.getString("nombre"));
                cosmetologa.setApellido(rset.getString("apellido"));
                cosmetologa.setNombreCompleto(rset.getString("nombreCompleto"));
                cosmetologa.setTelefono(rset.getString("telefono"));
                cosmetologa.setCorreo(rset.getString("correo"));
                cosmetologa.setContrasena(rset.getString("contrasena"));
                cosmetologa.setIdGenero(rset.getInt("idGenero"));
                cosmetologa.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
                cosmetologas.add(cosmetologa);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLasCosmetologas()!");
        }
        return cosmetologas;
    }

    public void agregarNuevaCosmetologa(Cosmetologa cosmetologa) throws IOException {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into cosmetologa(idCosmetologa, cedula, nombre, apellido, nombreCompleto, telefono, correo, contrasena, idGenero, idTipoDeDocumento, fotoCosmetologa) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, cosmetologa.getIdCosmetologa());
            prep.setString(2, cosmetologa.getCedula());
            prep.setString(3, cosmetologa.getNombre());
            prep.setString(4, cosmetologa.getApellido());
            prep.setString(5, cosmetologa.getNombreCompleto());
            prep.setString(6, cosmetologa.getTelefono());
            prep.setString(7, cosmetologa.getCorreo());
            prep.setString(8, cosmetologa.getContrasena());
            prep.setInt(9, cosmetologa.getIdGenero());
            prep.setInt(10, cosmetologa.getIdTipoDeDocumento());
            prep.setBlob(11, cosmetologa.getFotoCosmetologa().getInputstream());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevaCosmetologa()!");
        }
    }

    public void modificarCosmetologa(Cosmetologa cosmetologa) throws IOException {
        try {
            conn = Conexion.getConexion();
            String sql = "update cosmetologa set cedula = ?, nombre = ?, apellido = ?, nombreCompleto = ?, telefono = ?, correo = ?, contrasena = ?, idGenero = ?, idTipoDeDocumento = ?, fotoCosmetologa = ? where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, cosmetologa.getCedula());
            prep.setString(2, cosmetologa.getNombre());
            prep.setString(3, cosmetologa.getApellido());
            prep.setString(4, cosmetologa.getNombreCompleto());
            prep.setString(5, cosmetologa.getTelefono());
            prep.setString(6, cosmetologa.getCorreo());
            prep.setString(7, cosmetologa.getContrasena());
            prep.setInt(8, cosmetologa.getIdGenero());
            prep.setInt(9, cosmetologa.getIdTipoDeDocumento());
            prep.setBlob(10, cosmetologa.getFotoCosmetologa().getInputstream());
            prep.setInt(11, cosmetologa.getIdCosmetologa());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al modificarCosmetologa!");
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - modificarCosmetologa()!");
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
                cosmetologa.setIdCosmetologa(rset.getInt("idCosmetologa"));
                cosmetologa.setCedula(rset.getString("cedula"));
                cosmetologa.setNombre(rset.getString("nombre"));
                cosmetologa.setApellido(rset.getString("apellido"));
                cosmetologa.setNombreCompleto(rset.getString("nombreCompleto"));
                cosmetologa.setTelefono(rset.getString("telefono"));
                cosmetologa.setCorreo(rset.getString("correo"));
                cosmetologa.setContrasena(rset.getString("contrasena"));
                cosmetologa.setIdGenero(rset.getInt("idGenero"));
                cosmetologa.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
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

    public void verFoto(Cosmetologa cosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from cosmetologa where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, cosmetologa.getIdCosmetologa());
            rset = prep.executeQuery();

            if (rset.next()) {
                cosmetologa = new Cosmetologa();
                cosmetologa.setFoto(rset.getBytes("fotoCosmetologa"));
            }
            while (rset.next()) {
                cosmetologa.setNombreCompleto(rset.getString("nombreCompleto"));
                cosmetologa.setFoto(rset.getBytes("fotoCosmetologa"));
            }
            if (cosmetologa.getFoto() != null) {
                HttpServletResponse response = ((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse());
                response.getOutputStream().write(cosmetologa.getFoto());
                response.getOutputStream().close();
                FacesContext.getCurrentInstance().responseComplete();
            }
            if (cosmetologa.getFoto() == null) {
                mensajeError(" no tiene foto");

            }

        } catch (Exception e) {
        }
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
                cosmetologa.setNombreCompleto(rset.getString("nombreCompleto"));
                cosmetologa.setTelefono(rset.getString("telefono"));
                cosmetologa.setCorreo(rset.getString("correo"));
                cosmetologa.setContrasena(rset.getString("contrasena"));
                cosmetologa.setIdGenero(rset.getInt("idGenero"));
                cosmetologa.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerCosmetologaPorCorreo()!");
        }
        return cosmetologa;
    }

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }

    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage("amigable", mensaje);
    }
}
