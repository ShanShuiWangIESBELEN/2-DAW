package org.iesbelen.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
	
	private long idPelicula;
	private String titulo;
	private String descripcion;
	@DateTimeFormat(pattern="yyyy")
	private Date anyoLanzamiento;
	private long idIdioma;
	private long idIdiomaOriginal;
	private int duracionAlquiler;
	private BigDecimal rentalRate;
	private int duracion;
	private BigDecimal replacementCost;
	private String clasificacion;
	private String caracteristicasEspeciales;
	private Date ultimaActualizacion;
	
}
