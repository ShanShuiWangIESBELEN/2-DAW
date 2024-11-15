package com.Anotacion.ej2.cargos;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Oficial {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String clase();
    int codigoDespacho();
    String categoria();


}


//public class Oficial extends Operario {
//    private String categoria;
//
//    public Oficial(String nombre, String apellidos, String dni, String direccion, String telefono, int codigoTaller, String categoria) {
//        super(nombre, apellidos, dni, direccion, telefono, codigoTaller);
//        this.categoria = categoria;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + " | Categoría: " + categoria;
//    }
//}


