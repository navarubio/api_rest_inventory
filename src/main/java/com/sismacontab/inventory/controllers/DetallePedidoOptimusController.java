package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.DetallePedidoOptimus;
import com.sismacontab.inventory.repositories.DetallePedidoOptimusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-pedido-optimus")
public class DetallePedidoOptimusController {

    @Autowired
    private DetallePedidoOptimusRepository repository;

    @GetMapping
    public List<DetallePedidoOptimus> getAll() {
        return repository.findAll();
    }

    @GetMapping("/ticketid/{ticketid}")
    public List<DetallePedidoOptimus> getByTicketid(@PathVariable Integer ticketid) {
        return repository.findByTicketid(ticketid);
    }

    @GetMapping("/fecha/{fecha}")
    public List<DetallePedidoOptimus> getByFecha(@PathVariable String fecha) {
        return repository.findByFechaCalculoFormato(fecha);
    }

    @GetMapping("/codigo_local/{codigoLocal}")
    public List<DetallePedidoOptimus> getByCodigoLocal(@PathVariable String codigoLocal) {
        return repository.findByCodigoLocal(codigoLocal);
    }

    @GetMapping("/producto_id/{productoId}")
    public List<DetallePedidoOptimus> getByProductoId(@PathVariable String productoId) {
        return repository.findByProductoId(productoId);
    }

    @GetMapping("/nombre_producto/{nombreProducto}")
    public List<DetallePedidoOptimus> getByNombreProducto(@PathVariable String nombreProducto) {
        return repository.findByNombreProducto(nombreProducto);
    }

    @GetMapping("/nombre_producto/like/{nombreProducto}")
    public List<DetallePedidoOptimus> getByNombreProductoLike(@PathVariable String nombreProducto) {
        return repository.findByNombreProductoContainingIgnoreCase(nombreProducto);
    }

    @GetMapping("/nombre_laboratorio/{nombreLaboratorio}")
    public List<DetallePedidoOptimus> getByNombreLaboratorio(@PathVariable String nombreLaboratorio) {
        return repository.findByNombreLaboratorio(nombreLaboratorio);
    }

    @GetMapping("/nombre_laboratorio/like/{nombreLaboratorio}")
    public List<DetallePedidoOptimus> getByNombreLaboratorioLike(@PathVariable String nombreLaboratorio) {
        return repository.findByNombreLaboratorioContainingIgnoreCase(nombreLaboratorio);
    }

    @GetMapping("/estado_registro/{estadoRegistro}")
    public List<DetallePedidoOptimus> getByEstadoRegistro(@PathVariable String estadoRegistro) {
        return repository.findByEstadoRegistro(estadoRegistro);
    }

    @GetMapping("/ticketid/{ticketid}/estado_registro/{estadoRegistro}")
    public List<DetallePedidoOptimus> getByTicketidAndEstadoRegistro(
            @PathVariable Integer ticketid,
            @PathVariable String estadoRegistro) {
        return repository.findByTicketidAndEstadoRegistro(ticketid, estadoRegistro);
    }
}