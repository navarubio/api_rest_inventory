package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.GeneralPedidosDespachados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneralPedidosDespachadosRepository extends JpaRepository<GeneralPedidosDespachados, String> {
    List<GeneralPedidosDespachados> findByFechaCalculoPedido(String fechaCalculoPedido);
    List<GeneralPedidosDespachados> findByLocalDestino(String localDestino);
    List<GeneralPedidosDespachados> findByTicketid(Integer ticketid);
}