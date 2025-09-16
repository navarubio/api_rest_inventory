package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "master_lotes", schema = "opensri")
public class MasterLotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "razon_social", columnDefinition = "TEXT")
    private String razonSocial;

    @Column(name = "ruc", columnDefinition = "TEXT")
    private String ruc;

    @Column(name = "numero_factura", columnDefinition = "TEXT")
    private String numeroFactura;

    @Column(name = "razon_social_comprador", columnDefinition = "TEXT")
    private String razonSocialComprador;

    @Column(name = "identificacion_comprador", columnDefinition = "TEXT")
    private String identificacionComprador;

    @Column(name = "fecha_emision", columnDefinition = "TEXT")
    private String fechaEmision;

    @Column(name = "codigo_principal", length = 255)
    private String codigoPrincipal;

    @Column(name = "codigo_auxiliar", length = 255)
    private String codigoAuxiliar;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "cantidad", columnDefinition = "TEXT")
    private String cantidad;

    @Column(name = "descuento", columnDefinition = "TEXT")
    private String descuento;

    @Column(name = "preciototal", columnDefinition = "TEXT")
    private String precioTotal;

    @Column(name = "precio_unitario", columnDefinition = "TEXT")
    private String precioUnitario;

    @Column(name = "lote", columnDefinition = "TEXT")
    private String lote;

    @Column(name = "fecha_fabricacion", columnDefinition = "TEXT")
    private String fechaFabricacion;

    @Column(name = "fecha_vencimiento", columnDefinition = "TEXT")
    private String fechaVencimiento;

    @Column(name = "id_product", length = 100)
    private String idProduct;

    @Column(name = "name_vegfarm", length = 100)
    private String nameVegfarm;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "sincronizacion", length = 50)
    private String sincronizacion;

    @Column(name = "fecha_sincronizacion")
    private LocalDateTime fechaSincronizacion;

    // Constructors
    public MasterLotes() {}

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getRazonSocialComprador() {
        return razonSocialComprador;
    }

    public void setRazonSocialComprador(String razonSocialComprador) {
        this.razonSocialComprador = razonSocialComprador;
    }

    public String getIdentificacionComprador() {
        return identificacionComprador;
    }

    public void setIdentificacionComprador(String identificacionComprador) {
        this.identificacionComprador = identificacionComprador;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }

    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    public void setCodigoAuxiliar(String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameVegfarm() {
        return nameVegfarm;
    }

    public void setNameVegfarm(String nameVegfarm) {
        this.nameVegfarm = nameVegfarm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(String sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public LocalDateTime getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDateTime fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    @Override
    public String toString() {
        return "MasterLotes{" +
                "id=" + id +
                ", razonSocial='" + razonSocial + '\'' +
                ", ruc='" + ruc + '\'' +
                ", numeroFactura='" + numeroFactura + '\'' +
                ", codigoPrincipal='" + codigoPrincipal + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", lote='" + lote + '\'' +
                '}';
    }
}