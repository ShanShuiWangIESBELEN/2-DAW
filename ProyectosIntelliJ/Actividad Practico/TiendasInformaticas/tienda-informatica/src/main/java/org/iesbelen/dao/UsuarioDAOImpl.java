package org.iesbelen.dao;

import org.iesbelen.model.Producto;
import org.iesbelen.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO {

    @Override
    public synchronized void create(Usuario usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO usuarios (Usuario,password,rol) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            int idx = 1;
            ps.setString(idx++, usuario.getUsuario());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx, usuario.getRol());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("INSERT de usuario con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) {
                usuario.setIdUsuario(rsGenKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Usuario> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> ListUsuario = new ArrayList<>();
        try {
            conn = connectDB();

            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM USUARIOS");

            while (rs.next()) {
                Usuario usuario = new Usuario();
                int idx = 1;
                usuario.setIdUsuario(rs.getInt(idx++));
                usuario.setUsuario(rs.getString(idx++));
                usuario.setPassword(rs.getString(idx++));
                usuario.setRol(rs.getString(idx));

                ListUsuario.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return ListUsuario;
    }

    @Override
    public Optional<Usuario> find(int idUsuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM USUARIOS WHERE idUsuario = ?");
            int idx = 1;
            ps.setInt(idx, idUsuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                idx = 1;
                usuario.setIdUsuario(rs.getInt(idx++));
                usuario.setUsuario(rs.getString(idx++));
                usuario.setPassword(rs.getString(idx++));
                usuario.setRol(rs.getString(idx));
                return Optional.of(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return Optional.empty();
    }

    @Override
    public void update(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE USUARIOS SET usuario = ?,password = ?,rol=? WHERE idUsuario = ?");
            int idx = 1;
            ps.setString(idx++, usuario.getUsuario());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx++, usuario.getRol());
            ps.setInt(idx, usuario.getIdUsuario());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de usuario con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }


    @Override
    public void delete(int idUsuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM USUARIOS WHERE idUsuario = ?");
            int idx = 1;
            ps.setInt(idx, idUsuario);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de usuario con 0 registros eliminados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
