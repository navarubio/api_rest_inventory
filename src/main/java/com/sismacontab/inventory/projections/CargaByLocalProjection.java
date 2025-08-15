package com.sismacontab.inventory.projections;

public interface CargaByLocalProjection {
    String getLocalName();
    Long getRecordsByLocal();
    Double getPorcentajeCarga();
    Double getPuntuacion();
}
