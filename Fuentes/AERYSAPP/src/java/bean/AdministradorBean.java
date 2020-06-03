/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AdminDAO;
import dao.ClienteDAO;
import dao.CosmetologaDAO;
import dao.EstadoDAO;
import dao.SectorDAO;
import dao.ServicioDAO;
import domain.Admin;
import domain.Cliente;
import domain.Cosmetologa;
import domain.Estado;
import domain.Sector;
import domain.Servicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author josed
 */
@Named(value = "administradorBean")
@ViewScoped
public class AdministradorBean implements Serializable {

    String RedireccionAInicioAdmin = "inicioAdmin.xhtml";

    /**
     * Creates a new instance of AdministradorBean
     */
    public AdministradorBean() {
    }

    private Admin admin;
    private Servicio servicio = new Servicio();
    private Sector sector = new Sector();
    private Estado estado = new Estado();
    private Cliente cliente = new Cliente();
    private Cosmetologa cosmetologa = new Cosmetologa();

    private AdminDAO adminDAO = new AdminDAO();
    private ServicioDAO servicioDAO = new ServicioDAO();
    private SectorDAO sectorDAO = new SectorDAO();
    private EstadoDAO estadoDAO = new EstadoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private CosmetologaDAO cosmetologaDAO = new CosmetologaDAO();

    private List<Sector> sectores;
    private List<Servicio> servicios;
    private List<Estado> estados;
    private List<Cliente> clientes;
    private List<Cosmetologa> cosmetologas;

    private Servicio servicioSeleccionado;
    private Sector sectorSeleccionado;
    private Estado estadoSeleccionado;
    private Cliente clienteSeleccionado;
    private Cosmetologa cosmetologaSeleccionada;

    @PostConstruct
    public void inicializar() {
        if (admin == null) {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String idParam = ctx.getRequestParameterMap().get("correo");
            if (idParam != null && !idParam.equals("")) {
                admin = adminDAO.optenerAdminPorCorreo(idParam);
            }
            if (admin == null) {
                admin = new Admin();
            }
        }
    }

    // Getters y Setters...
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getServicios() {
        servicios = servicioDAO.obtenerTodasLosServicios();
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Servicio getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    public void setServicioSeleccionado(Servicio servicioSeleccionado) {
        this.servicioSeleccionado = servicioSeleccionado;
    }

    public ServicioDAO getServicioDAO() {
        return servicioDAO;
    }

    public void setServicioDAO(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public SectorDAO getSectorDAO() {
        return sectorDAO;
    }

    public void setSectorDAO(SectorDAO sectorDAO) {
        this.sectorDAO = sectorDAO;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Sector> getSectores() {
        sectores = sectorDAO.obtenerTodasLosSectores();
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public Sector getSectorSeleccionado() {
        return sectorSeleccionado;
    }

    public void setSectorSeleccionado(Sector sectorSeleccionado) {
        this.sectorSeleccionado = sectorSeleccionado;
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public List<Estado> getEstados() {
        estados = estadoDAO.obtenerTodasLosEstados();
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
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

    public List<Cliente> getClientes() {
        clientes = clienteDAO.obtenerTodosLosClientes();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
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

    public List<Cosmetologa> getCosmetologas() {
        cosmetologas = cosmetologaDAO.obtenerTodasLasCosmetologas();
        return cosmetologas;
    }

    public void setCosmetologas(List<Cosmetologa> cosmetologas) {
        this.cosmetologas = cosmetologas;
    }

    public Cosmetologa getCosmetologaSeleccionada() {
        return cosmetologaSeleccionada;
    }

    public void setCosmetologaSeleccionada(Cosmetologa cosmetologaSeleccionada) {
        this.cosmetologaSeleccionada = cosmetologaSeleccionada;
    }

    // Operaciones de negocio...
    public void guardarServicio() {
        if ("".equals(servicio.getNombre())) {
            mensajeError("Se requiere un nombre de servicio");
        } else if ("".equals(servicio.getDescripcion())) {
            mensajeError("Se requiere una descripcion de servicio");
        } else if (servicio.getPrecio() == 0) {
            mensajeError("Se requiere un precio de servicio");
        } else {
            servicioDAO.agregarNuevoServicio(servicio);
            mensajeAmigable("Su servicio fue guardado");
        }
    }

    public void eliminarServicio() {
        Servicio servicioTemporal = servicioSeleccionado;
        servicioDAO.eliminarServicio(servicioTemporal);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("servicio", servicio);
    }

    public void guardarSector() {
        if ("".equals(sector.getNombre())) {
            mensajeError("Se requiere un nombre de sector");
        } else if ("".equals(sector.getDescripcion())) {
            mensajeError("Se requiere una descripcion de sector");
        } else {
            sectorDAO.agregarNuevoSector(sector);
            mensajeAmigable("Su servicio fue guardado");
        }
    }

    public void eliminarSector() {
        Sector sectorTemporal = sectorSeleccionado;
        sectorDAO.eliminarSector(sectorTemporal);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sector", sector);
    }

    public void guardarEstado() {
        if ("".equals(estado.getNombre())) {
            mensajeError("Se requiere un nombre de estado");
        } else if ("".equals(estado.getDescripcion())) {
            mensajeError("Se requiere una descripcion de estado");
        } else {
            estadoDAO.agregarNuevoEstado(estado);
            mensajeAmigable("Su estado fue guardado");
        }
    }

    public void eliminarEstado() {
        Estado estadoTemporal = estadoSeleccionado;
        estadoDAO.eliminarServicio(estadoTemporal);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("estado", estado);
    }

    public String autenticarAdmin() {
        boolean busqueda = adminDAO.AutenticacionDeAdmin(admin.getCorreo(), admin.getContrasena());
        if (busqueda == true) {
            admin = adminDAO.optenerAdminPorCorreo(admin.getCorreo());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin", admin);
            mensajeAmigable("Hola administrador");
            return RedireccionAInicioAdmin;
        } else {
            mensajeError("Correo o contrasena incorrectos");
            return null;
        }
    }

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            admin = (Admin) context.getExternalContext().getSessionMap().get("admin");

            if (admin == null) {
                context.getExternalContext().redirect("homeAdministrador.xhtml");
            }
        } catch (Exception e) {
        }
    }

    public void cerrarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            admin = (Admin) context.getExternalContext().getSessionMap().get("admin");

            if (admin != null) {
                admin = null;
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

    public void onRowSelect(SelectEvent event) {
        clienteSeleccionado = (Cliente) event.getObject();
    }

    public void onRowSelectCosmetologa(SelectEvent event) {
        cosmetologaSeleccionada = (Cosmetologa) event.getObject();
    }

    public void onRowSelectServicio(SelectEvent event) {
        servicioSeleccionado = (Servicio) event.getObject();
    }

    public void onRowSelectSector(SelectEvent event) {
        sectorSeleccionado = (Sector) event.getObject();
    }

    public void onRowSelectEstado(SelectEvent event) {
        estadoSeleccionado = (Estado) event.getObject();
    }

}
