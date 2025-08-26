package com.sismacontab.inventory.models.dto;

public class ProductImageUpdateDTO {
    private String rutaImagen;
    private Integer orden;
    private String altText;

    public ProductImageUpdateDTO() {}

    public ProductImageUpdateDTO(String rutaImagen, Integer orden, String altText) {
        this.rutaImagen = rutaImagen;
        this.orden = orden;
        this.altText = altText;
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
