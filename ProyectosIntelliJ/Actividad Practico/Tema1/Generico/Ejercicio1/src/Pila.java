

import java.util.LinkedList;

public class Pila<T> implements ColeccionSimpleGenerica<T> {

    private LinkedList<T> lista;

    public Pila() {
        this.lista = new LinkedList<>();
    }

    @Override
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    @Override
    public T extraer() {
        T elemento = null;
        if (!estaVacia()) {
            return lista.removeFirst();
        }
        return elemento;
    }

    @Override
    public T primero() {
        T elemento = null;
        if (!estaVacia()) {
            elemento = lista.getFirst();
        }
        return elemento;
    }

    @Override
    public void anadir(T ele1) {
        lista.addFirst(ele1);
    }

    @Override
    public String toString() {
        return "Pila: " + lista.toString();
    }
}

