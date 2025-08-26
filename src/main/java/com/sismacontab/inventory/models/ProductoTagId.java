package com.sismacontab.inventory.models;

import java.io.Serializable;
import java.util.Objects;

public class ProductoTagId implements Serializable {
    
    private String idProducto;
    private Integer idTag;

    public ProductoTagId() {
    }

    public ProductoTagId(String idProducto, Integer idTag) {
        this.idProducto = idProducto;
        this.idTag = idTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoTagId that = (ProductoTagId) o;
        return Objects.equals(idProducto, that.idProducto) &&
               Objects.equals(idTag, that.idTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idTag);
    }
}
