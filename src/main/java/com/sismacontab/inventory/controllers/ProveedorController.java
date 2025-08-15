package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Proveedor;
import com.sismacontab.inventory.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los registros
    @GetMapping("/proveedores")
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable String id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener un registro por RUC (taxid)
    @GetMapping("/proveedores/ruc/{taxid}")
    public ResponseEntity<Proveedor> getProveedorByTaxid(@PathVariable String taxid) {
        Optional<Proveedor> proveedor = proveedorRepository.findByTaxid(taxid);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}