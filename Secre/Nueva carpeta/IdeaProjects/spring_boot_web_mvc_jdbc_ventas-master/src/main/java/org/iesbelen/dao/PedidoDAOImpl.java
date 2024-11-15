package org.iesbelen.dao;

import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j
@Repository
//Utilizo lombok para generar el constructor
@AllArgsConstructor
public class PedidoDAOImpl implements PedidoDAO{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Pedido> getAll(int id) {
        List<Pedido> listPedidos = jdbcTemplate.query(
                "SELECT * FROM pedido WHERE id_comercial = ?",
                new Object[]{id},
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial"),
                null
        )
        );

        log.info("Devueltos {} registros.", listPedidos.size());
        return listPedidos;
    }
}
