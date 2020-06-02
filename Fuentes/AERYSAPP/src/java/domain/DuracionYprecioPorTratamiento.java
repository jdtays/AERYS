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
public class DuracionYprecioPorTratamiento {
    
    private int idDuracionYprecioPorTratamiento;
    private String duracion;
    private int multiplicador;

    public int getIdDuracionYprecioPorTratamiento() {
        return idDuracionYprecioPorTratamiento;
    }

    public void setIdDuracionYprecioPorTratamiento(int idDuracionYprecioPorTratamiento) {
        this.idDuracionYprecioPorTratamiento = idDuracionYprecioPorTratamiento;
    }

    
    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

}
