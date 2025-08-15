package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.GeneralPedidosDespachados;
import com.sismacontab.inventory.repositories.GeneralPedidosDespachadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos-despachados")
public class GeneralPedidosDespachadosController {

    @Autowired
    private GeneralPedidosDespachadosRepository repository;

    @GetMapping
    public List<GeneralPedidosDespachados> getAll() {
        return repository.findAll();
    }

    @GetMapping("/fecha/{fecha}")
    public List<GeneralPedidosDespachados> getByFecha(@PathVariable String fecha) {
        return repository.findByFechaCalculoPedido(fecha);
    }

    @GetMapping("/local_destino/{localDestino}")
    public List<GeneralPedidosDespachados> getByLocalDestino(@PathVariable String localDestino) {
        return repository.findByLocalDestino(localDestino);
    }

    @GetMapping("/ticketid/{ticketid}")
    public List<GeneralPedidosDespachados> getByTicketid(@PathVariable Integer ticketid) {
        return repository.findByTicketid(ticketid);
    }
}
