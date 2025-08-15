package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proveedor", schema = "fdw_vegfarm")
public class Proveedor implements Serializable {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "searchkey", length = 100)
    private String searchkey;

    @Column(name = "taxid", length = 100)
    private String taxid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "tipoidentificacion", length = 2, nullable = false)
    private String tipoidentificacion;

    // Constructor vacío (requerido por JPA)
    public Proveedor() {
    }

    // Constructor completo (opcional, útil para pruebas o inicialización)
    public Proveedor(String id, String searchkey, String taxid, String name, String tipoidentificacion) {
        this.id = id;
        this.searchkey = searchkey;
        this.taxid = taxid;
        this.name = name;
        this.tipoidentificacion = tipoidentificacion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipoidentificacion() {
        return tipoidentificacion;
    }

    public void setTipoidentificacion(String tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }

    // toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "Proveedor{" +
                "id='" + id + '\'' +
                ", searchkey='" + searchkey + '\'' +
                ", taxid='" + taxid + '\'' +
                ", name='" + name + '\'' +
                ", tipoidentificacion='" + tipoidentificacion + '\'' +
                '}';
    }
}