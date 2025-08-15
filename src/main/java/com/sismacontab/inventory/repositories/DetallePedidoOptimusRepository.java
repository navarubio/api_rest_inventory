package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.DetallePedidoOptimus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoOptimusRepository extends JpaRepository<DetallePedidoOptimus, String> {
    List<DetallePedidoOptimus> findByTicketid(Integer ticketid);
    List<DetallePedidoOptimus> findByFechaCalculoFormato(String fechaCalculoFormato);
    List<DetallePedidoOptimus> findByCodigoLocal(String codigoLocal);
    List<DetallePedidoOptimus> findByProductoId(String productoId);
    List<DetallePedidoOptimus> findByNombreProducto(String nombreProducto);
    List<DetallePedidoOptimus> findByNombreProductoContainingIgnoreCase(String nombreProducto);
    List<DetallePedidoOptimus> findByNombreLaboratorio(String nombreLaboratorio);
    List<DetallePedidoOptimus> findByNombreLaboratorioContainingIgnoreCase(String nombreLaboratorio);
    List<DetallePedidoOptimus> findByEstadoRegistro(String estadoRegistro);
    List<DetallePedidoOptimus> findByTicketidAndEstadoRegistro(Integer ticketid, String estadoRegistro);
    // Asegúrate de que extiende JpaRepository<DetallePedidoOptimus, [ID_TYPE]> y no requiere cambios si ya lo hace.
}