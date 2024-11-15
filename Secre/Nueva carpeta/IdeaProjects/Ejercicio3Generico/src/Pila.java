public class Pila <T> {

    private int numElementos;
    private T pila[];

    public Pila(int tam) {
        this.pila = (T[]) new Object[tam];
        this.numElementos = 0;
    }

    public boolean estaVacia(){

        if (numElementos == 0) {
            return true;
        }
        return false;
    }

    public T extraer(){

        T t = null;

        if (!estaVacia()) {
            t = pila[numElementos - 1];
            numElementos--;
        }

        return t;
    }

    public T primero(){

        T t = null;

        if (!estaVacia()) {
            t = pila[numElementos - 1];
        }

        return t;
    }

    public boolean anadir(T e){

        if (numElementos < pila.length) {
            pila[numElementos] = e;
            numElementos++;
            return true;
        }
        return false;
    }

    public String toString(){
        String cadena = "";

            for (int i = 0; i < numElementos; i++) {
                cadena += pila[i].toString() + " ";
            }
        return cadena;
    }
}
