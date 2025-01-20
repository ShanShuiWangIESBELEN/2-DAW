package org.iesbelen.dao;

import org.iesbelen.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl extends AbstractDAOImpl implements PedidoDAO {

    @Override
    public List<Pedido> obtenerTodos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Pedidos");

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setIdUsuario(rs.getInt("id_usuario"));
                pedido.setFecha(rs.getTimestamp("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedidos.add(pedido);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, stmt, rs);
        }

        return pedidos;
    }

    @Override
    public Pedido obtenerPorId(int idPedido) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM Pedidos WHERE id_pedido = ?");
            ps.setInt(1, idPedido);
            rs = ps.executeQuery();

            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setIdUsuario(rs.getInt("id_usuario"));
                pedido.setFecha(rs.getTimestamp("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                return pedido;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, rs);
        }

        return null;
    }

    @Override
    public void insertar(Pedido pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO Pedidos (id_usuario, total) VALUES (?, ?)");
            ps.setInt(1, pedido.getIdUsuario());
            ps.setDouble(2, pedido.getTotal());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, null);
        }
    }

    @Override
    public void actualizar(Pedido pedido) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("UPDATE Pedidos SET id_usuario = ?, total = ? WHERE id_pedido = ?");
            ps.setInt(1, pedido.getIdUsuario());
            ps.setDouble(2, pedido.getTotal());
            ps.setInt(3, pedido.getIdPedido());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, null);
        }
    }

    @Override
    public void eliminar(int idPedido) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("DELETE FROM Pedidos WHERE id_pedido = ?");
            ps.setInt(1, idPedido);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, null);
        }
    }
}
