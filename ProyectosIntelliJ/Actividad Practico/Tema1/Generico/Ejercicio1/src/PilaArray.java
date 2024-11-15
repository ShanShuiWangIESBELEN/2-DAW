
//3.Implementa una pila utilizando como atributos un array genérico
// y un entero que cuente el número de objetos insertados.
// La clase se debe llamar PilaArray y tiene los mismos métodos que la pila
// del ejercicio anterior.

public class PilaArray<T> implements ColeccionSimpleGenerica<T> {
    private Object[] array;
    private int contador;
    private static final int CAPACIDAD_INICIAL = 10;

    public PilaArray() {
        array = new Object[CAPACIDAD_INICIAL];
        contador = 0;
    }

    @Override
    public boolean estaVacia() {
        return contador == 0;
    }

    @Override
    public T extraer() {
        if (estaVacia()) {
            return null;
        }
        T elemento = (T) array[contador - 1];
        contador--;
        return elemento;
    }

    @Override
    public T primero() {
        if (estaVacia()) {
            return null;
        }
        return (T) array[contador - 1];
    }

    @Override
    public void anadir(T ele1) {

        if (contador == array.length) {
            aumentarCapacidad();
        }
        array[contador] = ele1;
        contador++;
    }

    private void aumentarCapacidad() {
        Object[] nuevoArray = new Object[array.length * 2];
        System.arraycopy(array, 0, nuevoArray, 0, array.length);
        array = nuevoArray;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = contador - 1; i >= 0; i--) {
            resultado += array[i].toString() + " ";
        }
        return resultado;
    }
}

