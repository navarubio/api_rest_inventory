package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attributeset", schema = "fdw_vegfarm")
public class AttributeSet implements Serializable {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Constructor vacío (requerido por JPA)
    public AttributeSet() {
    }

    // Constructor completo (opcional, útil para pruebas o inicialización)
    public AttributeSet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "AttributeSet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}