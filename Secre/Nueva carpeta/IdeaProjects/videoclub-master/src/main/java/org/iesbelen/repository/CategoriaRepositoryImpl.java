package org.iesbelen.repository;

import org.iesbelen.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class CategoriaRepositoryImpl implements CategoriaRepository{

    private JdbcTemplate jdbcTemplate;
    @Override
    public Optional<Categoria> find(int id) {
        Categoria cat =  jdbcTemplate
                .queryForObject("SELECT * FROM categoria WHERE id_categoria = ?"
                        , (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                                rs.getString("nombre"),
                                rs.getDate("ultima_actualizacion"))
                        , id
                );

        if (cat != null) {
            return Optional.of(cat);}
        else {
            return Optional.empty(); }
    }
}
