public interface ColeccionSimpleGenerica<T> {
    boolean estaVacia();
    T extraer();
    T primero();
    void anadir(T ele1);

    String toString();
}
