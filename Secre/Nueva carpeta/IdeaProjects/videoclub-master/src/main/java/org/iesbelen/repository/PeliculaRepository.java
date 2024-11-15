package org.iesbelen.repository;

import java.util.List;

import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;

public interface PeliculaRepository {

	
	public List<PeliculaDTO> findAllDTO();
	
	public Pelicula create(Pelicula pelicula);

}
