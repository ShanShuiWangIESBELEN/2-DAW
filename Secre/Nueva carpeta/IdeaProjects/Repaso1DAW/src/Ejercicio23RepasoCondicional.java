import java.math.BigDecimal;
import java.util.Scanner;

public class Ejercicio23RepasoCondicional {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        BigDecimal baseImponible;
        BigDecimal total;
        BigDecimal iva;
        BigDecimal base;
        BigDecimal preIva;
        BigDecimal promo = new BigDecimal("0");
        BigDecimal general = new BigDecimal("0.21");
        BigDecimal reducido = new BigDecimal("0.1");
        BigDecimal superreducido = new BigDecimal("0.04");
        BigDecimal mitad = new BigDecimal("0.5");

        String tiva, cod;


        System.out.println("Introduzca la base imponible: ");
        baseImponible = new BigDecimal(teclado.next());
        base = baseImponible;

        System.out.println("Introduzca el tipo de IVA (general, reducido o superreducido):");
        tiva = teclado.next();
        if (tiva.equalsIgnoreCase("general")){
            iva = baseImponible.multiply(general);
            total = baseImponible.add(iva);
            preIva = total;
        } else if (tiva.equalsIgnoreCase("reducido")) {
            iva = baseImponible.multiply(reducido);
            total = baseImponible.add(iva);
            preIva = total;
        } else {
            iva = baseImponible.multiply(superreducido);
            total = baseImponible.add(iva);
            preIva = total;
        }

        System.out.println("Introduzca el codigo promocional: ");
        cod = teclado.next();

        if (cod.equalsIgnoreCase("mitad")){
            promo = total.multiply(mitad);
            total = total.subtract(promo);
        } else if (cod.equalsIgnoreCase("meno5")) {
            total = total.subtract(new BigDecimal("5"));
            promo = new BigDecimal("5");
        } else if (cod.equalsIgnoreCase("5porc")) {
            total = total.multiply(new BigDecimal("0.95"));
            promo = total.multiply(new BigDecimal("0.05"));
        }

        System.out.println("Base imponible: " + base);
        System.out.println("IVA: " + iva);
        System.out.println("Precio con IVA: " + preIva);
        System.out.println("Codigo promocional: -" + promo);
        System.out.println("Total: " + total);
    }
}

   /* public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double baseImponible, total, iva, promo = 0, base, preIva;
        final double general = 0.21, reducido = 0.1, superreducido = 0.04, mitad = 0.5;
        String tiva, cod;


        System.out.println("Introduzca la base imponible: ");
        baseImponible = teclado.nextDouble();
        base = baseImponible;

        System.out.println("Introduzca el tipo de IVA (general, reducido o superreducido):");
        tiva = teclado.next();
        if (tiva.equalsIgnoreCase("general")){
            iva = baseImponible * general;
            total = baseImponible + iva;
            preIva = total;
        } else if (tiva.equalsIgnoreCase("reducido")) {
            iva = baseImponible * reducido;
            total = baseImponible + iva;
            preIva = total;
        } else {
            iva = baseImponible * superreducido;
            total = baseImponible + iva;
            preIva = total;
        }

        System.out.println("Introduzca el codigo promocional: ");
        cod = teclado.next();

        if (cod.equalsIgnoreCase("mitad")){
            promo = total * mitad;
            total = total - promo;
        } else if (cod.equalsIgnoreCase("meno5")) {
            total = total - 5;
            promo = 5;
        } else if (cod.equalsIgnoreCase("5porc")) {
            total = total * 0.95;
            promo = total * 0.05;
        }

        System.out.println("Base imponible: " + base);
        System.out.println("IVA: " + iva);
        System.out.println("Precio con IVA: " + preIva);
        System.out.println("Codigo promocional: -" + promo);
        System.out.println("Total: " + total);
    }
    */
