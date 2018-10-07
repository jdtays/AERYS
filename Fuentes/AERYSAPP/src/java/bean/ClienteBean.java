/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDAO;
import dao.SolicitudDAO;
import domain.Cliente;
import domain.Solicitud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {


    String RedireccionDeRegistroClienteAinicioCliente = "registroCliente A inicioCliente";

    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    private Solicitud solicitud = new Solicitud();
    private List<Solicitud> solicitudes;

    public ClienteBean() {
        solicitudes = new ArrayList<>();
    }

    @PostConstruct
    public void inicializar() {
        if (cliente == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("correo");
            if (idParam != null && !idParam.equals("")) {
                cliente = clienteDAO.optenerPorCorreo(idParam);
            }
            if (cliente == null) {
                cliente = new Cliente();
            }
        }
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public List<Solicitud> getSolicitudes() {
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitudes = solicitudDAO.obtenerTodasLasSolicitudesDeCliente(cliente.getIdCliente());
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public String getRedireccionDeRegistroClienteAinicioCliente() {
        return RedireccionDeRegistroClienteAinicioCliente;
    }

    public void setRedireccionDeRegistroClienteAinicioCliente(String RedireccionDeRegistroClienteAinicioCliente) {
        this.RedireccionDeRegistroClienteAinicioCliente = RedireccionDeRegistroClienteAinicioCliente;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public String guardarCliente() {
        clienteDAO.agregarNuevoCliente(cliente);
        return RedireccionDeRegistroClienteAinicioCliente;
    }

    public Cliente autenticarCliente() {
        cliente = clienteDAO.AutenticacionDeCliente(cliente.getCorreo(), cliente.getContrasena());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
        if (cliente != null) {
            return cliente;
        } else {
            mensajeError("Correo o contrasena incorrectos");
            return null;
        }
    }

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            cliente = (Cliente) context.getExternalContext().getSessionMap().get("cliente");

            if (cliente == null) {
                context.getExternalContext().redirect("homeCliente.xhtml");
            }
        } catch (Exception e) {
        }
    }
// Utilitarios...

    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
