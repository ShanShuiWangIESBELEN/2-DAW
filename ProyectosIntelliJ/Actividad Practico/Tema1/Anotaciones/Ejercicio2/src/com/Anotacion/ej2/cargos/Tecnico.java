package com.Anotacion.ej2.cargos;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tecnico {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String clase() default " Tecnico";
    int codigoDespacho() default -1;

}

//public class Tecnico extends Operario {
//    private String perfil;
//
//    public Tecnico(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String perfil) {
//        super(nombre, apellidos, dni, direccion, telefono, codigoTaller);
//        this.perfil = perfil;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return super.toString() + " | Perfil: " + perfil;
//    }
//}
