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
public class ServicioPorCosmetologa {
    private int idServicioPorCosmetologa;
    private int idServicio;
    private String nombreServicio;
    private int idCosmetologa;
    private String nombreCosmetologa;
    private String descripcion;

    public int getIdServicioPorCosmetologa() {
        return idServicioPorCosmetologa;
    }

    public void setIdServicioPorCosmetologa(int idServicioPorCosmetologa) {
        this.idServicioPorCosmetologa = idServicioPorCosmetologa;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getIdCosmetologa() {
        return idCosmetologa;
    }

    public void setIdCosmetologa(int idCosmetologa) {
        this.idCosmetologa = idCosmetologa;
    }

    public String getNombreCosmetologa() {
        return nombreCosmetologa;
    }

    public void setNombreCosmetologa(String nombreCosmetologa) {
        this.nombreCosmetologa = nombreCosmetologa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

 
}
