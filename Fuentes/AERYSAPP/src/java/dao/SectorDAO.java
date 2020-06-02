/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Sector;
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
public class SectorDAO {

    private Connection conn;
    private PreparedStatement prep;
    private PreparedStatement stmt;
    private ResultSet rset;

    private Sector sector;
    private List<Sector> sectores;

    public SectorDAO() {
    }

    public void agregarNuevoSector(Sector sector) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into sector(idSector, nombre, descripcion) values(?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, sector.getIdSector());
            prep.setString(2, sector.getNombre());
            prep.setString(3, sector.getDescripcion());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoSector()!");
        }
    }

    public List<Sector> obtenerTodasLosSectores() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from sector";
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            sectores = new ArrayList<>();

            while (rset.next()) {
                sector = new Sector();
                sector.setIdSector(rset.getInt("idSector"));
                sector.setNombre(rset.getString("nombre"));
                sector.setDescripcion(rset.getString("descripcion"));
                sectores.add(sector);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLosSectores()!");
        }
        return sectores;
    }

    public Sector obtenerSectorePorId(int idSector) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from sector where idSector = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idSector);
            rset = prep.executeQuery();

            if (rset.next()) {
                sector = new Sector();
                sector.setIdSector(rset.getInt("idSector"));
                sector.setNombre(rset.getString("nombre"));
                sector.setDescripcion(rset.getString("descripcion"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerSectorePorId()!");
        }
        return sector;
    }

    public void eliminarSector(Sector sector) {
        boolean funcion = true;
        try {
            conn = Conexion.getConexion();
            String sql = "delete from sector where idSector = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, sector.getIdSector());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al eliminar!");
            }
        } catch (RuntimeException | SQLException e) {
            funcion = false;
            mensajeError("Aun hay solicitudes programadas con este sector");
        }
        if (funcion == true) {
            mensajeAmigable("Sector eliminado");
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
