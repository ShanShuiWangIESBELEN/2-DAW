import java.util.Scanner;

public class Ejercicio21RepasoCondicional {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double nota1, nota2, media;
        String rec;
        System.out.println("Introduzca la nota del primer examen");
        nota1 = teclado.nextDouble();

        System.out.println("Introduzca la nota del primer examen");
        nota2 = teclado.nextDouble();

        media = (nota1+nota2) / 2;

        if (media >= 5){
            System.out.println("Tu nota es: " + media);
        } else{
            System.out.println("¿Cual ha sido el resultado de la recuperacion?");
            rec = teclado.next();
            if (rec.equalsIgnoreCase("apto")){
                System.out.println("Tu nota de programacion es: 5");
            } else {
                System.out.println("Tu nota de programacion es: " + media);
            }
        }
    }
}