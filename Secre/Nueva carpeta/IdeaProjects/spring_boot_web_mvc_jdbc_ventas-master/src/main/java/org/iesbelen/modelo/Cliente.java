package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Cliente {

	private long id;

	@NotBlank(message = "Introduzca un nombre.")
	@Size(max=30, message = "Nombre como máximo de 10 caracteres.")
	private String nombre;

	@NotBlank(message = "Introduzca un nombre.")
	@Size(max=30, message = "Nombre como máximo de 10 caracteres.")
	private String apellido1;
	private String apellido2;

	@Size(max=50, message = "Introduzca un nombre.")
	private String ciudad;


	@Min(value =100 , message = "Salario debe ser al menos de 100.")
	@Max(value=1000, message = "Salario no debe ser mayor de 1000.")
	private int categoria;


	public Cliente() {}
}
