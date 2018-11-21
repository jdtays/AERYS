/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
            String sql = "insert into cliente(idCliente, cedula, nombre, apellido, nombreCompleto, telefono, correo, contrasena, idGenero, idTipoDeDocumento) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, cliente.getIdCliente());
            prep.setString(2, cliente.getCedula());
            prep.setString(3, cliente.getNombre());
            prep.setString(4, cliente.getApellido());
            prep.setString(5, cliente.getNombreCompleto());
            prep.setString(6, cliente.getTelefono());
            prep.setString(7, cliente.getCorreo());
            prep.setString(8, cliente.getContrasena());
            prep.setInt(9, cliente.getIdGenero());
            prep.setInt(10, cliente.getIdTipoDeDocumento());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al insertar!");
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - agregarNuevoCliente()!");
        }
    }

    public void modificarCliente(Cliente cliente) {
        try {
            conn = Conexion.getConexion();
            String sql = "update cliente set cedula = ?, nombre = ?, apellido = ?, nombreCompleto = ?, telefono = ?, correo = ?, contrasena = ?, idGenero = ?, idTipoDeDocumento = ? where idCliente = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, cliente.getCedula());
            prep.setString(2, cliente.getNombre());
            prep.setString(3, cliente.getApellido());
            prep.setString(4, cliente.getNombreCompleto());
            prep.setString(5, cliente.getTelefono());
            prep.setString(6, cliente.getCorreo());
            prep.setString(7, cliente.getContrasena());
            prep.setInt(8, cliente.getIdGenero());
            prep.setInt(9, cliente.getIdTipoDeDocumento());
            prep.setInt(10, cliente.getIdCliente());

            int rta = prep.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al modificarCliente!");
            }

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - modificarCliente()!");
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
                cliente.setNombreCompleto(rset.getString("nombreCompleto"));
                cliente.setTelefono(rset.getString("telefono"));
                cliente.setCorreo(rset.getString("correo"));
                cliente.setContrasena(rset.getString("contrasena"));
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

    public Cliente BuscarDeClientePorCorreoYContrasena(String correo, String contrasena) {
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM cliente WHERE correo = ? AND contrasena = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            prep.setString(2, contrasena);
            rset = prep.executeQuery();
            if (rset.next()) {

                cliente = new Cliente();
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setCedula(rset.getString("cedula"));
                cliente.setNombre(rset.getString("nombre"));
                cliente.setApellido(rset.getString("apellido"));
                cliente.setNombreCompleto(rset.getString("nombreCompleto"));
                cliente.setTelefono(rset.getString("telefono"));
                cliente.setCorreo(rset.getString("correo"));
                cliente.setContrasena(rset.getString("contrasena"));
                cliente.setIdGenero(rset.getInt("idGenero"));
                cliente.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - AutenticacionDeCliente()!");
        }
        return cliente;
    }

    public Cliente optenerClientePorCorreo(String correo) {
        try {
            conn = Conexion.getConexion();
            String sql = "select * from cliente where correo = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, correo);
            rset = prep.executeQuery();

            if (rset.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rset.getInt("idCliente"));
                cliente.setCedula(rset.getString("cedula"));
                cliente.setNombre(rset.getString("nombre"));
                cliente.setApellido(rset.getString("apellido"));
                cliente.setNombreCompleto(rset.getString("nombreCompleto"));
                cliente.setTelefono(rset.getString("telefono"));
                cliente.setCorreo(rset.getString("correo"));
                cliente.setContrasena(rset.getString("contrasena"));
                cliente.setIdGenero(rset.getInt("idGenero"));
                cliente.setIdTipoDeDocumento(rset.getInt("idTipoDeDocumento"));
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - optenerPorCorreo()!");
        }
        return cliente;
    }
}
