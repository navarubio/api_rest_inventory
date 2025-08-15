package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations", schema = "fdw_vegfarm")
public class Location implements Serializable {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "local", length = 100)
    private String local;

    @Column(name = "tipolocation", length = 1)
    private String tipolocation;

    @Column(name = "localbryfarm", length = 100)
    private String localbryfarm;

    @Column(name = "horario", length = 20)
    private String horario;

    @Column(name = "axis_x")
    private Double axisX;

    @Column(name = "axis_y")
    private Double axisY;

    @Column(name = "tipolocal", length = 100)
    private String tipolocal;

    @Column(name = "idempresa")
    private Integer idempresa;

    @Column(name = "iscallcenter", length = 1)
    private String iscallcenter;

    @Column(name = "supervisor", length = 100)
    private String supervisor;

    @Column(name = "zona", length = 100)
    private String zona;

    // Constructor vacío (requerido por JPA)
    public Location() {
    }

    // Constructor completo (opcional, útil para pruebas o inicialización)
    public Location(String id, String name, String address, String local, String tipolocation, String localbryfarm, String horario, Double axisX, Double axisY, String tipolocal, Integer idempresa, String iscallcenter, String supervisor, String zona) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.local = local;
        this.tipolocation = tipolocation;
        this.localbryfarm = localbryfarm;
        this.horario = horario;
        this.axisX = axisX;
        this.axisY = axisY;
        this.tipolocal = tipolocal;
        this.idempresa = idempresa;
        this.iscallcenter = iscallcenter;
        this.supervisor = supervisor;
        this.zona = zona;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipolocation() {
        return tipolocation;
    }

    public void setTipolocation(String tipolocation) {
        this.tipolocation = tipolocation;
    }

    public String getLocalbryfarm() {
        return localbryfarm;
    }

    public void setLocalbryfarm(String localbryfarm) {
        this.localbryfarm = localbryfarm;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getAxisX() {
        return axisX;
    }

    public void setAxisX(Double axisX) {
        this.axisX = axisX;
    }

    public Double getAxisY() {
        return axisY;
    }

    public void setAxisY(Double axisY) {
        this.axisY = axisY;
    }

    public String getTipolocal() {
        return tipolocal;
    }

    public void setTipolocal(String tipolocal) {
        this.tipolocal = tipolocal;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getIscallcenter() {
        return iscallcenter;
    }

    public void setIscallcenter(String iscallcenter) {
        this.iscallcenter = iscallcenter;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    // toString (opcional, útil para depuración)
    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", local='" + local + '\'' +
                ", tipolocation='" + tipolocation + '\'' +
                ", localbryfarm='" + localbryfarm + '\'' +
                ", horario='" + horario + '\'' +
                ", axisX=" + axisX +
                ", axisY=" + axisY +
                ", tipolocal='" + tipolocal + '\'' +
                ", idempresa=" + idempresa +
                ", iscallcenter='" + iscallcenter + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }
}