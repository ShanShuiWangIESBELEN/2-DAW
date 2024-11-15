package org.iesbelen.dao;

import org.iesbelen.model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarcaDAOImpl extends AbstractDAOImpl implements MarcaDAO{


    @Override
    public void create(Marca marca) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO marca (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, marca.getNombre());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de marca con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                marca.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Marca> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Marca> listaMarca = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM marca");
            while (rs.next()) {
                Marca mar = new Marca();
                int idx = 1;
                mar.setCodigo(rs.getInt(idx++));
                mar.setNombre(rs.getString(idx));
                listaMarca.add(mar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listaMarca;
    }

    @Override
    public Optional<Marca> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM marca WHERE codigo = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Marca mar = new Marca();
                idx = 1;
                mar.setCodigo(rs.getInt(idx++));
                mar.setNombre(rs.getString(idx));

                return Optional.of(mar);
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
    public void update(Marca marca) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE marca SET nombre = ?  WHERE codigo = ?");
            int idx = 1;
            ps.setString(idx++, marca.getNombre());
            ps.setInt(idx, marca.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de marca con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM marca WHERE codigo = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de marca con 0 registros eliminados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}
