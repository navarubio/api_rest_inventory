package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_images_write", schema = "fdw_vegfarm")
@IdClass(ProductImageWriteId.class)
public class ProductImageWrite implements Serializable {

    @Id
    @Column(name = "codigo_interno_producto", nullable = false)
    private String codigoInternoProducto;

    @Id
    @Column(name = "orden")
    private Integer orden;

    @Column(name = "ruta_imagen", nullable = false, columnDefinition = "TEXT")
    private String rutaImagen;

    @Column(name = "alt_text")
    private String altText;

    // Constructors
    public ProductImageWrite() {}

    public ProductImageWrite(String codigoInternoProducto, String rutaImagen, Integer orden, String altText) {
        this.codigoInternoProducto = codigoInternoProducto;
        this.rutaImagen = rutaImagen;
        this.orden = orden;
        this.altText = altText;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "ProductImageWrite{" +
                "codigoInternoProducto='" + codigoInternoProducto + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                ", orden=" + orden +
                ", altText='" + altText + '\'' +
                '}';
    }
}
