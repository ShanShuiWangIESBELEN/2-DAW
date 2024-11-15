
import java.util.*;

import com.Anotacion.ej3.Tarea;
import com.Anotacion.ej3.TareaAn;
import com.Anotacion.ej3.Tareas;


@TareaAn(
        titulo = "Compras",
        descripcion = "Hacer compras en supermercado",
        dia = "Lunes", hora = "10:00"
)
@TareaAn(
        titulo = "Cita",
        descripcion = "Cita con amigo",
        dia = "Martes", hora = "18:00"
)



public class AgendaSemana {

    private List<Tarea> tarea = new ArrayList<>();

    public AgendaSemana(List<TareaAn> tareaAns) {
        this.tarea = tarea;
    }

    public List<Tarea> getTareas() {
        return tarea;
    }

    public void setTareas(List<TareaAn> tareaAns) {
        this.tarea = tarea;
    }


    public void cargadorDeContenido(){

        Tareas tareasAnotacion = AgendaSemana.class.getAnnotation(Tareas.class);

    }


    public static void main(String[] args) {
        List<TareaAn> tareas = new ArrayList<>();
        AgendaSemana agenda = new AgendaSemana(tareas);

        Tareas tareasAnotacion = AgendaSemana.class.getAnnotation(Tareas.class);
        if (tareasAnotacion != null) {
            tareas.addAll(Arrays.asList(tareasAnotacion.value()));
        }

        agenda.mostrarTareas();
    }
}
