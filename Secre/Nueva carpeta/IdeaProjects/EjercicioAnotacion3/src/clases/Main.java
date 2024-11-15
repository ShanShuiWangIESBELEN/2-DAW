package clases;

public class Main {
    public static void main(String[] args) {

        AgendaSemana agenda = AgendaSemana.cargadorAgendaContexto();
        System.out.println(agenda.toString());

    }
}
