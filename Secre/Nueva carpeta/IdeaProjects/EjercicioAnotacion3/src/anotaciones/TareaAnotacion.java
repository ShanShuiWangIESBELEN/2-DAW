package anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TareasAnotacion.class)
public @interface TareaAnotacion {

    String titulo();

    String descripcion();

    String dia();

    String hora();

}
