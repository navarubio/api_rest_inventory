package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.SateliteView;
import com.sismacontab.inventory.projections.CargaByEmpleadoProjection;
import com.sismacontab.inventory.projections.CargaByLocalProjection;
import com.sismacontab.inventory.repositories.SateliteViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class SateliteViewController {

    @Autowired
    private SateliteViewRepository sateliteViewRepository;

    // Obtener todos los registros
    @GetMapping("/satelites")
    public List<SateliteView> getAllSatelites() {
        return sateliteViewRepository.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/satelites/{id}")
    public ResponseEntity<SateliteView> getSateliteById(@PathVariable String id) {
        Optional<SateliteView> satelite = sateliteViewRepository.findById(id);
        return satelite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener registros por campo local
    @GetMapping("/satelites/local/{local}")
    public List<SateliteView> getSatelitesByLocal(@PathVariable String local) {
        return sateliteViewRepository.findByLocal(local);
    }

    // Obtener registros por numerolote
    @GetMapping("/satelites/numerolote/{numerolote}")
    public List<SateliteView> getSatelitesByNumerolote(@PathVariable String numerolote) {
        return sateliteViewRepository.findByNumerolote(numerolote);
    }

    // Obtener registros por fechavencimiento exacto
    @GetMapping("/satelites/fechavencimiento/{fechavencimiento}")
    public List<SateliteView> getSatelitesByFechavencimiento(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechavencimiento) {
        return sateliteViewRepository.findByFechavencimientoExact(fechavencimiento);
    }

    // Obtener registros por fechavencimiento menor o igual a la fecha recibida
    @GetMapping("/satelites/totalvencimiento/{fechavencimiento}")
    public List<SateliteView> getSatelitesByFechavencimientoBeforeOrEqual(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechavencimiento) {
        return sateliteViewRepository.findByFechavencimientoBeforeOrEqual(fechavencimiento);
    }

    // Obtener registros por product_name
    @GetMapping("/satelites/product_name/{productName}")
    public List<SateliteView> getSatelitesByProductName(@PathVariable String productName) {
        return sateliteViewRepository.findByProductName(productName);
    }

    // Obtener registros por product ID
    @GetMapping("/satelites/product/{productId}")
    public List<SateliteView> getSatelitesByProductId(@PathVariable String productId) {
        return sateliteViewRepository.findByProductId(productId);
    }

    // Obtener registros por product code
    @GetMapping("/satelites/product_code/{code}")
    public List<SateliteView> getSatelitesByProductCode(@PathVariable String code) {
        return sateliteViewRepository.findByProductCode(code);
    }

    // Obtener reporte de carga por empleado
    @GetMapping("/satelites/cargabyempleado")
    public List<CargaByEmpleadoProjection> getCargaByEmpleado() {
        return sateliteViewRepository.getCargaByEmpleado();
    }

    // Obtener reporte de carga por local
    @GetMapping("/satelites/cargabylocal")
    public List<CargaByLocalProjection> getCargaByLocal() {
        return sateliteViewRepository.getCargaByLocal();
    }

    // Obtener registros por laboratorio
    @GetMapping("/satelites/laboratorio/{laboratorio}")
    public List<SateliteView> getSatelitesByLaboratorio(@PathVariable String laboratorio) {
        return sateliteViewRepository.findByLaboratorio(laboratorio);
    }

    // Obtener registros por locationName
    @GetMapping("/satelites/location_name/{locationName}")
    public List<SateliteView> getSatelitesByLocationName(@PathVariable String locationName) {
        return sateliteViewRepository.findByLocationName(locationName);
    }
}