package com.Anotacion.ej2.cargos;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Directivo {
    String nombre();

    String apellidos();

    String dni();

    String direccion();

    String telefono();

    int codigoDespacho();

    String clase () default "Directivo";

}


//public class Directivo extends Empleado {
//
//    private int codigoDespacho;
//
//    public Directivo(String nombre, String apellidos, String direccion, String dni, String telefono, int codigoDespacho) {
//        super(nombre, apellidos, direccion, dni, telefono);
//        this.codigoDespacho = codigoDespacho;
//    }
//
//    public void setCodigoDespacho(int codigoDespacho) {
//        this.codigoDespacho = codigoDespacho;
//    }
//
//    public int getCodigoDespacho() {
//        return codigoDespacho;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + " | Código Despacho: " + codigoDespacho;
//    }
//}
