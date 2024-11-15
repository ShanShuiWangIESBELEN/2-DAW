package clases;

import anotaciones.TareaAnotacion;

import java.util.ArrayList;
import java.util.List;

@TareaAnotacion(titulo = "Empresa e Iniciativa Emprendedora", descripcion = "Exposición", dia = "Lunes", hora = "8:15")
@TareaAnotacion(titulo = "Diseño de interfaces Web", descripcion = "Figma", dia = "Lunes", hora = "10:15")
@TareaAnotacion(titulo = "Desarrollo web en entorno servidor", descripcion = "Ejercicio anotaciones", dia = "Lunes", hora = "12:45")
public class AgendaSemana {

    private List<Tarea> tareas;

    public AgendaSemana() {
        this.tareas = new ArrayList<>();
    }

    public void addTarea(Tarea t) {
        tareas.add(t);
    }

    public static AgendaSemana cargadorAgendaContexto() {

        AgendaSemana agendaPrueba = new AgendaSemana();

        TareaAnotacion[] tareasAnotaciones = agendaPrueba.getClass().getAnnotationsByType(TareaAnotacion.class);

        for (int indice = 0; indice < tareasAnotaciones.length; indice++) {
            agendaPrueba.addTarea(new Tarea(tareasAnotaciones[indice].titulo(),
                    tareasAnotaciones[indice].descripcion(),
                    tareasAnotaciones[indice].dia(),
                    tareasAnotaciones[indice].hora()));
        }
        return agendaPrueba;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName() + " Tarea: " + this.tareas.toString();
    }
}
