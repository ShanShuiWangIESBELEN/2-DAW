package repasoopp;

public class RepasoOPP {

    public static void main(String[] args) {
        alumnos s1 = new alumnos();
        s1.nombre = "Jose";
        s1.lengua = 10;
        s1.matematica = 10;
        
        s1.demostrarNota();
        s1.demostrarNotaMedia();

        alumnos s2 = new alumnos();
        s2.nombre = "Ana";
        s2.lengua = 5;
        s2.matematica = 7;
        
        s2.demostrarNota();
        s2.demostrarNotaMedia();
        
    }

}
