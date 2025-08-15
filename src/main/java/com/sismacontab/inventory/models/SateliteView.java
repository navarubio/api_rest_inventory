package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "satelite_view", schema = "fdw_vegfarm")
public class SateliteView implements Serializable {

    @Id
    @Column(name = "idsatelite", length = 100, nullable = false)
    private String idsatelite;

    @Column(name = "local", length = 100)
    private String local;

    @Column(name = "location_name", length = 100)
    private String locationName;

    @Column(name = "laboratorio", length = 100)
    private String laboratorio;

    @Column(name = "product", length = 100)
    private String product;

    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "presentacion")
    private Double presentacion;

    @Column(name = "idlote", length = 100)
    private String idlote;

    @Column(name = "numerolote", length = 100)
    private String numerolote;

    @Column(name = "cantidad_cajas")
    private Integer cantidadCajas;

    @Column(name = "unidades")
    private Double unidades;

    @Column(name = "fechafabricacion")
    private Date fechafabricacion;

    @Column(name = "fechavencimiento")
    private Date fechavencimiento;

    @Column(name = "fechainsert")
    private Date fechainsert;

    @Column(name = "operador", length = 100)
    private String operador;

    // Constructor vacío (requerido por JPA)
    public SateliteView() {
    }

    // Constructor completo (opcional, útil para pruebas o inicialización)
    public SateliteView(String idsatelite, String local, String locationName, String laboratorio, String product, String productName, Double presentacion, String idlote, String numerolote, Integer cantidadCajas, Double unidades, Date fechafabricacion, Date fechavencimiento, Date fechainsert, String operador) {
        this.idsatelite = idsatelite;
        this.local = local;
        this.locationName = locationName;
        this.laboratorio = laboratorio;
        this.product = product;
        this.productName = productName;
        this.presentacion = presentacion;
        this.idlote = idlote;
        this.numerolote = numerolote;
        this.cantidadCajas = cantidadCajas;
        this.unidades = unidades;
        this.fechafabricacion = fechafabricacion;
        this.fechavencimiento = fechavencimiento;
        this.fechainsert = fechainsert;
        this.operador = operador;
    }

    // Getters y Setters
    public String getIdsatelite() {
        return idsatelite;
    }

    public void setIdsatelite(String idsatelite) {
        this.idsatelite = idsatelite;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public String getIdlote() {
        return idlote;
    }

    public void setIdlote(String idlote) {
        this.idlote = idlote;
    }

    public String getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(String numerolote) {
        this.numerolote = numerolote;
    }

    public Integer getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(Integer cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public Double getUnidades() {
        return unidades;
    }

    public void setUnidades(Double unidades) {
        this.unidades = unidades;
    }

    public Date getFechafabricacion() {
        return fechafabricacion;
    }

    public void setFechafabricacion(Date fechafabricacion) {
        this.fechafabricacion = fechafabricacion;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Date getFechainsert() {
        return fechainsert;
    }

    public void setFechainsert(Date fechainsert) {
        this.fechainsert = fechainsert;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    // toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "SateliteView{" +
                "idsatelite='" + idsatelite + '\'' +
                ", local='" + local + '\'' +
                ", locationName='" + locationName + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", product='" + product + '\'' +
                ", productName='" + productName + '\'' +
                ", presentacion=" + presentacion +
                ", idlote='" + idlote + '\'' +
                ", numerolote='" + numerolote + '\'' +
                ", cantidadCajas=" + cantidadCajas +
                ", unidades=" + unidades +
                ", fechafabricacion=" + fechafabricacion +
                ", fechavencimiento=" + fechavencimiento +
                ", fechainsert=" + fechainsert +
                ", operador='" + operador + '\'' +
                '}';
    }
}