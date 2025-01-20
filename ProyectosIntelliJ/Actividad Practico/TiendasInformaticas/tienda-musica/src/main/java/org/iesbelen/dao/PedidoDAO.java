package org.iesbelen.dao;

import org.iesbelen.model.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDAO {
    List<Pedido> obtenerTodos() throws SQLException;

    Pedido obtenerPorId(int idPedido) throws SQLException;

    void insertar(Pedido pedido) throws SQLException;

    void actualizar(Pedido pedido) throws SQLException;

    void eliminar(int idPedido) throws SQLException;
}
