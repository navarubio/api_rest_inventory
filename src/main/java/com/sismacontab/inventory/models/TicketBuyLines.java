package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticketbuylines", schema = "fdw_vegfarm")
@IdClass(TicketBuyLinesId.class)
public class TicketBuyLines implements Serializable {

    @Id
    @Column(name = "ticket", nullable = false, length = 100)
    private String ticket;

    @Id
    @Column(name = "line", nullable = false)
    private Double line;

    @Column(name = "product", nullable = false, length = 100)
    private String product;

    @Column(name = "units", nullable = false)
    private Double units;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "taxid", nullable = false, length = 100)
    private String taxid;

    @Column(name = "attributes")
    private byte[] attributes;

    @Column(name = "attributesetinstance_id", length = 100)
    private String attributesetinstanceId;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "pricebuy")
    private Double pricebuy;

    @Column(name = "serial", length = 100)
    private String serial;

    @Column(name = "medidacompra", length = 100)
    private String medidacompra;

    @Column(name = "medidacontrol", length = 100)
    private String medidacontrol;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "presentacion")
    private Double presentacion;

    @Column(name = "preciopresentacion")
    private Double preciopresentacion;

    @Column(name = "unitsfraccion")
    private Double unitsfraccion;

    @Column(name = "impuesto")
    private Double impuesto;

    @Column(name = "priceneto")
    private Double priceneto;

    @Column(name = "reason")
    private Double reason;

    @Column(name = "unitsbonificacion", nullable = false)
    private Double unitsbonificacion;

    @Column(name = "pvpfinal")
    private Double pvpfinal;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "stockbodega")
    private Double stockbodega;

    @Column(name = "stocklocal")
    private Double stocklocal;

    @Column(name = "namelaboratorio", length = 100)
    private String namelaboratorio;

    @Column(name = "secuencia_")
    private Double secuencia;

    @Column(name = "lote", length = 100)
    private String lote;

    @Column(name = "registrosanitario", length = 100)
    private String registrosanitario;

    @Column(name = "fechaelaboracion", length = 100)
    private String fechaelaboracion;

    @Column(name = "fechavencimiento", length = 100)
    private String fechavencimiento;

    @Column(name = "refrigeracion", length = 100)
    private String refrigeracion;

    @Column(name = "idlote", length = 100)
    private String idlote;

    // Constructors
    public TicketBuyLines() {}

    // Getters and Setters
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getLine() {
        return line;
    }

    public void setLine(Double line) {
        this.line = line;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public byte[] getAttributes() {
        return attributes;
    }

    public void setAttributes(byte[] attributes) {
        this.attributes = attributes;
    }

    public String getAttributesetinstanceId() {
        return attributesetinstanceId;
    }

    public void setAttributesetinstanceId(String attributesetinstanceId) {
        this.attributesetinstanceId = attributesetinstanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPricebuy() {
        return pricebuy;
    }

    public void setPricebuy(Double pricebuy) {
        this.pricebuy = pricebuy;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMedidacompra() {
        return medidacompra;
    }

    public void setMedidacompra(String medidacompra) {
        this.medidacompra = medidacompra;
    }

    public String getMedidacontrol() {
        return medidacontrol;
    }

    public void setMedidacontrol(String medidacontrol) {
        this.medidacontrol = medidacontrol;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Double presentacion) {
        this.presentacion = presentacion;
    }

    public Double getPreciopresentacion() {
        return preciopresentacion;
    }

    public void setPreciopresentacion(Double preciopresentacion) {
        this.preciopresentacion = preciopresentacion;
    }

    public Double getUnitsfraccion() {
        return unitsfraccion;
    }

    public void setUnitsfraccion(Double unitsfraccion) {
        this.unitsfraccion = unitsfraccion;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getPriceneto() {
        return priceneto;
    }

    public void setPriceneto(Double priceneto) {
        this.priceneto = priceneto;
    }

    public Double getReason() {
        return reason;
    }

    public void setReason(Double reason) {
        this.reason = reason;
    }

    public Double getUnitsbonificacion() {
        return unitsbonificacion;
    }

    public void setUnitsbonificacion(Double unitsbonificacion) {
        this.unitsbonificacion = unitsbonificacion;
    }

    public Double getPvpfinal() {
        return pvpfinal;
    }

    public void setPvpfinal(Double pvpfinal) {
        this.pvpfinal = pvpfinal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getStockbodega() {
        return stockbodega;
    }

    public void setStockbodega(Double stockbodega) {
        this.stockbodega = stockbodega;
    }

    public Double getStocklocal() {
        return stocklocal;
    }

    public void setStocklocal(Double stocklocal) {
        this.stocklocal = stocklocal;
    }

    public String getNamelaboratorio() {
        return namelaboratorio;
    }

    public void setNamelaboratorio(String namelaboratorio) {
        this.namelaboratorio = namelaboratorio;
    }

    public Double getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Double secuencia) {
        this.secuencia = secuencia;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getRegistrosanitario() {
        return registrosanitario;
    }

    public void setRegistrosanitario(String registrosanitario) {
        this.registrosanitario = registrosanitario;
    }

    public String getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(String fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(String refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public String getIdlote() {
        return idlote;
    }

    public void setIdlote(String idlote) {
        this.idlote = idlote;
    }

    @Override
    public String toString() {
        return "TicketBuyLines{" +
                "ticket='" + ticket + '\'' +
                ", line=" + line +
                ", product='" + product + '\'' +
                ", units=" + units +
                ", price=" + price +
                ", pricebuy=" + pricebuy +
                ", lote='" + lote + '\'' +
                ", fechaelaboracion='" + fechaelaboracion + '\'' +
                ", fechavencimiento='" + fechavencimiento + '\'' +
                '}';
    }
}