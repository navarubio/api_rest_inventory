package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable // Opcional, para indicar que es una vista de solo lectura
@Table(name = "detalle_pedido_optimus_complete", schema = "fdw_vegfarm")
@IdClass(DetallePedidoOptimusId.class)
public class DetallePedidoOptimus {

    @Id
    @Column(name = "ticketid")
    private Integer ticketid;

    @Id
    @Column(name = "producto_id")
    private String productoId;

    @Id
    @Column(name = "codigo_local")
    private String codigoLocal;

    @Column(name = "fecha_calculo_formato")
    private String fechaCalculoFormato;

    @Column(name = "nombre_local")
    private String nombreLocal;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "nombre_laboratorio")
    private String nombreLaboratorio;

    @Column(name = "cantidad_optima_requerida")
    private Double cantidadOptimaRequerida;

    @Column(name = "cantidad_despacha_bodega")
    private Double cantidadDespachaBodega;

    @Column(name = "cantidad_faltante")
    private Double cantidadFaltante;

    @Column(name = "stock_bodega_momento_calculo")
    private Double stockBodegaMomentoCalculo;

    @Column(name = "stock_local_momento_calculo")
    private Double stockLocalMomentoCalculo;

    @Column(name = "wma_demanda_packs")
    private Double wmaDemandaPacks;

    @Column(name = "estado_registro")
    private String estadoRegistro;

    @Column(name = "factores_calculo_aplicados")
    private String factoresCalculoAplicados;

    @Column(name = "precio_compra_por_unidad_base")
    @JsonProperty("precioCompraPorUnidadBase")
    private Double precioCompraPorUnidadBase;

    @Column(name = "presentacion")
    @JsonProperty("presentacion")
    private Double presentacion;

    @Column(name = "referencias_ultimas_compras")
    @JsonProperty("referenciasUltimasCompras")
    private String referenciasUltimasCompras;

    // Nuevos campos para información de impuestos
    @Column(name = "tax_id")
    @JsonProperty("taxId")
    private String taxId;

    @Column(name = "tax_rate")
    @JsonProperty("taxRate")
    private Double taxRate;

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getFechaCalculoFormato() {
        return fechaCalculoFormato;
    }

    public void setFechaCalculoFormato(String fechaCalculoFormato) {
        this.fechaCalculoFormato = fechaCalculoFormato;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public Double getCantidadOptimaRequerida() {
        return cantidadOptimaRequerida;
    }

    public void setCantidadOptimaRequerida(Double cantidadOptimaRequerida) {
        this.cantidadOptimaRequerida = cantidadOptimaRequerida;
    }

    public Double getCantidadDespachaBodega() {
        return cantidadDespachaBodega;
    }

    public void setCantidadDespachaBodega(Double cantidadDespachaBodega) {
        this.cantidadDespachaBodega = cantidadDespachaBodega;
    }

    public Double getCantidadFaltante() {
        return cantidadFaltante;
    }

    public void setCantidadFaltante(Double cantidadFaltante) {
        this.cantidadFaltante = cantidadFaltante;
    }

    public Double getStockBodegaMomentoCalculo() {
        return stockBodegaMomentoCalculo;
    }

    public void setStockBodegaMomentoCalculo(Double stockBodegaMomentoCalculo) {
        this.stockBodegaMomentoCalculo = stockBodegaMomentoCalculo;
    }

    public Double getStockLocalMomentoCalculo() {
        return stockLocalMomentoCalculo;
    }

    public void setStockLocalMomentoCalculo(Double stockLocalMomentoCalculo) {
        this.stockLocalMomentoCalculo = stockLocalMomentoCalculo;
    }

    public Double getWmaDemandaPacks() {
        return wmaDemandaPacks;
    }

    public void setWmaDemandaPacks(Double wmaDemandaPacks) {
        this.wmaDemandaPacks = wmaDemandaPacks;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getFactoresCalculoAplicados() {
        return factoresCalculoAplicados;
    }

    public void setFactoresCalculoAplicados(String factoresCalculoAplicados) {
        this.factoresCalculoAplicados = factoresCalculoAplicados;
    }

    public Double getPrecioCompraPorUnidadBase() {
        return precioCompraPorUnidadBase;
    }

    public void setPrecioCompraPorUnidadBase(Double precioCompraPorUnidadBase) {
        this.precioCompraPorUnidadBase = precioCompraPorUnidadBase;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public String getReferenciasUltimasCompras() {
        return referenciasUltimasCompras;
    }

    public void setReferenciasUltimasCompras(String referenciasUltimasCompras) {
        this.referenciasUltimasCompras = referenciasUltimasCompras;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}