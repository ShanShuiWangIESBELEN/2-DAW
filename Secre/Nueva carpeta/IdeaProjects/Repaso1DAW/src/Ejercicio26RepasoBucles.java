import java.util.Scanner;

public class Ejercicio26RepasoBucles {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String num, dig, res = "El digito se encuentra en la posicion: ";

        System.out.println("Introduzca un numero: ");
        num = teclado.next();

        System.out.println("Introduzca un digito: ");
        dig = teclado.next();

        String[] digitos = num.split("");

        for (int i = 0; i < digitos.length; i++) {
            if (digitos[i].equals(dig)){
                res += (i + 1) + " - ";
            }
        }
        System.out.println(res);
    }
}
