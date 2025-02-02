package org.iesbelen.dao;

import org.iesbelen.model.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface CategoriaDAO {
    // Obtener todas las categorías
    List<Categoria> obtenerTodas() throws SQLException;

    // Obtener una categoría por su ID
    Categoria obtenerPorId(int id) throws SQLException;
    Categoria obtenerPorNombre(String nombre) throws SQLException;

    // Insertar una nueva categoría
    void insertar(Categoria categoria) throws SQLException;

    // Actualizar una categoría existente
    void actualizar(Categoria categoria) throws SQLException;

    // Eliminar una categoría por su ID
    void eliminar(int id) throws SQLException;



}
