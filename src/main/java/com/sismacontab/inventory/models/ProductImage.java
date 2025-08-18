package com.sismacontab.inventory.models;

import javax.persistence.*;

@Entity
@Table(name = "product_images", schema = "fdw_vegfarm")
public class ProductImage {
    
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigo_interno_producto", nullable = false)
    private String codigoInternoProducto;

    @Column(name = "ruta_imagen", nullable = false, columnDefinition = "TEXT")
    private String rutaImagen;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "alt_text")
    private String altText;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoInternoProducto() {
        return codigoInternoProducto;
    }

    public void setCodigoInternoProducto(String codigoInternoProducto) {
        this.codigoInternoProducto = codigoInternoProducto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}