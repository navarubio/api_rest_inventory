package com.sismacontab.inventory.models.dto;

/**
 * DTO para el resultado del endpoint de detalle OpenBravo
 */
public class OpenBravoDetalleDTO {

    private Long id;
    private String code;
    private String nombre;
    private Double presentacion;
    private Double cantidad;
    private Double precio;
    private String lote;
    private String fechaFabricacion;
    private String fechaVencimiento;
    private String registroSanit;

    // Constructors
    public OpenBravoDetalleDTO() {}

    public OpenBravoDetalleDTO(Long id, String code, String nombre, Double presentacion, 
                              Double cantidad, Double precio, String lote, 
                              String fechaFabricacion, String fechaVencimiento, String registroSanit) {
        this.id = id;
        this.code = code;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.lote = lote;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.registroSanit = registroSanit;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getRegistroSanit() {
        return registroSanit;
    }

    public void setRegistroSanit(String registroSanit) {
        this.registroSanit = registroSanit;
    }

    @Override
    public String toString() {
        return "OpenBravoDetalleDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", lote='" + lote + '\'' +
                '}';
    }
}