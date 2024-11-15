package com.Anotacion.ej1;

import java.lang.annotation.*;

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Repeatable(DatosEmpleados.class)
    @Target({ElementType.TYPE, ElementType.METHOD})
    public @interface EmpleadoAn {
        String nombre();
        String apellidos();
        String dni();
        String direccion();
        String telefono();
        String clase();
        int codigoDespacho() default -1;
        int codigoTaller()default -1;
        String perfil() default "";
        String categoria() default "";


    }
