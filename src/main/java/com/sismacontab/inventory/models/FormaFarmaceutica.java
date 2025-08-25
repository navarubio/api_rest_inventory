package com.sismacontab.inventory.models;

import javax.persistence.*;

@Entity
@Table(name = "maestro_formas_farmaceuticas", schema = "fdw_vegfarm")
public class FormaFarmaceutica {
    @Id
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column
    private String descripcion;
    
    @Column(nullable = false)
    private Boolean activo;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
