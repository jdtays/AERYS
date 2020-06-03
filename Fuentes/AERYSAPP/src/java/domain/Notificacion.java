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
public class Notificacion {
    private String correoIA = "aerystiendaspa@gmail.com";
    private String contrasena = "proyectoDEGRADO2018";
    private String correoDestino = "aerystiendaspa@gmail.com";;
    private String Asunto;
    private String Mensaje;

    public String getCorreoIA() {
        return correoIA;
    }

    public void setCorreoIA(String correoIA) {
        this.correoIA = correoIA;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
    
    
            
    
}
