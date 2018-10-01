/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.fabric.xmlrpc.Client;
import domain.Cliente;
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
public class ClienteDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private Cliente cliente;
    private List<Cliente> clientes;

    public ClienteDAO() {
    }

    public void agregarNuevoCliente(Cliente cliente) {
        try {
            conn = Conexion.getConexion();
            String sql = "insert into cliente(idCliente, cedula, nombre, apellido, telefono, correo, contrasena, idGenero, idTipoDeDocumento) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, cliente.getIdCliente());
            prep.setString(2, cliente.getCedula());
            prep.setString(3, cliente.getNombre());
            prep.setString(4, cliente.getApellido());
            prep.setString(5, cliente.getTelefono());
            prep.setString(6, cliente.getCorreo());
            prep.setString(7, cliente.getContrasena());
            prep.setInt(8, cliente.getIdGenero());
            prep.setInt(9, cliente.getIdTipoDeDocumento());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoCliente()!");
        }
    }

    public Cliente obtenerClientePorId(int idCliente) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from cliente where idCliente = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, idCliente);
            rset = prep.executeQuery();

            if (rset.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setCedula(rset.getString("cedula"));
                cliente.setNombre(rset.getString("nombre"));
                cliente.setApellido(rset.getString("apellido"));
                cliente.setTelefono(rset.getString("telefono"));
                cliente.setCorreo(rset.getString("correo"));
                cliente.setIdGenero(rset.getInt("idGenero"));
                cliente.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerPorId()!");
        }
        return cliente;
    }

    public boolean AutenticacionDeCliente(String correo, String contrasena) {
        boolean Busqueda = false;
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM cliente WHERE correo = ? AND contrasena = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            prep.setString(2, contrasena);
            rset = prep.executeQuery();
            if (rset.next()) {
                Busqueda = true;
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - AutenticacionDeCliente()!");
        }
        return Busqueda;
    }

    public Cliente obtenerClientePorCorreo(String correo) {
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM cliente WHERE correo = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            rset = prep.executeQuery();

            if (rset.next()) {

                cliente = new Cliente();
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setCedula(rset.getString("cedula"));
                cliente.setNombre(rset.getString("nombre"));
                cliente.setApellido(rset.getString("apellido"));
                cliente.setTelefono(rset.getString("telefono"));
                cliente.setCorreo(rset.getString("correo"));
                cliente.setIdGenero(rset.getInt("idGenero"));
                cliente.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerClientePorCorreo()!");
        }
        return cliente;
    }

}
