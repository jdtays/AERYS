/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDAO;
import domain.Cliente;
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
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    String RedireccionDeHomeClienteAinicioCliente = "homeCliente A inicioCliente";
    String RedireccionDeRegistroClienteAinicioCliente = "registroCliente A inicioCliente";

    private Cliente cliente;

    Cliente clienteTemporal;

    private ClienteDAO clienteDAO = new ClienteDAO();

    @PostConstruct
    public void inicializar() {
        if (cliente == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("idCliente");

            if (idParam != null && !idParam.equals("")) {
                cliente = clienteDAO.obtenerClientePorId(Integer.parseInt(idParam));
            }
            if (cliente == null) {
                cliente = new Cliente();
            }
        }
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

    public String autenticar() {
        boolean busqueda = clienteDAO.AutenticacionDeCliente(cliente.getCorreo(), cliente.getContrasena());
        if (busqueda == true) {
            cliente = clienteDAO.obtenerClientePorCorreo(cliente.getCorreo());
            return RedireccionDeHomeClienteAinicioCliente;

        } else {
            mensaje("Correo o contrasena incorrectos");
            return null;
        }
    }

  

    public Cliente datosDelCliente() {
        return cliente;
    }
// Utilitarios...

    private void mensaje(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
