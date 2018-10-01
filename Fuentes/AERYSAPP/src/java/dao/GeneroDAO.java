/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Genero;
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
public class GeneroDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private Genero genero;
    private List<Genero> generos;

    public GeneroDAO() {
    }

    public List<Genero> obtenerTodos() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from genero";
            prep = conn.prepareStatement(sql);
            rset = prep.executeQuery();

            generos = new ArrayList<>();

            while (rset.next()) {
                genero = new Genero();
                genero.setIdGenero(rset.getInt("idGenero"));
                genero.setNombre(rset.getString("nombre"));
                genero.setDescripcion(rset.getString("descripcion"));

                generos.add(genero);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodos()!");
        }
        return generos;
    }
}
