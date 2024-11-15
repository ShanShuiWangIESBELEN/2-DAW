package org.iesbelen.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma {

	private Long id;
	private String nombre;
	private Date ultimaActualizacion;

}
