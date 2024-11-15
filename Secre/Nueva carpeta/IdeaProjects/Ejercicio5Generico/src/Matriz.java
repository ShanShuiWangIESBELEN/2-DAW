import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Matriz <T>{

    private Set<Celda<T>> matriz;
    private int fila;
    private int columna;

    public Matriz(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        matriz = new TreeSet<>();
    }

    public boolean set(int f, int c, T e){

        return matriz.add(new Celda(f, c, e));
    }

    public T get(int f, int c){

        T e;

        Iterator it = matriz.iterator();

        for (:
             ) {
            
        }

        return e;
    }

    public int columnas(){
        return getColumna();
    }

    public int filas(){
        return getFila();
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
