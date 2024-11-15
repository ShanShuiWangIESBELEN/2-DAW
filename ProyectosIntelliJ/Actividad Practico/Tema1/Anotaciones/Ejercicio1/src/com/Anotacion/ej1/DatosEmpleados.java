package com.Anotacion.ej1;

import java.lang.annotation.*;


@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DatosEmpleados {
        EmpleadoAn[] value();

}
