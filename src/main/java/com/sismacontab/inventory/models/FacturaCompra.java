package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "facturacompra", schema = "opensri")
public class FacturaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfacturacompra")
    private Integer idFacturaCompra;

    @Column(name = "idcompra")
    private Integer idCompra;

    @Column(name = "fecharegistro")
    private LocalDate fechaRegistro;

    @Column(name = "idproveedor", nullable = false, length = 100)
    private String idProveedor;

    @Column(name = "razonsocial", nullable = false)
    private String razonSocial;

    @Column(name = "fechafactura", nullable = false)
    private LocalDate fechaFactura;

    @Column(name = "fechavencimientofact", nullable = false)
    private LocalDate fechaVencimientoFact;

    @Column(name = "local", length = 5)
    private String local;

    @Column(name = "punto", length = 5)
    private String punto;

    @Column(name = "secuencia", length = 10)
    private String secuencia;

    @Column(name = "numerofactura", length = 20)
    private String numeroFactura;

    @Column(name = "tipoemision", length = 1)
    private String tipoEmision;

    @Column(name = "tipodocumento", length = 2)
    private String tipoDocumento;

    @Column(name = "autorizacion", length = 50)
    private String autorizacion;

    @Column(name = "fechaautorizacion")
    private LocalDate fechaAutorizacion;

    @Column(name = "fechavencimientodoc")
    private LocalDate fechaVencimientoDoc;

    @Column(name = "subtotal12")
    private Double subtotal12 = 0.0;

    @Column(name = "subtotal0")
    private Double subtotal0 = 0.0;

    @Column(name = "subtotalnoobjeto")
    private Double subtotalNoObjeto = 0.0;

    @Column(name = "subtotalexcento")
    private Double subtotalExcento = 0.0;

    @Column(name = "subtotalsinimpu")
    private Double subtotalSinImpu = 0.0;

    @Column(name = "totaldescuento")
    private Double totalDescuento = 0.0;

    @Column(name = "ice")
    private Double ice = 0.0;

    @Column(name = "iva12")
    private Double iva12 = 0.0;

    @Column(name = "irbnpr")
    private Double irbnpr = 0.0;

    @Column(name = "propina")
    private Double propina = 0.0;

    @Column(name = "valortotal")
    private Double valorTotal = 0.0;

    @Column(name = "idempresa")
    private Integer idEmpresa;

    @Column(name = "secuenciafactura")
    private Integer secuenciaFactura;

    @Column(name = "estatusfactura")
    private Integer estatusFactura;

    @Column(name = "aretener")
    private Integer aRetener = 1;

    @Column(name = "contribuespecial", length = 5)
    private String contribuEspecial;

    @Column(name = "obligadocontab", length = 2)
    private String obligadoContab;

    @Column(name = "idcodigosustento")
    private Integer idCodigoSustento;

    @Column(name = "path_xml")
    private String pathXml;

    @Column(name = "path_pdf")
    private String pathPdf;

    @Column(name = "totalretencioniva")
    private Double totalRetencionIva = 0.0;

    @Column(name = "totalretencionfuente")
    private Double totalRetencionFuente = 0.0;

    @Column(name = "totalnotacredito")
    private Double totalNotaCredito = 0.0;

    @Column(name = "totalanticipo")
    private Double totalAnticipo = 0.0;

    @Column(name = "totalapagar")
    private Double totalAPagar = 0.0;

    @Column(name = "idlibrodiario")
    private Integer idLibroDiario;

    @Column(name = "idusuario")
    private String idUsuario;

    @Column(name = "auditoria_fecha_insert")
    private String auditoriaFechaInsert;

    @Column(name = "auditoria_idusuario_update")
    private String auditoriaIdUsuarioUpdate;

    @Column(name = "auditoria_fecha_update")
    private String auditoriaFechaUpdate;

    @Column(name = "formapago", length = 2)
    private String formaPago;

    @Column(name = "pendiente")
    private Double pendiente = 0.0;

    @Column(name = "abonado")
    private Double abonado = 0.0;

    @Column(name = "excel_upload")
    private Integer excelUpload;

    @Column(name = "totalpolux")
    private Double totalPolux;

    @Column(name = "idproceso")
    private String idProceso;

    @Column(name = "auditoria_idusuario_delete_update")
    private String auditoriaIdUsuarioDeleteUpdate;

    @Column(name = "auditoria_fecha_delete_update")
    private String auditoriaFechaDeleteUpdate;

    @Column(name = "estatusaf")
    private Integer estatusAf;

    // Constructors
    public FacturaCompra() {}

    // Getters and Setters
    public Integer getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public LocalDate getFechaVencimientoFact() {
        return fechaVencimientoFact;
    }

    public void setFechaVencimientoFact(LocalDate fechaVencimientoFact) {
        this.fechaVencimientoFact = fechaVencimientoFact;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(String tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public LocalDate getFechaVencimientoDoc() {
        return fechaVencimientoDoc;
    }

    public void setFechaVencimientoDoc(LocalDate fechaVencimientoDoc) {
        this.fechaVencimientoDoc = fechaVencimientoDoc;
    }

    public Double getSubtotal12() {
        return subtotal12;
    }

    public void setSubtotal12(Double subtotal12) {
        this.subtotal12 = subtotal12;
    }

    public Double getSubtotal0() {
        return subtotal0;
    }

    public void setSubtotal0(Double subtotal0) {
        this.subtotal0 = subtotal0;
    }

    public Double getSubtotalNoObjeto() {
        return subtotalNoObjeto;
    }

    public void setSubtotalNoObjeto(Double subtotalNoObjeto) {
        this.subtotalNoObjeto = subtotalNoObjeto;
    }

    public Double getSubtotalExcento() {
        return subtotalExcento;
    }

    public void setSubtotalExcento(Double subtotalExcento) {
        this.subtotalExcento = subtotalExcento;
    }

    public Double getSubtotalSinImpu() {
        return subtotalSinImpu;
    }

    public void setSubtotalSinImpu(Double subtotalSinImpu) {
        this.subtotalSinImpu = subtotalSinImpu;
    }

    public Double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public Double getIce() {
        return ice;
    }

    public void setIce(Double ice) {
        this.ice = ice;
    }

    public Double getIva12() {
        return iva12;
    }

    public void setIva12(Double iva12) {
        this.iva12 = iva12;
    }

    public Double getIrbnpr() {
        return irbnpr;
    }

    public void setIrbnpr(Double irbnpr) {
        this.irbnpr = irbnpr;
    }

    public Double getPropina() {
        return propina;
    }

    public void setPropina(Double propina) {
        this.propina = propina;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getSecuenciaFactura() {
        return secuenciaFactura;
    }

    public void setSecuenciaFactura(Integer secuenciaFactura) {
        this.secuenciaFactura = secuenciaFactura;
    }

    public Integer getEstatusFactura() {
        return estatusFactura;
    }

    public void setEstatusFactura(Integer estatusFactura) {
        this.estatusFactura = estatusFactura;
    }

    public Integer getaRetener() {
        return aRetener;
    }

    public void setaRetener(Integer aRetener) {
        this.aRetener = aRetener;
    }

    public String getContribuyEspecial() {
        return contribuEspecial;
    }

    public void setContribuyEspecial(String contribuEspecial) {
        this.contribuEspecial = contribuEspecial;
    }

    public String getObligadoContab() {
        return obligadoContab;
    }

    public void setObligadoContab(String obligadoContab) {
        this.obligadoContab = obligadoContab;
    }

    public Integer getIdCodigoSustento() {
        return idCodigoSustento;
    }

    public void setIdCodigoSustento(Integer idCodigoSustento) {
        this.idCodigoSustento = idCodigoSustento;
    }

    public String getPathXml() {
        return pathXml;
    }

    public void setPathXml(String pathXml) {
        this.pathXml = pathXml;
    }

    public String getPathPdf() {
        return pathPdf;
    }

    public void setPathPdf(String pathPdf) {
        this.pathPdf = pathPdf;
    }

    public Double getTotalRetencionIva() {
        return totalRetencionIva;
    }

    public void setTotalRetencionIva(Double totalRetencionIva) {
        this.totalRetencionIva = totalRetencionIva;
    }

    public Double getTotalRetencionFuente() {
        return totalRetencionFuente;
    }

    public void setTotalRetencionFuente(Double totalRetencionFuente) {
        this.totalRetencionFuente = totalRetencionFuente;
    }

    public Double getTotalNotaCredito() {
        return totalNotaCredito;
    }

    public void setTotalNotaCredito(Double totalNotaCredito) {
        this.totalNotaCredito = totalNotaCredito;
    }

    public Double getTotalAnticipo() {
        return totalAnticipo;
    }

    public void setTotalAnticipo(Double totalAnticipo) {
        this.totalAnticipo = totalAnticipo;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public Integer getIdLibroDiario() {
        return idLibroDiario;
    }

    public void setIdLibroDiario(Integer idLibroDiario) {
        this.idLibroDiario = idLibroDiario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAuditoriaFechaInsert() {
        return auditoriaFechaInsert;
    }

    public void setAuditoriaFechaInsert(String auditoriaFechaInsert) {
        this.auditoriaFechaInsert = auditoriaFechaInsert;
    }

    public String getAuditoriaIdUsuarioUpdate() {
        return auditoriaIdUsuarioUpdate;
    }

    public void setAuditoriaIdUsuarioUpdate(String auditoriaIdUsuarioUpdate) {
        this.auditoriaIdUsuarioUpdate = auditoriaIdUsuarioUpdate;
    }

    public String getAuditoriaFechaUpdate() {
        return auditoriaFechaUpdate;
    }

    public void setAuditoriaFechaUpdate(String auditoriaFechaUpdate) {
        this.auditoriaFechaUpdate = auditoriaFechaUpdate;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Double getPendiente() {
        return pendiente;
    }

    public void setPendiente(Double pendiente) {
        this.pendiente = pendiente;
    }

    public Double getAbonado() {
        return abonado;
    }

    public void setAbonado(Double abonado) {
        this.abonado = abonado;
    }

    public Integer getExcelUpload() {
        return excelUpload;
    }

    public void setExcelUpload(Integer excelUpload) {
        this.excelUpload = excelUpload;
    }

    public Double getTotalPolux() {
        return totalPolux;
    }

    public void setTotalPolux(Double totalPolux) {
        this.totalPolux = totalPolux;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getAuditoriaIdUsuarioDeleteUpdate() {
        return auditoriaIdUsuarioDeleteUpdate;
    }

    public void setAuditoriaIdUsuarioDeleteUpdate(String auditoriaIdUsuarioDeleteUpdate) {
        this.auditoriaIdUsuarioDeleteUpdate = auditoriaIdUsuarioDeleteUpdate;
    }

    public String getAuditoriaFechaDeleteUpdate() {
        return auditoriaFechaDeleteUpdate;
    }

    public void setAuditoriaFechaDeleteUpdate(String auditoriaFechaDeleteUpdate) {
        this.auditoriaFechaDeleteUpdate = auditoriaFechaDeleteUpdate;
    }

    public Integer getEstatusAf() {
        return estatusAf;
    }

    public void setEstatusAf(Integer estatusAf) {
        this.estatusAf = estatusAf;
    }

    @Override
    public String toString() {
        return "FacturaCompra{" +
                "idFacturaCompra=" + idFacturaCompra +
                ", idProveedor='" + idProveedor + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", fechaFactura=" + fechaFactura +
                ", numeroFactura='" + numeroFactura + '\'' +
                ", autorizacion='" + autorizacion + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}