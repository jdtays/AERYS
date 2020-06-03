/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.DuracionYprecioPorTratamiento;
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
public class DuracionYprecioPorTratamientoDAO {

    private Connection conn;
    private PreparedStatement prep;
    private PreparedStatement stmt;
    private ResultSet rset;

    private DuracionYprecioPorTratamiento duracionYprecioPorTratamiento;
    private List<DuracionYprecioPorTratamiento> duracionYprecioPorTratamientos;

    public DuracionYprecioPorTratamientoDAO() {
    }

    public List<DuracionYprecioPorTratamiento> obtenerTodosLasDuracionesYprecioPorTratamientos() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from duracionyprecioportratamiento";
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            duracionYprecioPorTratamientos = new ArrayList<>();

            while (rset.next()) {
                duracionYprecioPorTratamiento = new DuracionYprecioPorTratamiento();
                duracionYprecioPorTratamiento.setDuracion(rset.getString("duracion"));
                duracionYprecioPorTratamiento.setMultiplicador(rset.getInt("multiplicador"));
                duracionYprecioPorTratamientos.add(duracionYprecioPorTratamiento);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodosLasDuracionesYprecioPorTratamientos()!");
        }
        return duracionYprecioPorTratamientos;
    }

    public DuracionYprecioPorTratamiento obtenerDuracionYprecioPorTratamientoPorId(int idDuracionYprecioPorTratamiento) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from duracionyprecioportratamiento where idDuracionYprecioPorTratamiento = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idDuracionYprecioPorTratamiento);
            rset = prep.executeQuery();

            if (rset.next()) {
                duracionYprecioPorTratamiento = new DuracionYprecioPorTratamiento();
                duracionYprecioPorTratamiento.setDuracion(rset.getString("duracion"));
                duracionYprecioPorTratamiento.setMultiplicador(rset.getInt("multiplicador"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerDuracionYprecioPorTratamientoPorId()!");
        }
        return duracionYprecioPorTratamiento;
    }

    public DuracionYprecioPorTratamiento obtenerDuracionYprecioPorTratamientoPorMultiplicador(int multiplicador) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from duracionyprecioportratamiento where multiplicador = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, multiplicador);
            rset = prep.executeQuery();

            if (rset.next()) {
                duracionYprecioPorTratamiento = new DuracionYprecioPorTratamiento();
                duracionYprecioPorTratamiento.setDuracion(rset.getString("duracion"));
                duracionYprecioPorTratamiento.setMultiplicador(rset.getInt("multiplicador"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerDuracionYprecioPorTratamientoPorId()!");
        }
        return duracionYprecioPorTratamiento;
    }
}
