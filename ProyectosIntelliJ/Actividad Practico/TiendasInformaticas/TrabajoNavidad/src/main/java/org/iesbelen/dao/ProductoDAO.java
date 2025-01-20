package org.iesbelen.dao;

import org.iesbelen.model.Producto;
import org.iesbelen.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public Producto obtenerProductoPorId(int productoId) {
        Producto producto = null;
        String sql = "SELECT id, nombre, precio, descripcion FROM Productos WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setDescripcion(rs.getString("descripcion"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return producto;
    }


    // Método para obtener productos por categoría
    public List<Producto> obtenerProductosPorCategoria(int categoriaId) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, descripcion FROM Productos WHERE categoria_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoriaId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    productos.add(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }
}
