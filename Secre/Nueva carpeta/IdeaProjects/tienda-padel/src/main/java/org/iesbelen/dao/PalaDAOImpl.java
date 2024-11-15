package org.iesbelen.dao;

import org.iesbelen.model.Pala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;


public class PalaDAOImpl extends AbstractDAOImpl implements PalaDAO {
    @Override
    public void create(Pala pala) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO pala (modelo,tipo,precio,codigoMarca) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, pala.getModelo());
            ps.setString(idx++, pala.getTipo());
            ps.setDouble(idx++, pala.getPrecio());
            ps.setInt(idx++, pala.getCodigoMarca());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de pala con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                pala.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pala> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Pala> listaPala = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM pala");
            while (rs.next()) {
                Pala pala = new Pala();
                int idx = 1;
                pala.setCodigo(rs.getInt(idx++));
                pala.setModelo(rs.getString(idx++));
                pala.setTipo(rs.getString(idx++));
                pala.setPrecio(rs.getDouble(idx++));
                pala.setCodigoMarca(rs.getInt(idx));
                listaPala.add(pala);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listaPala;
    }

    @Override
    public Optional<Pala> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM pala WHERE codigoPala = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Pala pala = new Pala();
                idx = 1;
                pala.setCodigo(rs.getInt(idx++));
                pala.setModelo(rs.getString(idx++));
                pala.setTipo(rs.getString(idx++));
                pala.setPrecio(rs.getDouble(idx++));
                pala.setCodigoMarca(rs.getInt(idx++));

                return Optional.of(pala);
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
    public void update(Pala pala) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE pala SET modelo = ?,tipo = ?,precio = ?   WHERE codigoPala = ?");
            int idx = 1;
            ps.setString(idx++, pala.getModelo());
            ps.setString(idx++, pala.getTipo());
            ps.setDouble(idx++, pala.getPrecio());
            ps.setInt(idx, pala.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de pala con 0 registros actualizados.");

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

            ps = conn.prepareStatement("DELETE FROM pala WHERE codigoPala = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de pala con 0 registros eliminados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pala> filtrar(String filtro) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer result = null;
        List<Pala> listPala = new ArrayList<>();
        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * from pala where modelo like ? ");

            int idx = 1;
            ps.setString(idx,"%" + filtro + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Pala pala = new Pala();
                int i = 1;
                pala.setCodigo(rs.getInt(i++));
                pala.setModelo(rs.getString(i++));
                pala.setTipo(rs.getString(i++));
                pala.setPrecio(rs.getDouble(i++));
                pala.setCodigoMarca(rs.getInt(i));
                listPala.add(pala);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, rs);
        }
        return listPala;
    }
}
