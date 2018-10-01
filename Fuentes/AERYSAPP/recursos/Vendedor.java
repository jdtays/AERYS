package domain;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {
  private int idVendedor;
  private String codigo;
  private String nombre;
  private int salarioBase;
  private double porComision;
  private Date fechaIngreso;
  private boolean activo;
  
  public Vendedor() {}

  public int getIdVendedor() {
    return idVendedor;
  }

  public void setIdVendedor(int idVendedor) {
    this.idVendedor = idVendedor;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(int salarioBase) {
    this.salarioBase = salarioBase;
  }

  public double getPorComision() {
    return porComision;
  }

  public void setPorComision(double porComision) {
    this.porComision = porComision;
  }

  public Date getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(Date fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public boolean isActivo() {
    return activo;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
  }
  
}
