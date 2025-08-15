package com.sismacontab.inventory.models;

import java.io.Serializable;

public class ProductByKardex implements Serializable {
    private String codigo;
    private String codigoBarra;
    private String descripcionProducto;
    private Double presentacion;
    private String categoriaName;
    private String reference;
    private String laboratorio;
    private Double costoCompra;
    private Double pvp;
    private String gravamen;

    public ProductByKardex() {}

    public ProductByKardex(String codigo, String codigoBarra, String descripcionProducto, Double presentacion,
                           String categoriaName, String reference, String laboratorio, Double costoCompra,
                           Double pvp, String gravamen) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
        this.descripcionProducto = descripcionProducto;
        this.presentacion = presentacion;
        this.categoriaName = categoriaName;
        this.reference = reference;
        this.laboratorio = laboratorio;
        this.costoCompra = costoCompra;
        this.pvp = pvp;
        this.gravamen = gravamen;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public String getCategoriaName() {
        return categoriaName;
    }

    public void setCategoriaName(String categoriaName) {
        this.categoriaName = categoriaName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public String getGravamen() {
        return gravamen;
    }

    public void setGravamen(String gravamen) {
        this.gravamen = gravamen;
    }
}