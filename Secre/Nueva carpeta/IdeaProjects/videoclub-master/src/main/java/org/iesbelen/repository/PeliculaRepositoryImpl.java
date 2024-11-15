package org.iesbelen.repository;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iesbelen.domain.Categoria;
import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
//Utilizo lombok para generar el constructor
@AllArgsConstructor
public class PeliculaRepositoryImpl implements PeliculaRepository {

	private JdbcTemplate jdbcTemplate;
	/*@Override
	public List<PeliculaDTO> findAllDTO() {


		List<PeliculaDTO> listPeliculaDTOs = this.jdbcTemplate.query(
				"""
						select P.*, C.id_categoria as idCat, C.nombre as nomCat, I.id_idioma as idIdiom, I.nombre as nomIdiom, IO.id_idioma as idIdiomOrig, IO.nombre as nomIdiomOrig from pelicula P
										left join pelicula_categoria P_C on P.id_pelicula = P_C.id_pelicula
										left join categoria C on C.id_categoria = P_C.id_categoria
										left join idioma I on P.id_idioma = I.id_idioma
						                left join idioma IO on P.id_idioma_original = I.id_idioma
						""",
				(rs, rowNum) -> new PeliculaDTO(rs.getInt("id_pelicula"), rs.getString("titulo"),
						rs.getString("descripcion"), rs.getDate("anyo_lanzamiento"), rs.getInt("id_idioma"),
						rs.getInt("id_idioma_original"), rs.getInt("duracion"), rs.getBigDecimal("rental_rate"),
						rs.getInt("duracion"), rs.getBigDecimal("replacement_cost"), rs.getString("clasificacion"),
						rs.getString("caracteristicas_especiales"), rs.getTimestamp("ultima_actualizacion"),
						Idioma.builder().id(rs.getLong("idIdiom")).nombre(rs.getString("nomIdiom")).build(),
						Idioma.builder().id(rs.getLong("idIdiomOrig")).nombre(rs.getString("nomIdiomOrig")).build(),
						Categoria.builder().id(rs.getLong("idCat")).nombre(rs.getString("nomCat")).build()));

		return listPeliculaDTOs;
	}
*/


	@Override
	public List<PeliculaDTO> findAllDTO() {
		List<PeliculaDTO> listPelicula = jdbcTemplate.query(
				"SELECT * FROM pelicula",
				(rs, rowNum) -> new PeliculaDTO(rs.getInt("id_pelicula"), rs.getString("titulo"),
						rs.getString("descripcion"), rs.getDate("anyo_lanzamiento"), rs.getInt("id_idioma"),
						rs.getInt("id_idioma_original"), rs.getInt("duracion"), rs.getBigDecimal("rental_rate"),
						rs.getInt("duracion"), rs.getBigDecimal("replacement_cost"), rs.getString("clasificacion"),
						rs.getString("caracteristicas_especiales"), rs.getTimestamp("ultima_actualizacion")));

		return listPelicula;
	}

	@Override
	public Pelicula create(Pelicula pelicula) {

		String sqlInsert = """
							INSERT INTO comercial (id_pelicula, titulo, descripcion, anyo_lanzamiento, 
							id_idioma, id_idioma_original, duracion_alquiler, rental_rate,
							 duracion, replacement_cost, clasificacion, caracteristicas_especiales,
							 ultima_actualizacion) 
							VALUES  (     ?,         ?,         ?,      ?, ?, ?,?, ?, ?, ?, ?, ?, ?)
						   """;

		KeyHolder keyHolder = new GeneratedKeyHolder();
		//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setInt(idx++, (int) pelicula.getIdPelicula());
			ps.setString(idx++, pelicula.getTitulo());
			ps.setString(idx++, pelicula.getDescripcion());
			ps.setString(idx++, String.valueOf(pelicula.getAnyoLanzamiento()));
			ps.setInt(idx++, (int) pelicula.getIdIdioma());
			ps.setInt(idx++, (int) pelicula.getIdIdiomaOriginal());
			ps.setInt(idx++, pelicula.getDuracionAlquiler());
			ps.setBigDecimal(idx++, pelicula.getRentalRate());
			ps.setInt(idx++, pelicula.getDuracion());
			ps.setBigDecimal(idx++, pelicula.getReplacementCost());
			ps.setString(idx++, pelicula.getClasificacion());
			ps.setString(idx++, pelicula.getCaracteristicasEspeciales());
			ps.setDate(idx++, (Date) pelicula.getUltimaActualizacion());
			return ps;
		},keyHolder);

		pelicula.setIdPelicula(keyHolder.getKey().intValue());


		log.info("Insertados {} registros.", rows);


		return pelicula;
	}

}
