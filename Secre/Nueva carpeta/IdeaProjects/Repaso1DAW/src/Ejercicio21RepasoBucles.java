import java.util.Scanner;

public class Ejercicio21RepasoBucles {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int num, conp = 0, coni = 0, sumi = 0, mayor = Integer.MIN_VALUE;
        double media = 0;
        do {
            System.out.println("Introduzca un numero: ");
            num = teclado.nextInt();
            if (num > 0) {
                if (num % 2 == 0) {
                    if (num > mayor) {
                        mayor = num;
                    }
                    conp++;
                } else {
                    coni++;
                    sumi = sumi + num;
                    media = sumi / coni;
                }
            }
        }while (num > 0);
        System.out.println("Se han introducido: " + (conp + coni) + " numeros");
        System.out.println("La media de los impares es de: " + media);
        System.out.println("El mayor de los pares es: " + mayor);
    }
}
