/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Solicitud;
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
public class SolicitudDAO {
    
    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;
    
    private Solicitud solicitud;
    private List<Solicitud> solicitudes;
    
    public SolicitudDAO() {
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from solicitud";
            prep = conn.prepareStatement(sql);
            rset = prep.executeQuery();
            
            solicitudes = new ArrayList<>();
            
            while (rset.next()) {
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rset.getInt("idSolicitud"));
                solicitud.setDuracion(rset.getString("duracion"));
                solicitud.setFecha(rset.getString("fecha"));
                solicitud.setDireccion(rset.getString("direccion"));
                solicitud.setTelefono(rset.getString("telefono"));
                solicitud.setAnombreDe(rset.getString("AnombreDe"));
                solicitud.setIdCliente(rset.getInt("idCliente"));
                solicitud.setIdSector(rset.getString("idSector"));
                solicitud.setIdServicio(rset.getString("idServicio"));
                solicitud.setNombreCompletoCliente(rset.getString("nombreCompletoCliente"));
                solicitud.setNombreCompletoCosmetologa(rset.getString("nombreCompletoCosmetologa"));
                solicitud.setIdEstado(rset.getString("idEstado"));
                solicitud.setIdCosmetologa(rset.getInt("idCosmetologa"));
                solicitud.setPrecio(rset.getInt("precio"));
                
                solicitudes.add(solicitud);
            }
            
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLasSolicitudes()!");
        }
        return solicitudes;
    }
    
    public void agregarNuevaSolicitud(Solicitud solicitud) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into solicitud(idSolicitud, duracion, fecha, direccion, telefono, AnombreDe, idCliente, idCosmetologa, nombreCompletoCliente, nombreCompletoCosmetologa,idEstado, idSector, idServicio, precio)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, solicitud.getIdSolicitud());
            prep.setString(2, solicitud.getDuracion());
            prep.setString(3, solicitud.getFecha());
            prep.setString(4, solicitud.getDireccion());
            prep.setString(5, solicitud.getTelefono());
            prep.setString(6, solicitud.getAnombreDe());
            prep.setInt(7, solicitud.getIdCliente());
            prep.setInt(8, solicitud.getIdCosmetologa());
            prep.setString(9, solicitud.getNombreCompletoCliente());
            prep.setString(10, solicitud.getNombreCompletoCosmetologa());
            prep.setString(11, solicitud.getIdEstado());
            prep.setString(12, solicitud.getIdSector());
            prep.setString(13, solicitud.getIdServicio());
            prep.setInt(14, solicitud.getPrecio());
            
            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }
            
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevaSolicitud()!");
        }
    }
    
    public void modificarSolicitud(Solicitud solicitud) {
        try {
            conn = Conexion.getConexion();
            String sql = "update solicitud set duracion = ?, fecha = ?, direccion = ?, telefono = ?, AnombreDe = ?, idCliente = ?, idCosmetologa = ?, nombreCompletoCliente = ?, nombreCompletoCosmetologa = ?, idEstado = ?, idSector = ?,idServicio = ?, precio = ? where idSolicitud = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, solicitud.getDuracion());
            prep.setString(2, solicitud.getFecha());
            prep.setString(3, solicitud.getDireccion());
            prep.setString(4, solicitud.getTelefono());
            prep.setString(5, solicitud.getAnombreDe());
            prep.setInt(6, solicitud.getIdCliente());
            prep.setInt(7, solicitud.getIdCosmetologa());
            prep.setString(8, solicitud.getNombreCompletoCliente());
            prep.setString(9, solicitud.getNombreCompletoCosmetologa());
            prep.setString(10, solicitud.getIdEstado());
            prep.setString(11, solicitud.getIdSector());
            prep.setString(12, solicitud.getIdServicio());
            prep.setInt(13, solicitud.getPrecio());
            prep.setInt(14, solicitud.getIdSolicitud());
            
            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al modificarSolicitud!");
            }
            
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - modificarSolicitud()!");
        }
    }
    
    public Solicitud obtenerSolicitudPorId(int idSolicitud) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from solicitud where idSolicitud = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idSolicitud);
            rset = prep.executeQuery();
            
            if (rset.next()) {
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rset.getInt("idSolicitud"));
                solicitud.setDuracion(rset.getString("duracion"));
                solicitud.setFecha(rset.getString("fecha"));
                solicitud.setDireccion(rset.getString("direccion"));
                solicitud.setTelefono(rset.getString("telefono"));
                solicitud.setAnombreDe(rset.getString("AnombreDe"));
                solicitud.setIdCliente(rset.getInt("idCliente"));
                solicitud.setIdSector(rset.getString("idSector"));
                solicitud.setIdServicio(rset.getString("idServicio"));
                solicitud.setNombreCompletoCliente(rset.getString("nombreCompletoCliente"));
                solicitud.setNombreCompletoCosmetologa(rset.getString("nombreCompletoCosmetologa"));
                solicitud.setIdEstado(rset.getString("idEstado"));
                solicitud.setIdCosmetologa(rset.getInt("idCosmetologa"));
                solicitud.setPrecio(rset.getInt("precio"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerSolicitudPorId()!");
        }
        return solicitud;
    }
    
    public void eliminarSolicitud(Solicitud solicitud) {
        try {
            conn = Conexion.getConexion();
            String sql = "delete from solicitud where idSolicitud = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, solicitud.getIdSolicitud());
            
            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al eliminar!");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - eliminarSolicitud()!");
        }
    }
    
    public void eliminarTodasSolicitudesDeCliente(int idCliente) {
        try {
            conn = Conexion.getConexion();
            String sql = "delete from solicitud where idCliente = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCliente);
            
            int rta = prep.executeUpdate();
            if (rta != 1) {
            }
        } catch (RuntimeException | SQLException e) {
            mensajeAmigable("Todas las solicitudes del cliente fueron eliminadas");
        }
    }
    
        public void eliminarTodasSolicitudesDeCosmetologa(int idCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "delete from solicitud where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCosmetologa);
            
            int rta = prep.executeUpdate();
            if (rta != 1) {
            }
        } catch (RuntimeException | SQLException e) {
            mensajeAmigable("Todas las solicitudes de cosmetologa fueron eliminadas");
        }
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudesDeCliente(int idCliente) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from solicitud where idCliente = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCliente);
            rset = prep.executeQuery();
            
            solicitudes = new ArrayList<>();
            
            while (rset.next()) {
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rset.getInt("idSolicitud"));
                solicitud.setDuracion(rset.getString("duracion"));
                solicitud.setFecha(rset.getString("fecha"));
                solicitud.setDireccion(rset.getString("direccion"));
                solicitud.setTelefono(rset.getString("telefono"));
                solicitud.setAnombreDe(rset.getString("AnombreDe"));
                solicitud.setIdCliente(rset.getInt("idCliente"));
                solicitud.setIdSector(rset.getString("idSector"));
                solicitud.setIdServicio(rset.getString("idServicio"));
                solicitud.setNombreCompletoCliente(rset.getString("nombreCompletoCliente"));
                solicitud.setNombreCompletoCosmetologa(rset.getString("nombreCompletoCosmetologa"));
                solicitud.setIdEstado(rset.getString("idEstado"));
                solicitud.setIdCosmetologa(rset.getInt("idCosmetologa"));
                solicitud.setPrecio(rset.getInt("precio"));
                solicitudes.add(solicitud);
            }
            
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLasSolicitudesDeCliente()!");
        }
        return solicitudes;
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudesDeCosmetologa(int idCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from solicitud where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCosmetologa);
            rset = prep.executeQuery();
            
            solicitudes = new ArrayList<>();
            
            while (rset.next()) {
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rset.getInt("idSolicitud"));
                solicitud.setDuracion(rset.getString("duracion"));
                solicitud.setFecha(rset.getString("fecha"));
                solicitud.setDireccion(rset.getString("direccion"));
                solicitud.setTelefono(rset.getString("telefono"));
                solicitud.setAnombreDe(rset.getString("AnombreDe"));
                solicitud.setIdCliente(rset.getInt("idCliente"));
                solicitud.setIdSector(rset.getString("idSector"));
                solicitud.setIdServicio(rset.getString("idServicio"));
                solicitud.setNombreCompletoCliente(rset.getString("nombreCompletoCliente"));
                solicitud.setNombreCompletoCosmetologa(rset.getString("nombreCompletoCosmetologa"));
                solicitud.setIdEstado(rset.getString("idEstado"));
                solicitud.setIdCosmetologa(rset.getInt("idCosmetologa"));
                solicitud.setPrecio(rset.getInt("precio"));
                solicitudes.add(solicitud);
            }
            
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLasSolicitudesDeCosmetologa()!");
        }
        return solicitudes;
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
