package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "producto_tags", schema = "fdw_vegfarm")
@IdClass(ProductoTagId.class)
public class ProductoTag {
    
    @Id
    @Column(name = "id_producto", nullable = false, length = 100)
    private String idProducto;
    
    @Id
    @Column(name = "id_tag", nullable = false)
    private Integer idTag;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "codigo_interno", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductCategorizacion producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tag", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tag tag;

    // Getters and Setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public ProductCategorizacion getProducto() {
        return producto;
    }

    public void setProducto(ProductCategorizacion producto) {
        this.producto = producto;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
