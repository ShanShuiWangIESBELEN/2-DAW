package org.iesbelen.dao;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Pedido;

import java.util.List;

public interface PedidoDAO {

    public List<Pedido> getAll(int id);
}
