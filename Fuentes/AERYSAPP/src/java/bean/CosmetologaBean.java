/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CosmetologaDAO;
import domain.Cosmetologa;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author josed
 */
@Named(value = "cosmetologaBean")
@ViewScoped
public class CosmetologaBean implements Serializable {

      String RedireccionDeHomeCosmetologaAinicioCosmetologa = "homeCosmetologa A inicioCosmetologa";
    String RedireccionDeRegistroCosmetologaAinicioCosmetologa = "registreoCosmetologa A inicioCosmetologa";

    private Cosmetologa cosmetologa;

    private CosmetologaDAO cosmetologaDAO = new CosmetologaDAO();

    @PostConstruct
    public void inicializar() {
        if (cosmetologa == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("idCosmetologa");

            if (idParam != null && !idParam.equals("")) {
                cosmetologa = cosmetologaDAO.obtenerCosmetologaPorId(Integer.parseInt(idParam));
            }
            if (cosmetologa == null) {
                cosmetologa = new Cosmetologa();
            }
        }
    }

    public Cosmetologa getCosmetologa() {
        return cosmetologa;
    }

    public void setCosmetologa(Cosmetologa cosmetologa) {
        this.cosmetologa = cosmetologa;
    }

    public CosmetologaDAO getCosmetologaDAO() {
        return cosmetologaDAO;
    }

    public void setCosmetologaDAO(CosmetologaDAO cosmetologaDAO) {
        this.cosmetologaDAO = cosmetologaDAO;
    }

    public String guardarCosmetologa() {
        cosmetologaDAO.agregarNuevaCosmetologa(cosmetologa);
        return RedireccionDeRegistroCosmetologaAinicioCosmetologa;
    }

    public String autenticar() {
        boolean busqueda = cosmetologaDAO.AutenticacionDeCosmetologa(cosmetologa.getCorreo(), cosmetologa.getContrasena());
        if (busqueda == true) {
            cosmetologa = cosmetologaDAO.obtenerCosmetologaPorCorreo(cosmetologa.getCorreo());
            mensaje("Bienvenido " + cosmetologa.getNombre() + " a tu tienda spa");
            return RedireccionDeHomeCosmetologaAinicioCosmetologa;
        } else {
            mensaje("Correo o contrasena incorrectos");
            return null;
        }
    }
    // Utilitarios...

    private void mensaje(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
