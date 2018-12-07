/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;



import org.primefaces.model.UploadedFile;
import java.sql.*;
/**
 *
 * @author josed
 */
public class Cosmetologa {

    private int idCosmetologa;
    private String cedula;
    private String nombre;
    private String apellido;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String contrasena;
    public UploadedFile fotoCosmetologa;
    private byte[] foto;
    


    private int idGenero;
    private int idTipoDeDocumento;

    public int getIdCosmetologa() {
        return idCosmetologa;
    }

    public void setIdCosmetologa(int idCosmetologa) {
        this.idCosmetologa = idCosmetologa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto() {
        nombreCompleto = nombre + " " + apellido;
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdTipoDeDocumento() {
        return idTipoDeDocumento;
    }

    public void setIdTipoDeDocumento(int idTipoDeDocumento) {
        this.idTipoDeDocumento = idTipoDeDocumento;
    }

    public UploadedFile getFotoCosmetologa() {
        return fotoCosmetologa;
    }

    public void setFotoCosmetologa(UploadedFile fotoCosmetologa) {
        this.fotoCosmetologa = fotoCosmetologa;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

 



}
