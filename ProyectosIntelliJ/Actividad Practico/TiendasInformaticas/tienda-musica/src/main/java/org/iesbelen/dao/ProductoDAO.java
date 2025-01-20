package org.iesbelen.dao;

import org.iesbelen.model.Producto;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    // Obtener todos los productos
    List<Producto> obtenerTodos() throws SQLException;

    // Obtener un producto por su ID
    Producto obtenerPorId(int id) throws SQLException;

    // Insertar un nuevo producto
    void insertar(Producto producto) throws SQLException;

    // Actualizar un producto existente
    void actualizar(Producto producto) throws SQLException;

    // Eliminar un producto por su ID
    void eliminar(int id) throws SQLException;
}
