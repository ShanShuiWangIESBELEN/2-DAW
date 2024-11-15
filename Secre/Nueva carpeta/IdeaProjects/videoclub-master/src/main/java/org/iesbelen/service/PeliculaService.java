package org.iesbelen.service;

import java.util.List;
import java.util.Set;

import org.iesbelen.domain.Categoria;
import org.iesbelen.domain.Idioma;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

	@Value("${app.videoclub_examen.array.clasificaciones}")
	private String[] arrayClasificaciones;
	@Value("#{${app.videoclub_examen.set.clasificaciones}}")
	private Set<String> setCaracteristicasEspeciales;

	private PeliculaRepository peliculaRepository;

	@Autowired
	public PeliculaService(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}
	public List<PeliculaDTO> listAll() {
		return peliculaRepository.findAllDTO();
	}

	public void crear(Pelicula pelicula) {
		peliculaRepository.create(pelicula);
	}
	
}
