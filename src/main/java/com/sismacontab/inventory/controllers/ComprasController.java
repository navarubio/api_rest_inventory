package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.MasterLotes;
import com.sismacontab.inventory.repositories.FacturaCompraRepository;
import com.sismacontab.inventory.repositories.MasterLotesRepository;
import com.sismacontab.inventory.repositories.TicketBuyLinesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador para endpoints de análisis de compras
 * Maneja la comparación entre datos del XML y OpenBravo
 */
@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    private final FacturaCompraRepository facturaCompraRepository;
    private final MasterLotesRepository masterLotesRepository;
    private final TicketBuyLinesRepository ticketBuyLinesRepository;

    public ComprasController(FacturaCompraRepository facturaCompraRepository,
                           MasterLotesRepository masterLotesRepository,
                           TicketBuyLinesRepository ticketBuyLinesRepository) {
        this.facturaCompraRepository = facturaCompraRepository;
        this.masterLotesRepository = masterLotesRepository;
        this.ticketBuyLinesRepository = ticketBuyLinesRepository;
    }

    /**
     * @api {get} /api/compras/proveedores Get Unique Supplier List
     * @apiName GetUniqueSuppliers
     * @apiGroup Compras
     *
     * @apiSuccess {String[]} suppliers List of unique supplier strings in 'id-name' format.
     * 
     * @apiDescription Retrieves a unique list of suppliers with '06' support code invoices.
     * It groups by supplier ID (RUC) and selects the most recent company name to avoid duplicates
     * caused by minor variations in the name.
     * The SQL query uses a CTE (Common Table Expression) to rank suppliers by most recent invoice
     * and applies INITCAP and TRIM for name normalization.
     */
    @GetMapping("/proveedores")
    public ResponseEntity<List<String>> getSuppliers() {
        try {
            List<String> suppliers = facturaCompraRepository.findSuppliersByCodigoSustento();
            return ResponseEntity.ok(suppliers);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(java.util.Arrays.asList("Error fetching suppliers: " + e.getMessage()));
        }
    }

    /**
     * @api {get} /api/compras/facturas Get Invoices
     * @apiName GetInvoices
     * @apiGroup Compras
     *
     * @apiParam {String} fechaInicio Start date (YYYY-MM-DD)
     * @apiParam {String} fechaFin End date (YYYY-MM-DD)
     * @apiParam {String} [proveedorId] Supplier ID (optional)
     *
     * @apiSuccess {Object[]} invoices List of invoices
     * @apiSuccess {String} invoices.fechaFactura Invoice date
     * @apiSuccess {String} invoices.idProveedor Supplier ID
     * @apiSuccess {String} invoices.razonSocial Supplier name
     * @apiSuccess {String} invoices.numeroFactura Invoice number
     * @apiSuccess {String} invoices.autorizacion Authorization
     */
    @GetMapping("/facturas")
    public ResponseEntity<?> getInvoices(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam(required = false) String proveedorId) {
        
        if (fechaInicio == null || fechaFin == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Missing required query parameters: fechaInicio, fechaFin");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(fechaInicio, formatter);
            LocalDate endDate = LocalDate.parse(fechaFin, formatter);

            List<Object[]> results;
            
            if (proveedorId != null && !proveedorId.trim().isEmpty()) {
                // Si se proporciona proveedorId, buscar facturas de ese proveedor específico
                results = facturaCompraRepository.findFacturasByProveedorAndDateRange(
                        startDate, endDate, proveedorId);
            } else {
                // Si NO se proporciona proveedorId, buscar todas las facturas con sustento '06'
                results = facturaCompraRepository.findFacturasBySustentoAndDateRange(
                        startDate, endDate);
            }

            List<Map<String, Object>> invoices = new ArrayList<>();
            for (Object[] row : results) {
                Map<String, Object> invoice = new HashMap<>();
                invoice.put("fechaFactura", row[0] != null ? row[0].toString() : null);
                invoice.put("idProveedor", row[1]);
                invoice.put("razonSocial", row[2]);
                invoice.put("numeroFactura", row[3]);
                invoice.put("autorizacion", row[4]);
                invoices.add(invoice);
            }

            return ResponseEntity.ok(invoices);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error fetching invoices: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }

    /**
     * @api {get} /api/compras/detalle-xml Get Invoice Details from XML
     * @apiName GetXMLDetails
     * @apiGroup Compras
     *
     * @apiParam {String} ruc Supplier RUC
     * @apiParam {String} numeroFactura Invoice number
     *
     * @apiSuccess {Object[]} products List of products from XML
     */
    @GetMapping("/detalle-xml")
    public ResponseEntity<?> getXMLDetails(
            @RequestParam String ruc,
            @RequestParam String numeroFactura) {

        if (ruc == null || numeroFactura == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Missing required query parameters: ruc, numeroFactura");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            List<MasterLotes> xmlDetails = masterLotesRepository.findByRucAndNumeroFactura(ruc, numeroFactura);
            return ResponseEntity.ok(xmlDetails);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error fetching XML details: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }

    /**
     * @api {get} /api/compras/detalle-openbravo Get Invoice Details from OpenBravo
     * @apiName GetOpenBravoDetails
     * @apiGroup Compras
     *
     * @apiParam {String} ruc Supplier RUC
     * @apiParam {String} numeroFactura Invoice number (format: xxx-xxx-xxxxxxxxx)
     *
     * @apiSuccess {Object[]} products List of products from OpenBravo with complete data
     * @apiSuccess {Number} products.ID Row number
     * @apiSuccess {String} products.Numero_Factura Complete invoice number
     * @apiSuccess {String} products.Fecha_Factura Invoice date
     * @apiSuccess {String} products.RUC Supplier RUC
     * @apiSuccess {String} products.Laboratorio Laboratory/supplier name
     * @apiSuccess {String} products.Code Product code
     * @apiSuccess {String} products.Nombre Product name
     * @apiSuccess {String} products.Lote Batch number
     * @apiSuccess {Number} products.Cantidad Quantity
     * @apiSuccess {String} products.Presentacion Presentation
     * @apiSuccess {String} products.Registro_Sanitario Sanitary registration
     * @apiSuccess {String} products.Fecha_Elaboracion Manufacturing date
     * @apiSuccess {String} products.Fecha_Vencimiento Expiration date
     * @apiSuccess {Number} products.Precio Price
     * @apiSuccess {String} products.ticket Ticket ID (primary key)
     * @apiSuccess {Number} products.Line Line number (primary key)
     */
    @GetMapping("/detalle-openbravo")
    public ResponseEntity<?> getOpenBravoDetails(
            @RequestParam String ruc,
            @RequestParam String numeroFactura) {

        if (ruc == null || ruc.trim().isEmpty() || numeroFactura == null || numeroFactura.trim().isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Parámetros 'ruc' y 'numeroFactura' son requeridos.");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            // Dividir el número de factura en sus componentes
            String[] parts = numeroFactura.split("-");
            if (parts.length != 3) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Formato de 'numeroFactura' inválido. Se esperaba xxx-xxx-xxxxxxxxx");
                return ResponseEntity.badRequest().body(error);
            }

            String estab = parts[0];
            String emision = parts[1];
            String secuencial = parts[2];

            List<Object[]> results = ticketBuyLinesRepository.findOpenBravoDetailsByRucAndFacturaComponents(
                    ruc, estab, emision, secuencial);

            // Mapeo usando Map<String, Object> como originalmente, pero con los campos nuevos
            List<Map<String, Object>> products = new ArrayList<>();
            for (Object[] row : results) {
                Map<String, Object> product = new HashMap<>();
                product.put("ID", row[0]);
                product.put("Numero_Factura", row[1]);
                product.put("Fecha_Factura", row[2] != null ? row[2].toString() : null);
                product.put("RUC", row[3]);
                product.put("Laboratorio", row[4]);
                product.put("Code", row[5]);
                product.put("Nombre", row[6]);
                product.put("Lote", row[7]);
                product.put("Cantidad", row[8]);
                product.put("Presentacion", row[9]);
                product.put("Registro_Sanitario", row[10]);
                product.put("Fecha_Elaboracion", row[11] != null ? row[11].toString() : null);
                product.put("Fecha_Vencimiento", row[12] != null ? row[12].toString() : null);
                product.put("Precio", row[13]);
                product.put("ticket", row[14]);
                product.put("Line", row[15]);
                products.add(product);
            }

            return ResponseEntity.ok(products);

        } catch (Exception e) {
            // Log del error para depuración en el servidor
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error fetching OpenBravo details: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}