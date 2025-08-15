package com.sismacontab.inventory.projections;

public interface CargaByEmpleadoProjection {
    String getOperador();
    Long getRecordsByUser();
    Double getPorcentajeCarga();
    Double getPuntuacion();
}