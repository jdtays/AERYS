/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ServicioPorCosmetologa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Conexion;

/**
 *
 * @author josed
 */
public class ServicioPorCosmetologaDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private ServicioPorCosmetologa servicioPorCosmetologa;
    private List<ServicioPorCosmetologa> serviciosPorCosmetologa;

    public ServicioPorCosmetologaDAO() {
    }

    public List<ServicioPorCosmetologa> obtenerTodasLosServiciosPorCosmetologa() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from servicioporcosmetologa";
            prep = conn.prepareStatement(sql);
            rset = prep.executeQuery();

            serviciosPorCosmetologa = new ArrayList<>();

            while (rset.next()) {
                servicioPorCosmetologa = new ServicioPorCosmetologa();
                servicioPorCosmetologa.setIdServicioPorCosmetologa(rset.getInt("idServicioPorCosmetologa"));
                servicioPorCosmetologa.setIdServicio(rset.getInt("idServicio"));
                servicioPorCosmetologa.setNombreServicio(rset.getString("nombreServicio"));
                servicioPorCosmetologa.setIdCosmetologa(rset.getInt("idCosmetologa"));
                servicioPorCosmetologa.setNombreCosmetologa(rset.getString("nombreCosmetologa"));
                servicioPorCosmetologa.setDescripcion(rset.getString("descripcion"));
                serviciosPorCosmetologa.add(servicioPorCosmetologa);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodasLosServiciosPorCosmetologa()!");
        }
        return serviciosPorCosmetologa;
    }

    public void agregarNuevoServicioPorCosmetologa(ServicioPorCosmetologa servicioPorCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into servicioporcosmetologa(idServicioPorCosmetologa, idServicio, nombreServicio, idCosmetologa, nombreCosmetologa, descripcion) values(?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, servicioPorCosmetologa.getIdServicioPorCosmetologa());
            prep.setInt(2, servicioPorCosmetologa.getIdServicio());
            prep.setString(3, servicioPorCosmetologa.getNombreServicio());
            prep.setInt(4, servicioPorCosmetologa.getIdCosmetologa());
            prep.setString(5, servicioPorCosmetologa.getNombreCosmetologa());
            prep.setString(6, servicioPorCosmetologa.getDescripcion());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoServicioPorCosmetologa()!");
        }
    }

    public void modificarServicioPorCosmetologa(ServicioPorCosmetologa servicioPorCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "update servicioporcosmetologa set idServicio = ?, nombreServicio = ?, idCosmetologa = ?, nombreCosmetologa = ?, descripcion = ? where idServicioPorCosmetologa = ?";
            prep = conn.prepareStatement(sql);

            prep.setInt(1, servicioPorCosmetologa.getIdServicio());
            prep.setString(2, servicioPorCosmetologa.getNombreServicio());
            prep.setInt(3, servicioPorCosmetologa.getIdCosmetologa());
            prep.setString(4, servicioPorCosmetologa.getNombreCosmetologa());
            prep.setString(5, servicioPorCosmetologa.getDescripcion());
            prep.setInt(6, servicioPorCosmetologa.getIdServicioPorCosmetologa());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al modificarServicioPorCosmetologa!");
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - modificarServicioPorCosmetologa()!");
        }
    }

    public List<ServicioPorCosmetologa> obtenerTodosLosServiciosDeCosmetologa(int idCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from servicioporcosmetologa where idCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCosmetologa);
            rset = prep.executeQuery();

            serviciosPorCosmetologa = new ArrayList<>();

            while (rset.next()) {
                servicioPorCosmetologa = new ServicioPorCosmetologa();
                servicioPorCosmetologa.setIdServicioPorCosmetologa(rset.getInt("idServicioPorCosmetologa"));
                servicioPorCosmetologa.setIdServicio(rset.getInt("idServicio"));
                servicioPorCosmetologa.setNombreServicio(rset.getString("nombreServicio"));
                servicioPorCosmetologa.setIdCosmetologa(rset.getInt("idCosmetologa"));
                servicioPorCosmetologa.setNombreCosmetologa(rset.getString("nombreCosmetologa"));
                servicioPorCosmetologa.setDescripcion(rset.getString("descripcion"));
                serviciosPorCosmetologa.add(servicioPorCosmetologa);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodosLosServiciosDeCosmetologa()!");
        }
        return serviciosPorCosmetologa;
    }

    public void eliminarServicio(ServicioPorCosmetologa servicioPorCosmetologa) {
        try {
            conn = Conexion.getConexion();
            String sql = "delete from servicioporcosmetologa where idServicioPorCosmetologa = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, servicioPorCosmetologa.getIdServicioPorCosmetologa());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al eliminar!");
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - eliminarServicio()!");
        }
    }
}
