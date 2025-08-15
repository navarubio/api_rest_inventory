package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products", schema = "fdw_vegfarm")
public class Product implements Serializable {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "presentacion")
    private Double presentacion;

    @Column(name = "attributeset_id", length = 100)
    private String attributesetId;

    // Constructor vacío (requerido por JPA)
    public Product() {
    }

    // Constructor completo (opcional, útil para pruebas o inicialización)
    public Product(String id, String code, String name, Double presentacion, String attributesetId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.presentacion = presentacion;
        this.attributesetId = attributesetId;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public String getAttributesetId() {
        return attributesetId;
    }

    public void setAttributesetId(String attributesetId) {
        this.attributesetId = attributesetId;
    }

    // toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", presentacion=" + presentacion +
                ", attributesetId='" + attributesetId + '\'' +
                '}';
    }
}