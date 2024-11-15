package repasoopp;

public class alumnos {
    String nombre;
    double lengua;
    double matematica;
    
    public void demostrarNota(){
        System.out.println("la suma de las notas de " 
                + nombre + " es: " + (lengua + matematica));
        
    }
     public void demostrarNotaMedia(){
        System.out.println("la nota media de " 
                + nombre + " es: " + (lengua + matematica)/2);
        
    }
    
}
