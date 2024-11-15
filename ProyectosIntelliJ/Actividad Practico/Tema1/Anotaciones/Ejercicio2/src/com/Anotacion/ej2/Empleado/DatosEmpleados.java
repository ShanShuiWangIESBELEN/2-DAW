package com.Anotacion.ej2.Empleado;

import java.lang.annotation.*;


@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DatosEmpleados {
        EmpleadoAn[] value();

}
