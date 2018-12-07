/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDAO;
import dao.CosmetologaDAO;
import dao.DuracionYprecioPorTratamientoDAO;
import dao.EstadoDAO;
import dao.NotificacionDAO;
import dao.SectorDAO;
import dao.SolicitudDAO;
import dao.ServicioDAO;
import dao.ServicioPorCosmetologaDAO;
import domain.Cliente;
import domain.Cosmetologa;
import domain.DuracionYprecioPorTratamiento;
import domain.Estado;
import domain.Notificacion;
import domain.Sector;
import domain.Servicio;
import domain.ServicioPorCosmetologa;
import domain.Solicitud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author josed
 */
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    String RedireccionAIndex = "index.xhtml";
    String RedireccionDeRegistroClienteAinicioCliente = "registroCliente A inicioCliente";
    String RedireccionAHomeCliente = "homeCliente.xhtml";
    String RedireccionAInicioCliente = "inicioCliente.xhtml";
    String RedireccionAsolicitudes = "solicitudesCliente.xhtml";
    String mensajeNotificacionTemporal;
    String asuntoNotificacionTemporal;

    String EstadoPredeterminadoDeSolicitud = "Por confirmar";

    private Cliente cliente;
    private Cosmetologa cosmetologa;
    private ClienteDAO clienteDAO = new ClienteDAO();

    @ManagedProperty("#{Solicitud}")
    private ServicioPorCosmetologa servicioPorCosmetologa = new ServicioPorCosmetologa();
    private List<ServicioPorCosmetologa> serviciosPorCosmetologa;

    private Solicitud solicitud = new Solicitud();
    private List<Solicitud> solicitudes;

    private Servicio servicio = new Servicio();
    private List<Servicio> servicios;

    private Estado estado = new Estado();
    private List<Estado> estados;

    private Sector sector = new Sector();
    private List<Sector> sectores;

    private Solicitud solicitudSeleccionada;
    private List<Solicitud> solicitudesSeleccionada;

    private DuracionYprecioPorTratamiento duracionYprecioPorTratamiento = new DuracionYprecioPorTratamiento();
    private List<DuracionYprecioPorTratamiento> duracionYprecioPorTratamientos;

    public ClienteBean() {
        solicitudes = new ArrayList<>();
        servicios = new ArrayList<>();
        estados = new ArrayList<>();
        sectores = new ArrayList<>();
        duracionYprecioPorTratamientos = new ArrayList<>();
    }

    @PostConstruct
    public void inicializar() {
        if (cliente == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("correo");
            if (idParam != null && !idParam.equals("")) {
                cliente = clienteDAO.optenerClientePorCorreo(idParam);
            }
            if (cliente == null) {
                cliente = new Cliente();
            }
        }
    }

    // Getters y Setters...
    public ServicioPorCosmetologa getServicioPorCosmetologa() {
        return servicioPorCosmetologa;
    }

    public void setServicioPorCosmetologa(ServicioPorCosmetologa servicioPorCosmetologa) {
        this.servicioPorCosmetologa = servicioPorCosmetologa;
    }

    public List<ServicioPorCosmetologa> getServiciosPorCosmetologa() {
        return serviciosPorCosmetologa;
    }

    public void setServiciosPorCosmetologa(List<ServicioPorCosmetologa> serviciosPorCosmetologa) {
        this.serviciosPorCosmetologa = serviciosPorCosmetologa;
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getServicios() {
        ServicioDAO servicioDAO = new ServicioDAO();
        servicios = servicioDAO.obtenerTodasLosServicios();
        return servicios;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Sector> getSectores() {
        SectorDAO sectorDAO = new SectorDAO();
        sectores = sectorDAO.obtenerTodasLosSectores();
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        EstadoDAO estadoDAO = new EstadoDAO();
        estados = estadoDAO.obtenerTodasLosEstados();
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public DuracionYprecioPorTratamiento getDuracionYprecioPorTratamiento() {
        return duracionYprecioPorTratamiento;
    }

    public void setDuracionYprecioPorTratamiento(DuracionYprecioPorTratamiento duracionYprecioPorTratamiento) {
        this.duracionYprecioPorTratamiento = duracionYprecioPorTratamiento;
    }

    public List<DuracionYprecioPorTratamiento> getDuracionYprecioPorTratamientos() {
        DuracionYprecioPorTratamientoDAO duracionYprecioPorTratamientoDAO = new DuracionYprecioPorTratamientoDAO();
        duracionYprecioPorTratamientos = duracionYprecioPorTratamientoDAO.obtenerTodosLasDuracionesYprecioPorTratamientos();
        return duracionYprecioPorTratamientos;
    }

    public void setDuracionYprecioPorTratamientos(List<DuracionYprecioPorTratamiento> duracionYprecioPorTratamientos) {
        this.duracionYprecioPorTratamientos = duracionYprecioPorTratamientos;
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

    public Solicitud getSolicitudSeleccionada() {
        return solicitudSeleccionada;
    }

    public void setSolicitudSeleccionada(Solicitud solicitudSeleccionada) {
        this.solicitudSeleccionada = solicitudSeleccionada;
    }

    public List<Solicitud> getSolicitudesSeleccionada() {
        return solicitudesSeleccionada;
    }

    public void setSolicitudesSeleccionada(List<Solicitud> solicitudesSeleccionada) {
        this.solicitudesSeleccionada = solicitudesSeleccionada;
    }

    // Operaciones de negocio...
    public String guardarCliente() {
        Cliente clienteTemporal = clienteDAO.optenerClientePorCorreo(cliente.getCorreo());
        if (clienteTemporal == null) {
            clienteDAO.agregarNuevoCliente(cliente);
            mensajeAmigable("Bienvenido " + cliente.getNombre() + " a tu tienda spa");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            
            Notificacion notificacion = new Notificacion();
            asuntoNotificacionTemporal = "Nuevo cliente";
            mensajeNotificacionTemporal = "Hola admin. " + cliente.getNombreCompleto()+ " se a registrado en la aplicacion";
            notificacion.setAsunto(asuntoNotificacionTemporal);
            notificacion.setMensaje(mensajeNotificacionTemporal);

            NotificacionDAO notificacionDAO = new NotificacionDAO();
            notificacionDAO.enviarNotificacion(notificacion);
            
            return RedireccionDeRegistroClienteAinicioCliente;
        } else {
            mensajeError("Este correo ya esta registrado");
            return null;
        }

    }

    public void eliminarTodasLasSolicitusDeCliente() {
        int idClienteTemporal = cliente.getIdCliente();
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitudDAO.eliminarTodasSolicitudesDeCliente(idClienteTemporal);

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
        mensajeAmigable("Solicitudes eliminadas");

    }

    public void eliminarSolicitudDeCliente() {
        Solicitud solicitudTemporal = solicitudSeleccionada;

        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitudDAO.eliminarSolicitud(solicitudTemporal);

        CosmetologaDAO cosmetologaDAO = new CosmetologaDAO();
        cosmetologa = cosmetologaDAO.obtenerCosmetologaPorId(solicitudTemporal.getIdCosmetologa());

        Notificacion notificacion = new Notificacion();
        notificacion.setCorreoDestino(cosmetologa.getCorreo());
        asuntoNotificacionTemporal = "Cancelacion de servicio";
        mensajeNotificacionTemporal = "Hola " + cosmetologa.getNombreCompleto() + " " + cliente.getNombreCompleto() + " a cancelado el servicio para el dia " + solicitudSeleccionada.getFecha() + " te suguiero confirmar esta informacion al telefono " + solicitudSeleccionada.getTelefono();

        notificacion.setMensaje(mensajeNotificacionTemporal);
        notificacion.setAsunto(asuntoNotificacionTemporal);
        NotificacionDAO notificacionDAO = new NotificacionDAO();
        notificacionDAO.enviarNotificacion(notificacion);

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
        mensajeAmigable("Solicitud eliminada");

    }

    public void modificarCliente() {
        clienteDAO.modificarCliente(cliente);
        mensajeAmigable("Modificacion exitosa");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
    }

    public String autenticarCliente() {
        boolean busqueda = clienteDAO.AutenticacionDeCliente(cliente.getCorreo(), cliente.getContrasena());
        if (busqueda == true) {
            cliente = clienteDAO.optenerClientePorCorreo(cliente.getCorreo());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            mensajeAmigable("Bienvenido " + cliente.getNombre() + " a tu tienda spa");
            return RedireccionAInicioCliente;
        } else {
            mensajeError("Correo o contrasena incorrectos");
            return null;
        }
    }

    public String solicitarServicio() {

        DuracionYprecioPorTratamientoDAO duracionYprecioPorTratamientoDAO = new DuracionYprecioPorTratamientoDAO();
        duracionYprecioPorTratamiento = duracionYprecioPorTratamientoDAO.obtenerDuracionYprecioPorTratamientoPorMultiplicador(solicitud.getMultiplicador());
        String duracionTemporal = duracionYprecioPorTratamiento.getDuracion();

        ServicioDAO servicioDAO = new ServicioDAO();
        servicio = servicioDAO.obtenerServicioNombre(solicitud.getIdServicio());
        int precioServicioTemporal = (servicio.getPrecio() * solicitud.getMultiplicador());

        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitud.setNombreCompletoCliente(cliente.getNombreCompleto());

        CosmetologaDAO CosmetologaDAO = new CosmetologaDAO();
        Cosmetologa cosmetologaTemporal = CosmetologaDAO.obtenerCosmetologaPorId(solicitud.getIdCosmetologa());
        solicitud.setNombreCompletoCosmetologa(cosmetologaTemporal.getNombreCompleto());

        solicitud.setDuracion(duracionTemporal);
        solicitud.setPrecio(precioServicioTemporal);
        solicitud.setIdCliente(cliente.getIdCliente());
        solicitud.setIdEstado(EstadoPredeterminadoDeSolicitud);

        solicitudDAO.agregarNuevaSolicitud(solicitud);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
        FacesContext context = FacesContext.getCurrentInstance();
        solicitud = (Solicitud) context.getExternalContext().getSessionMap().get("solicitud");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("solicitud", solicitud);

        Notificacion notificacion = new Notificacion();
        notificacion.setCorreoDestino(cosmetologaTemporal.getCorreo());
        asuntoNotificacionTemporal = "Nueva Solicitud";
        mensajeNotificacionTemporal = "Hola " + cosmetologaTemporal.getNombreCompleto() + " tienes una solicitud de " + cliente.getNombreCompleto();
        notificacion.setAsunto(asuntoNotificacionTemporal);
        notificacion.setMensaje(mensajeNotificacionTemporal);

        NotificacionDAO notificacionDAO = new NotificacionDAO();
        notificacionDAO.enviarNotificacion(notificacion);

        mensajeAmigable("Solicitud exitosa");

        return RedireccionAsolicitudes;
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

    public void cerrarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            cliente = (Cliente) context.getExternalContext().getSessionMap().get("cliente");

            if (cliente != null) {
                cliente = null;
            }
        } catch (Exception e) {
        }
    }

    // Utilitarios...
    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage("Error", mensaje);
    }

    public List<ServicioPorCosmetologa> onServicioPorCosmetologaChange() {
        ServicioPorCosmetologaDAO servicioPorCosmetologaDAO = new ServicioPorCosmetologaDAO();
        serviciosPorCosmetologa = servicioPorCosmetologaDAO.obtenerTodosLosServiciosDeCosmetologa(solicitud.getIdCosmetologa());
        return serviciosPorCosmetologa;
    }

    public void onPrecioChange() {
        ServicioDAO servicioDAO = new ServicioDAO();
        servicio = servicioDAO.obtenerServicioNombre(solicitud.getIdServicio());
        int precioServicioTemporal = (servicio.getPrecio() * solicitud.getMultiplicador());
        solicitud.setPrecio(precioServicioTemporal);
    }

    public void onRowSelect(SelectEvent event) {
        solicitudSeleccionada = (Solicitud) event.getObject();
    }
}
