package com.Anotacion.ej3;

import java.lang.annotation.*;


@Documented
@Inherited
@Repeatable(Tareas.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface TareaAn {

    String titulo();
    String descripcion();
    String dia();
    String hora();

}
