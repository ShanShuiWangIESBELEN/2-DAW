
public class Main {
    public static void main(String[] args) {

        Pila pila = new Pila();

        pila.anadir(1);
        pila.anadir(2);
        pila.anadir(3);
        pila.anadir(4);
        pila.anadir(5);
        pila.anadir(6);

        System.out.println(pila.extraer());
        System.out.println(pila.estaVacia());
        System.out.println(pila.primero());
        System.out.println(pila.toString());
    }
}