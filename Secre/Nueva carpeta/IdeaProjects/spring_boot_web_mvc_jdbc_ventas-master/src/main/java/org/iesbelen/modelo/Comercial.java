package org.iesbelen.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Comercial {

	private int id;

	@NotBlank(message = "Introduzca un nombre.")
	@Size(max=30, message = "Nombre como máximo de 10 caracteres.")
	private String nombre;

	@NotBlank(message = "Introduzca un nombre.")
	@Size(max=30, message = "Nombre como máximo de 10 caracteres.")
	private String apellido1;

	private String apellido2;

	private float comision;


	public Comercial() {

	}
}
