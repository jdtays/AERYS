/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.GeneroDAO;
import dao.TipoDeDocumentoDAO;
import domain.Genero;
import domain.Response;
import domain.TipoDeDocumento;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author josed
 */
@Named(value = "generoBean")
@Dependent
public class GeneroBean {

    private Genero genero;

    private GeneroDAO generoDAO = new GeneroDAO();

    public GeneroBean() {
    }

    public List<Genero> getGeneros() {
        return generoDAO.obtenerTodos();
      //  Response respuesta = generoDAO.optenerTodosLosGeneros();
      //  if (respuesta.getCodigoRespuesta() == 0) {
       //     return respuesta.getLista();

      //  } else {
      //      mensajeError(respuesta.getDescripcionDeLaRespuesta());
     //       return respuesta.getLista();
      //  }
    }

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }

    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }
}
