public class Main {
    public static void main(String[] args) {
        MatrizGenerica<Integer> matrizEnteros = new MatrizGenerica<Integer>(4, 2);

        int contador = 1;
        for (int i = 0; i < matrizEnteros.filas(); i++) {
            for (int j = 0; j < matrizEnteros.columnas(); j++) {
                matrizEnteros.set(i, j, contador);
                contador++;
            }
        }
        System.out.println("Matriz completa:");
        System.out.println(matrizEnteros.toString());

        System.out.println("Contenido de la celda en (1, 2): " + matrizEnteros.get(1, 1)); // Debería mostrar 4
    }
}
