package com.sismacontab.inventory.models.dto;

public class ProductoTagDTO {
    private String idProducto;
    private Integer idTag;
    private String nombreTag;

    public ProductoTagDTO(String idProducto, Integer idTag, String nombreTag) {
        this.idProducto = idProducto;
        this.idTag = idTag;
        this.nombreTag = nombreTag;
    }

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

    public String getNombreTag() {
        return nombreTag;
    }

    public void setNombreTag(String nombreTag) {
        this.nombreTag = nombreTag;
    }
}
