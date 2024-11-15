package com.Anotacion.ej1.cargos;


public class Tecnico extends Operario {
    private String perfil;

    public Tecnico(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String perfil) {
        super(nombre, apellidos, dni, direccion, telefono, codigoTaller);
        this.perfil = perfil;
    }



    @Override
    public String toString() {
        return super.toString() + " | Perfil: " + perfil;
    }
}
