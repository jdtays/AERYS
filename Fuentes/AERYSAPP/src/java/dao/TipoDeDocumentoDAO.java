/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Genero;
import domain.TipoDeDocumento;
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
public class TipoDeDocumentoDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private TipoDeDocumento tipoDeDocumento;
    private List<TipoDeDocumento> tipoDeDocumentos;

    public TipoDeDocumentoDAO() {
    }

    public List<TipoDeDocumento> obtenerTodos() {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from tipodedocumento";
            prep = conn.prepareStatement(sql);
            rset = prep.executeQuery();

            tipoDeDocumentos = new ArrayList<>();

            while (rset.next()) {
                tipoDeDocumento = new TipoDeDocumento();
                tipoDeDocumento.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
                tipoDeDocumento.setNombre(rset.getString("nombre"));
                tipoDeDocumento.setDescripcion(rset.getString("descripcion"));

                tipoDeDocumentos.add(tipoDeDocumento);
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodos()!");
        }
        return tipoDeDocumentos;
    }
}
