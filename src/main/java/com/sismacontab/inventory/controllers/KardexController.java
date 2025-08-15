package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.KardexEntry;
import com.sismacontab.inventory.repositories.KardexRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/kardex")
public class KardexController {
    private final KardexRepository kardexRepository;

    public KardexController(KardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    @GetMapping("/{productId}")
    public Map<String, Object> getKardexByProduct(
            @PathVariable String productId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(required = false) String fechaDesde,
            @RequestParam(required = false) String fechaHasta,
            @RequestParam(required = false) String tipodocumento,
            @RequestParam(required = false) String codLocal,
            @RequestParam(required = false) String nombreLocation
    ) {
        List<KardexEntry> data = kardexRepository.getKardexByProductPaged(
                productId, fechaDesde, fechaHasta, tipodocumento, codLocal, nombreLocation, page, size
        );
        long total = kardexRepository.countKardexByProduct(
                productId, fechaDesde, fechaHasta, tipodocumento, codLocal, nombreLocation
        );
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("totalElements", total);
        response.put("totalPages", (int) Math.ceil((double) total / size));
        response.put("currentPage", page);
        response.put("pageSize", size);
        return response;
    }
}
