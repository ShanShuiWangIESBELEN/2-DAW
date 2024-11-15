package com.example.empresas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(length = 500)
    private String descripcion;
    private String direccion;
    private Long telefono;
    private String email;
    private String imagen;
    @Column(length = 1000)
    private String historia;
    private double latitud;
    private double longitud;

}
