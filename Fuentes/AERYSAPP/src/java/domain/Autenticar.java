package domain;

import java.io.Serializable;

public class Autenticar implements Serializable {

    private int id_Autenticacion;
    private String Correo;
    private String Contrasena;

    public Autenticar() {
    }

    public int getId_Autenticacion() {
        return id_Autenticacion;
    }

    public void setId_Autenticacion(int id_Autenticacion) {
        this.id_Autenticacion = id_Autenticacion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

}
