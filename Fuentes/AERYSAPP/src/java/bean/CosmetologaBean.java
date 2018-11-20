/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CosmetologaDAO;
import dao.DuracionYprecioPorTratamientoDAO;
import dao.EstadoDAO;
import dao.SectorDAO;
import dao.SolicitudDAO;
import dao.ServicioDAO;
import dao.ServicioPorCosmetologaDAO;
import domain.Cosmetologa;
import domain.DuracionYprecioPorTratamiento;
import domain.Estado;
import domain.Sector;
import domain.Servicio;
import domain.ServicioPorCosmetologa;
import domain.Solicitud;
import java.io.IOException;
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

/**
 *
 * @author josed
 */
@Named(value = "cosmetologaBean")
@ViewScoped
public class CosmetologaBean implements Serializable {

    String RedireccionDeRegistroCosmetologaAinicioCosmetologa = "registroCosmetologa A inicioCosmetologa";
    String RedireccionAHomeCosmetologa = "homeCosmetologa.xhtml";
    String RedireccionAInicioCosmetologa = "inicioCosmetologa.xhtml";
    String RedireccionAsolicitudes = "solicitudesCosmetologa.xhtml";
    String estadoDeSolicitudTemporal;

    private Cosmetologa cosmetologa;
    private List<Cosmetologa> cosmetologas;

    private CosmetologaDAO cosmetologaDAO = new CosmetologaDAO();

    @ManagedProperty("dao.SolicitudDAO")
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

    private DuracionYprecioPorTratamiento duracionYprecioPorTratamiento = new DuracionYprecioPorTratamiento();
    private List<DuracionYprecioPorTratamiento> duracionYprecioPorTratamientos;

    private Solicitud solicitudSeleccionada;
    private List<Solicitud> solicitudesSeleccionada;

    private ServicioPorCosmetologa servicioPorCosmetologaSeleccionada;

    public CosmetologaBean() {
        solicitudes = new ArrayList<>();
        servicios = new ArrayList<>();
        estados = new ArrayList<>();
        sectores = new ArrayList<>();
        cosmetologas = new ArrayList<>();
        duracionYprecioPorTratamientos = new ArrayList<>();
    }

    @PostConstruct
    public void inicializar() {
        if (cosmetologa == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("correo");
            if (idParam != null && !idParam.equals("")) {
                cosmetologa = cosmetologaDAO.obtenerCosmetologaPorCorreo(idParam);
            }
            if (cosmetologa == null) {
                cosmetologa = new Cosmetologa();
            }
        }
    }

    // Getters y Setters...
    public List<Cosmetologa> getCosmetologas() {
        cosmetologas = cosmetologaDAO.obtenerTodasLasCosmetologas();
        return cosmetologas;
    }

    public void setCosmetologas(List<Cosmetologa> cosmetologas) {
        this.cosmetologas = cosmetologas;
    }

    public ServicioPorCosmetologa getServicioPorCosmetologa() {
        return servicioPorCosmetologa;
    }

    public void setServicioPorCosmetologa(ServicioPorCosmetologa servicioPorCosmetologa) {
        this.servicioPorCosmetologa = servicioPorCosmetologa;
    }

