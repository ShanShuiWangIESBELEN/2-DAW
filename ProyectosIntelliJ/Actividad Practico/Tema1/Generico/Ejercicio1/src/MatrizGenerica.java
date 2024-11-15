public class MatrizGenerica<T> {
    //constructor que recibe por parámetro el número de filas y columnas de la matriz
    private T[][] matriz;
    private int filas;
    private int columnas;

    public MatrizGenerica(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = (T[][]) new Object[filas][columnas];
    }

    public void set(int fila, int columna, T elemento) {
        matriz[fila][columna] = elemento;
    }

    public T get(int fila, int columna) {
        return matriz[fila][columna];
    }

    public int columnas() {
        return columnas;
    }

    public int filas() {
        return filas;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                s += matriz[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

}

