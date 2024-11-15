import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Main {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        // 1 Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor).
        List<Transaction> tran2011 = transactions.stream()
                                                  .filter(transaction -> transaction.getAnio() == 2011)
                                                  .sorted(comparing(Transaction::getValor))
                                                  .toList();


        // 2 ¿Cuáles son todas las ciudades (sin repetición) donde trabajan los traders?

        List<String> ciudad = transactions.stream()
                                            .map(transaction -> transaction.getTrader().getCiudad())
                                            .distinct()
                                            .toList();

        // O mediante toSet

        Set<String> setCiudad = transactions.stream()
                                            .map(transaction -> transaction.getTrader().getCiudad())
                                            .collect(toSet());



        // 3 Encuentre todos los traders de Cambridge y ordénelos por nombre.
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCiudad().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getCiudad))
                .toList();


        // 4 Devuelva los nombres de todos los traders ordenados alfabéticamente en una sola cadena







    }

    }
