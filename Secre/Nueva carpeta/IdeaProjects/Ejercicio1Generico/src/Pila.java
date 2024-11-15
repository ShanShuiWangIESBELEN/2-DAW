import java.util.LinkedList;
import java.util.List;

public class Pila <T> implements ColeccionSimpleGenerica<T>{

    private List<T> pila = new LinkedList<>();

    public boolean estaVacia() {
        return pila.isEmpty();
    }

    public T extraer() {
        return pila.remove(pila.size() - 1);
    }

    public T primero() {
        if (!pila.isEmpty()) {
            return pila.get(0);
        }
        return null;
    }

    public boolean anadir(T e) {
        return pila.add(e);
    }

    @Override
    public String toString() {
        String cadena = "";

        for (int i = 0; i < pila.size(); i++) {
            cadena += pila.get(i).toString() + " ";

        }
        return cadena;
    }
}
