
public class Main {
    public static void main(String[] args) {

        Pila p = new Pila(5);

        System.out.println(p.estaVacia());
        p.anadir(1);
        p.anadir(2);
        p.anadir(3);
        p.anadir(4);
        p.anadir(5);

        System.out.println(p.toString());

        System.out.println(p.extraer());
        System.out.println(p.primero());

    }
}