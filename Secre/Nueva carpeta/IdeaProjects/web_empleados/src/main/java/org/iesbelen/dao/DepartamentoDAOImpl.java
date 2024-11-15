package org.iesbelen.dao;

import org.iesbelen.model.Departamento;
import org.iesbelen.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO{
    @Override
    public void create(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();


            ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setDouble(idx++, departamento.getPresupuesto());
            ps.setDouble(idx++, departamento.getGastos());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de departamento con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                departamento.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Departamento> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> listDe = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");
            while (rs.next()) {
                Departamento de = new Departamento();
                int idx = 1;
                de.setCodigo(rs.getInt(idx++));
                de.setNombre(rs.getString(idx++));
                de.setPresupuesto(rs.getDouble(idx++));
                de.setGastos(rs.getDouble(idx++));
                listDe.add(de);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDe;
    }

    @Override
    public Optional<Departamento> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM departamento WHERE codigo = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento de = new Departamento();
                idx = 1;
                de.setCodigo(rs.getInt(idx++));
                de.setNombre(rs.getString(idx++));
                de.setPresupuesto(rs.getDouble(idx++));
                de.setGastos(rs.getDouble(idx++));

                return Optional.of(de);
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
    public void update(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nombre = ?, presupuesto = ?, gastos = ? WHERE codigo = ?");
            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setDouble(idx++, departamento.getPresupuesto());
            ps.setDouble(idx++, departamento.getGastos());
            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de departamento con 0 registros actualizados.");

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

            ps = conn.prepareStatement("DELETE FROM departamento WHERE codigo = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de departamento con 0 registros eliminados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public Optional<Integer> getCountEmpleados(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer result = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT count(*) from empleado where codigo_departamento = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);
                return  Optional.of(result);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, rs);
        }
        return Optional.empty();
    }

    @Override
    public List<Departamento> filtrar(int max, int min) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer result = null;
        List<Departamento> listDe = new ArrayList<>();
        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * from departamento where (presupuesto - gastos) > ? &&  (presupuesto - gastos) < ?");

            int idx = 1;
            ps.setInt(idx++,min);
            ps.setInt(idx++,max);

            rs = ps.executeQuery();

            while (rs.next()) {
                Departamento dep = new Departamento();
                int i = 1;
                dep.setCodigo(rs.getInt(i++));
                dep.setNombre(rs.getString(i++));
                dep.setPresupuesto(rs.getDouble(i++));
                dep.setGastos(rs.getInt(i));
                listDe.add(dep);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            closeDb(conn, ps, rs);
        }
        return listDe;
    }
}
