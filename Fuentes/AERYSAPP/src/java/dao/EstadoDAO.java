/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Estado;
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
public class EstadoDAO {

    private Connection conn;
    private PreparedStatement prep;
    private PreparedStatement stmt;
    private ResultSet rset;

    private Estado estado;
    private List<Estado> estados;

    public EstadoDAO() {
    }

    public void agregarNuevoEstado(Estado estado) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into estado(idEstado, nombre, descripcion) values(?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, estado.getIdEstado());
            prep.setString(2, estado.getNombre());
            prep.setString(3, estado.getDescripcion());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoEstado()!");
        }
    }

    public List<Estado> obtenerTodasLosEstados() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from estado";
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            estados = new ArrayList<>();

            while (rset.next()) {
                estado = new Estado();
                estado.setIdEstado(rset.getInt("idEstado"));
                estado.setNombre(rset.getString("nombre"));
                estado.setDescripcion(rset.getString("descripcion"));
                estados.add(estado);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLosEstados()!");
        }
        return estados;
    }

    public Estado obtenerEstadoPorId(int idEstado) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from estado where idEstado = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idEstado);
            rset = prep.executeQuery();

            if (rset.next()) {
                estado = new Estado();
                estado.setIdEstado(rset.getInt("idEstado"));
                estado.setNombre(rset.getString("nombre"));
                estado.setDescripcion(rset.getString("descripcion"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerEstadoPorId()!");
        }
        return estado;
    }
    
      public void eliminarServicio(Estado estado) {
        boolean funcion = true;
        try {
            conn = Conexion.getConexion();
            String sql = "delete from estado where idEstado = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, estado.getIdEstado());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al eliminar!");
            }
        } catch (RuntimeException | SQLException e) {
            funcion = false;
            mensajeError("Aun hay solicitudes programadas con este estado");
        }
        if (funcion == true) {
            mensajeAmigable("Estado eliminado");
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
