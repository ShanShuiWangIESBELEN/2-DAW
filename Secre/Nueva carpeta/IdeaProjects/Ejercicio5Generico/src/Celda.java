import java.util.Objects;

public class Celda <T> implements Comparable <T>{

    private int fila;
    private int columna;
    private T elem;

    public Celda(int fila, int columna, T elem) {
        this.fila = fila;
        this.columna = columna;
        this.elem = elem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda<?> celda = (Celda<?>) o;
        return fila == celda.fila && columna == celda.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public int compareTo(T o) {
        if (this.fila - o.fila == 0) {
            return this.columna - o.columna;
        }
        return this.fila - o.fila;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
