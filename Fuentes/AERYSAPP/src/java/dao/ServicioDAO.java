/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import utils.Conexion;

/**
 *
 * @author josed
 */
public class ServicioDAO {

    private Connection conn;
    private PreparedStatement prep;
    private PreparedStatement stmt;
    private ResultSet rset;

    private Servicio servicio;
    private List<Servicio> servicios;

    public ServicioDAO() {
    }

    public void agregarNuevoServicio(Servicio servicio) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into servicio(idServicio, nombre, descripcion, precio) values(?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, servicio.getIdServicio());
            prep.setString(2, servicio.getNombre());
            prep.setString(3, servicio.getDescripcion());
            prep.setInt(4, servicio.getPrecio());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoServicio()!");
        }
    }

    public List<Servicio> obtenerTodasLosServicios() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from servicio";
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            servicios = new ArrayList<>();

            while (rset.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rset.getInt("idServicio"));
                servicio.setNombre(rset.getString("nombre"));
                servicio.setDescripcion(rset.getString("descripcion"));
                servicio.setPrecio(rset.getInt("precio"));
                servicios.add(servicio);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLosServicios()!");
        }
        return servicios;
    }

    public Servicio obtenerServicioPorId(int idServicio) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from servicio where idServicio = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idServicio);
            rset = prep.executeQuery();

            if (rset.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rset.getInt("idServicio"));
                servicio.setNombre(rset.getString("nombre"));
                servicio.setDescripcion(rset.getString("descripcion"));
                servicio.setPrecio(rset.getInt("precio"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerServicioPorId()!");
        }
        return servicio;
    }

    public Servicio obtenerServicioNombre(String nombre) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from servicio where nombre = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, nombre);
            rset = prep.executeQuery();

            if (rset.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rset.getInt("idServicio"));
                servicio.setNombre(rset.getString("nombre"));
                servicio.setDescripcion(rset.getString("descripcion"));
                servicio.setPrecio(rset.getInt("precio"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerServicioPorId()!");
        }
        return servicio;
    }

    public void eliminarServicio(Servicio servicio) {
        boolean funcion = true;
        try {
            conn = Conexion.getConexion();
            String sql = "delete from servicio where idServicio = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, servicio.getIdServicio());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al eliminar!");
            }
        } catch (RuntimeException | SQLException e) {
            funcion = false;
            mensajeError("Aun hay solicitudes programadas con este servicio");
        }
        if (funcion == true) {
            mensajeAmigable("Servicio eliminado");
        }
    }

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }

    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }
}
