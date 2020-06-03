/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author josed
 */
public class Response <T> {

    int codigoRespuesta;
    String descripcionDeLaRespuesta;
    List<T> lista;

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getDescripcionDeLaRespuesta() {
        return descripcionDeLaRespuesta;
    }

    public void setDescripcionDeLaRespuesta(String descripcionDeLaRespuesta) {
        this.descripcionDeLaRespuesta = descripcionDeLaRespuesta;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
    
    
}
