package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ProductByKardex;
import com.sismacontab.inventory.repositories.ProductByKardexRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products-by-kardex")
public class ProductByKardexController {

    private final ProductByKardexRepository repository;

    public ProductByKardexController(ProductByKardexRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Map<String, Object> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) String laboratorio // <-- añadido
    ) {
        List<ProductByKardex> products = repository.findAllPaged(codigo, descripcion, laboratorio, page, size);
        long total = repository.countAll(codigo, descripcion, laboratorio);
        Map<String, Object> response = new HashMap<>();
        response.put("data", products);
        response.put("totalElements", total);
        response.put("totalPages", (int) Math.ceil((double) total / size));
        response.put("currentPage", page);
        response.put("pageSize", size);
        return response;
    }

    @GetMapping("/{codigo}")
    public ProductByKardex getByCodigo(@PathVariable String codigo) {
        return repository.findByCodigo(codigo);
    }
}
