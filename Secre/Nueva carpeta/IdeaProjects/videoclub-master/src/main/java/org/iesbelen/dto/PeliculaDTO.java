package org.iesbelen.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class PeliculaDTO {
    private long idPelicula;
    private String titulo;
    private String descripcion;
    @DateTimeFormat(pattern="yyyy")
    private java.util.Date anyoLanzamiento;
    private long idIdioma;
    private long idIdiomaOriginal;
    private int duracionAlquiler;
    private BigDecimal rentalRate;
    private int duracion;
    private BigDecimal replacementCost;
    private String clasificacion;
    private String caracteristicasEspeciales;
    private java.util.Date ultimaActualizacion;
    public PeliculaDTO(int idPelicula, String titulo, String descripcion, Date anyoLanzamiento, int idIdioma, int idIdiomaOriginal, int duracion, BigDecimal rentalRate, int duracion1, BigDecimal replacementCost, String clasificacion, String caracteristicasEspeciales, Timestamp ultimaActualizacion) {
    }
}
