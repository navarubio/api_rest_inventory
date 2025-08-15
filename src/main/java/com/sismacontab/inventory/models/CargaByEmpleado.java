package com.sismacontab.inventory.models;

public class CargaByEmpleado {
    private String operador;
    private Long recordsByUser;
    private Double porcentajeCarga;
    private Double puntuacion;

    // Constructor vacío
    public CargaByEmpleado() {
    }

    // Constructor completo
    public CargaByEmpleado(String operador, Long recordsByUser, Double porcentajeCarga, Double puntuacion) {
        this.operador = operador;
        this.recordsByUser = recordsByUser;
        this.porcentajeCarga = porcentajeCarga;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Long getRecordsByUser() {
        return recordsByUser;
    }

    public void setRecordsByUser(Long recordsByUser) {
        this.recordsByUser = recordsByUser;
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
