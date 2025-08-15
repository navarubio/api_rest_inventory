package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "people", schema = "openbravo")
public class People implements Serializable {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "apppassword", length = 100)
    private String apppassword;

    @Column(name = "card", length = 100)
    private String card;

    @Column(name = "role", length = 100, nullable = false)
    private String role;

    @Column(name = "visible", nullable = false)
    private Integer visible;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "usuario", length = 100)
    private String usuario;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "local", length = 100)
    private String local;

    @Column(name = "notes_", length = 100)
    private String notes;

    @Column(name = "cedula", length = 100)
    private String cedula;

    @Column(name = "rol_opensri", nullable = false)
    private Integer rolOpensri;

    @Column(name = "idempresa", nullable = false)
    private Integer idempresa;

    @Column(name = "iddepartamento")
    private Integer iddepartamento;

    // Constructor vacío (requerido por JPA)
    public People() {
    }

    // Getters y Setters
    // ... (omitir por brevedad)
}
