package com.sismacontab.inventory.models;

public class CargaByLocal {
    private String localName;
    private Long recordsByLocal;
    private Double porcentajeCarga;
    private Double puntuacion;

    // Constructor vacío
    public CargaByLocal() {
    }

    // Constructor completo
    public CargaByLocal(String localName, Long recordsByLocal, Double porcentajeCarga, Double puntuacion) {
        this.localName = localName;
        this.recordsByLocal = recordsByLocal;
        this.porcentajeCarga = porcentajeCarga;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Long getRecordsByLocal() {
        return recordsByLocal;
    }

    public void setRecordsByLocal(Long recordsByLocal) {
        this.recordsByLocal = recordsByLocal;
    }

    public Double getPorcentajeCarga() {
        return porcentajeCarga;
    }

    public void setPorcentajeCarga(Double porcentajeCarga) {
        this.porcentajeCarga = porcentajeCarga;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
