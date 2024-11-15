package com.Anotacion.ej3;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited

public @interface Tareas {
    TareaAn[] value();
}