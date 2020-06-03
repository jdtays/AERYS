/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author josed
 */
public class Solicitud {

    private int idSolicitud;
    private int multiplicador;
    private String duracion;
    private String fecha;
    private String direccion;
    private String telefono;
    private String AnombreDe;
    private int idCliente;
    private String idSector;
    private String nombreCompletoCliente;
    private String nombreCompletoCosmetologa;
    private String idServicio;
    private String idEstado;
    private int idCosmetologa;
    private int precio;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAnombreDe() {
        return AnombreDe;
    }

    public void setAnombreDe(String AnombreDe) {
        this.AnombreDe = AnombreDe;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdSector() {
        return idSector;
    }

    public void setIdSector(String idSector) {
        this.idSector = idSector;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public String getNombreCompletoCosmetologa() {
        return nombreCompletoCosmetologa;
    }

    public void setNombreCompletoCosmetologa(String nombreCompletoCosmetologa) {
        this.nombreCompletoCosmetologa = nombreCompletoCosmetologa;
    }

    public int getIdCosmetologa() {
        return idCosmetologa;
    }

    public void setIdCosmetologa(int idCosmetologa) {
        this.idCosmetologa = idCosmetologa;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIdEstado(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDuracion(DuracionYprecioPorTratamiento duracionTemporal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
