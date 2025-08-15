package com.sismacontab.inventory.models;

import java.io.Serializable;
import java.util.Objects;

public class DetallePedidoOptimusId implements Serializable {
    private Integer ticketid;
    private String productoId;
    private String codigoLocal;

    // Getters, setters, equals y hashCode

    public Integer getTicketid() { return ticketid; }
    public void setTicketid(Integer ticketid) { this.ticketid = ticketid; }

    public String getProductoId() { return productoId; }
    public void setProductoId(String productoId) { this.productoId = productoId; }

    public String getCodigoLocal() { return codigoLocal; }
    public void setCodigoLocal(String codigoLocal) { this.codigoLocal = codigoLocal; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePedidoOptimusId)) return false;
        DetallePedidoOptimusId that = (DetallePedidoOptimusId) o;
        return Objects.equals(ticketid, that.ticketid) &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(codigoLocal, that.codigoLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketid, productoId, codigoLocal);
    }
}