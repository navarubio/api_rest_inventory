package com.sismacontab.inventory.models;

import javax.persistence.*;

@Entity
@Table(name = "general_pedidos_despachados", schema = "fdw_vegfarm")
public class GeneralPedidosDespachados {

    @Id
    @Column(name = "ticketid")
    private Integer ticketid;

    @Column(name = "fecha_calculo_pedido")
    private String fechaCalculoPedido;

    @Column(name = "local_salida")
    private String localSalida;

    @Column(name = "local_destino")
    private String localDestino;

    @Column(name = "estado_fase_despacho")
    private String estadoFaseDespacho;

    // Getters y Setters

    public Integer getTicketid() { return ticketid; }
    public void setTicketid(Integer ticketid) { this.ticketid = ticketid; }

    public String getFechaCalculoPedido() { return fechaCalculoPedido; }
    public void setFechaCalculoPedido(String fechaCalculoPedido) { this.fechaCalculoPedido = fechaCalculoPedido; }

    public String getLocalSalida() { return localSalida; }
    public void setLocalSalida(String localSalida) { this.localSalida = localSalida; }

    public String getLocalDestino() { return localDestino; }
    public void setLocalDestino(String localDestino) { this.localDestino = localDestino; }

    public String getEstadoFaseDespacho() { return estadoFaseDespacho; }
    public void setEstadoFaseDespacho(String estadoFaseDespacho) { this.estadoFaseDespacho = estadoFaseDespacho; }
}