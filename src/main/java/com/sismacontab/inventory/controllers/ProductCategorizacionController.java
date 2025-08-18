package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ProductCategorizacion;
import com.sismacontab.inventory.repositories.ProductCategorizacionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/products")
public class ProductCategorizacionController {
    
    private final ProductCategorizacionRepository repository;

    public ProductCategorizacionController(ProductCategorizacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/codigo/{codigoInterno}")
    public ProductCategorizacion getByCodigoInterno(@PathVariable String codigoInterno) {
        return repository.findByCodigoInterno(codigoInterno);
    }

    @GetMapping("/upc/{upc}")
    public ProductCategorizacion getByUpc(@PathVariable String upc) {
        return repository.findByUpc(upc);
    }

    @GetMapping("/search")
    public Map<String, Object> search(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String laboratorio,
            @RequestParam(required = false) String categoriaPrincipal,
            @RequestParam(required = false) String subcategoria1,
            @RequestParam(required = false) String subcategoria2,
            @RequestParam(required = false) String subcategoria3,
            @RequestParam(required = false) String formaFarmaceutica,
            @RequestParam(required = false) String concentracionDosis,
            @RequestParam(required = false) String contenidoEnvase,
            @RequestParam(required = false) String poblacionDiana,
            @RequestParam(required = false) String principioActivo,
            @RequestParam(required = false) String patologia,
            @RequestParam(required = false) String posologia,
            @RequestParam(required = false) Integer nivelCompletacion,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<ProductCategorizacion> pageResult;
        PageRequest pageRequest = PageRequest.of(page, size);

        if (nombre != null && !nombre.isEmpty()) {
            pageResult = repository.findByNombreProductoContainingIgnoreCase(nombre, pageRequest);
        } else if (laboratorio != null && !laboratorio.isEmpty()) {
            pageResult = repository.findByLaboratorioContainingIgnoreCase(laboratorio, pageRequest);
        } else if (categoriaPrincipal != null && !categoriaPrincipal.isEmpty()) {
            pageResult = repository.findByCategoriaPrincipalContainingIgnoreCase(categoriaPrincipal, pageRequest);
        } else if (subcategoria1 != null && !subcategoria1.isEmpty()) {
            pageResult = repository.findBySubcategoria1ContainingIgnoreCase(subcategoria1, pageRequest);
        } else if (subcategoria2 != null && !subcategoria2.isEmpty()) {
            pageResult = repository.findBySubcategoria2ContainingIgnoreCase(subcategoria2, pageRequest);
        } else if (subcategoria3 != null && !subcategoria3.isEmpty()) {
            pageResult = repository.findBySubcategoria3ContainingIgnoreCase(subcategoria3, pageRequest);
        } else if (formaFarmaceutica != null && !formaFarmaceutica.isEmpty()) {
            pageResult = repository.findByFormaFarmaceuticaContainingIgnoreCase(formaFarmaceutica, pageRequest);
        } else if (concentracionDosis != null && !concentracionDosis.isEmpty()) {
            pageResult = repository.findByConcentracionDosisContainingIgnoreCase(concentracionDosis, pageRequest);
        } else if (contenidoEnvase != null && !contenidoEnvase.isEmpty()) {
            pageResult = repository.findByContenidoEnvaseContainingIgnoreCase(contenidoEnvase, pageRequest);
        } else if (poblacionDiana != null && !poblacionDiana.isEmpty()) {
            pageResult = repository.findByPoblacionDianaContainingIgnoreCase(poblacionDiana, pageRequest);
        } else if (principioActivo != null && !principioActivo.isEmpty()) {
            pageResult = repository.findByPrincipioActivoContainingIgnoreCase(principioActivo, pageRequest);
        } else if (patologia != null && !patologia.isEmpty()) {
            pageResult = repository.findByPatologiaContainingIgnoreCase(patologia, pageRequest);
        } else if (posologia != null && !posologia.isEmpty()) {
            pageResult = repository.findByPosologiaContainingIgnoreCase(posologia, pageRequest);
        } else if (nivelCompletacion != null) {
            pageResult = repository.findByNivelCompletacion(nivelCompletacion, pageRequest);
        } else {
            pageResult = repository.findAll(pageRequest);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("content", pageResult.getContent());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());

        return response;
    }
}