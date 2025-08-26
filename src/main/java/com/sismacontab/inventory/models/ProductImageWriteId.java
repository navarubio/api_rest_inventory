package com.sismacontab.inventory.models;

import java.io.Serializable;
import java.util.Objects;

public class ProductImageWriteId implements Serializable {
    
    private String codigoInternoProducto;
    private Integer orden;

    // Constructors
    public ProductImageWriteId() {}

    public ProductImageWriteId(String codigoInternoProducto, Integer orden) {
        this.codigoInternoProducto = codigoInternoProducto;
        this.orden = orden;
    }

    // Getters and Setters
    public String getCodigoInternoProducto() {
        return codigoInternoProducto;
    }

    public void setCodigoInternoProducto(String codigoInternoProducto) {
        this.codigoInternoProducto = codigoInternoProducto;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImageWriteId that = (ProductImageWriteId) o;
        return Objects.equals(codigoInternoProducto, that.codigoInternoProducto) &&
               Objects.equals(orden, that.orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoInternoProducto, orden);
    }

    @Override
    public String toString() {
        return "ProductImageWriteId{" +
                "codigoInternoProducto='" + codigoInternoProducto + '\'' +
                ", orden=" + orden +
                '}';
    }
}