    public List<ServicioPorCosmetologa> getServiciosPorCosmetologa() {
        ServicioPorCosmetologaDAO servicioPorCosmetologaDAO = new ServicioPorCosmetologaDAO();
        serviciosPorCosmetologa = servicioPorCosmetologaDAO.obtenerTodosLosServiciosDeCosmetologa(cosmetologa.getIdCosmetologa());
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
        solicitudes = solicitudDAO.obtenerTodasLasSolicitudesDeCosmetologa(cosmetologa.getIdCosmetologa());
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

    public String getRedireccionDeRegistroCosmetologaAinicioCosmetologa() {
        return RedireccionDeRegistroCosmetologaAinicioCosmetologa;
    }

    public void setRedireccionDeRegistroCosmetologaAinicioCosmetologa(String RedireccionDeRegistroCosmetologaAinicioCosmetologa) {
        this.RedireccionDeRegistroCosmetologaAinicioCosmetologa = RedireccionDeRegistroCosmetologaAinicioCosmetologa;
    }

    public String getRedireccionAHomeCosmetologa() {
        return RedireccionAHomeCosmetologa;
    }

    public void setRedireccionAHomeCosmetologa(String RedireccionAHomeCosmetologa) {
        this.RedireccionAHomeCosmetologa = RedireccionAHomeCosmetologa;
    }

    public String getRedireccionAInicioCosmetologa() {
        return RedireccionAInicioCosmetologa;
    }

    public void setRedireccionAInicioCosmetologa(String RedireccionAInicioCosmetologa) {
        this.RedireccionAInicioCosmetologa = RedireccionAInicioCosmetologa;
    }

    public String getRedireccionAsolicitudes() {
        return RedireccionAsolicitudes;
    }

    public void setRedireccionAsolicitudes(String RedireccionAsolicitudes) {
        this.RedireccionAsolicitudes = RedireccionAsolicitudes;
    }

    public String getEstadoDeSolicitudTemporal() {
        return estadoDeSolicitudTemporal;
    }

    public void setEstadoDeSolicitudTemporal(String estadoDeSolicitudTemporal) {
        this.estadoDeSolicitudTemporal = estadoDeSolicitudTemporal;
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

    public ServicioPorCosmetologa getServicioPorCosmetologaSeleccionada() {
        return servicioPorCosmetologaSeleccionada;
    }

    public void setServicioPorCosmetologaSeleccionada(ServicioPorCosmetologa servicioPorCosmetologaSeleccionada) {
        this.servicioPorCosmetologaSeleccionada = servicioPorCosmetologaSeleccionada;
    }

    // Operaciones de negocio...
    public String registrarMiServicio() {
        ServicioDAO servicioDAO = new ServicioDAO();
        servicio = servicioDAO.obtenerServicioPorId(servicioPorCosmetologa.getIdServicio());
        servicioPorCosmetologa.setNombreServicio(servicio.getNombre());
        servicioPorCosmetologa.setIdCosmetologa(cosmetologa.getIdCosmetologa());
        servicioPorCosmetologa.setNombreCosmetologa(cosmetologa.getNombreCompleto());

        ServicioPorCosmetologaDAO servicioPorCosmetologaDAO = new ServicioPorCosmetologaDAO();
        servicioPorCosmetologaDAO.agregarNuevoServicioPorCosmetologa(servicioPorCosmetologa);
        mensajeAmigable("Servicio registrado");
        return null;
    }

    public String guardarCosmetologa() {
        Cosmetologa cosmetologaTemporal = cosmetologaDAO.obtenerCosmetologaPorCorreo(cosmetologa.getCorreo());
        if (cosmetologaTemporal == null) {

            cosmetologaDAO.agregarNuevaCosmetologa(cosmetologa);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cosmetologa", cosmetologa);
            mensajeAmigable("Bienvenido " + cosmetologa.getNombre() + " a tu tienda spa");
            return RedireccionDeRegistroCosmetologaAinicioCosmetologa;
        } else {
            mensajeError("Este correo ya esta registrado");
            return null;
        }
    }

    public void modificarSolicitud() {
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitudSeleccionada.setIdEstado(estadoDeSolicitudTemporal);
        solicitud = solicitudSeleccionada;
        solicitudDAO.modificarSolicitud(solicitud);
        mensajeAmigable("Solicitud modificada");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("solicitud", solicitud);
    }

    public void aceptarSolicitud() {
        estadoDeSolicitudTemporal = "Aceptado";
        modificarSolicitud();
    }

    public void rechazarSolicitud() {
        estadoDeSolicitudTemporal = "Rechazado";
        modificarSolicitud();
    }

    public void solicitudEnCurso() {
        estadoDeSolicitudTemporal = "En curso";
        modificarSolicitud();
    }

    public void solicitudFinalizado() {
        estadoDeSolicitudTemporal = "Finalizado";
        modificarSolicitud();
    }

    public void modificarCosmetologa() {
        cosmetologaDAO.modificarCosmetologa(cosmetologa);
        mensajeAmigable("Modificacion exitosa");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cosmetologa", cosmetologa);
    }

    public void eliminarServicioDeCosmetologa() {
        ServicioPorCosmetologa servicioTemporal = servicioPorCosmetologaSeleccionada;

        ServicioPorCosmetologaDAO servicioPorCosmetologaDAO = new ServicioPorCosmetologaDAO();
        servicioPorCosmetologaDAO.eliminarServicio(servicioTemporal);

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cosmetologa", cosmetologa);
        mensajeAmigable("Servicio eliminado");

    }

    public void eliminarSolicitudDeCosmetologa() {

        Solicitud solicitudTemporal = solicitudSeleccionada;

        SolicitudDAO solicitudDAO = new SolicitudDAO();
        solicitudDAO.eliminarSolicitud(solicitudTemporal);

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cosmetologa", cosmetologa);
        mensajeAmigable("Solicitud eliminada");

    }

    public String autenticarCosmetologa() {
        boolean busqueda = cosmetologaDAO.AutenticacionDeCosmetologa(cosmetologa.getCorreo(), cosmetologa.getContrasena());
        if (busqueda == true) {
            cosmetologa = cosmetologaDAO.obtenerCosmetologaPorCorreo(cosmetologa.getCorreo());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cosmetologa", cosmetologa);
            mensajeAmigable("Bienvenido " + cosmetologa.getNombre() + " a tu tienda spa");
            return RedireccionAInicioCosmetologa;
        } else {
            mensajeError("Correo o contrasena incorrectos");
            return null;
        }
    }

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            cosmetologa = (Cosmetologa) context.getExternalContext().getSessionMap().get("cosmetologa");

            if (cosmetologa == null) {
                context.getExternalContext().redirect("homeCosmetologa.xhtml");
            }
         } catch (Exception e) {
        }
    }
    
       public void cerrarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            cosmetologa = (Cosmetologa) context.getExternalContext().getSessionMap().get("cosmetologa");

            if (cosmetologa != null) {
                cosmetologa = null;
            }
        } catch (Exception e) {
        }
    }
    // Utilitarios...

    private void mensajeError(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    private void mensajeAmigable(String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
