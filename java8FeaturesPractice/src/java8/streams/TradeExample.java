package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TradeExample {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*
        1 Find all transactions in the year 2011 and sort them by value (small to high).
        2 What are all the unique cities where the traders work?
        3 Find all traders from Cambridge and sort them by name.
        4 Return a string of all traders’ names sorted alphabetically.
        5 Are any traders based in Milan?
        6 Print the values of all transactions from the traders living in Cambridge.
        7 What’s the highest value of all the transactions?
        8 Find the transaction with the smallest value.

         */

        // Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> sortByNumber = transactions.stream().filter(trans -> trans.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(sortByNumber);

        // What are all the unique cities where the traders work?

        List<String> uniqueCitiesTradesWork = transactions.stream().map(trader -> trader.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(uniqueCitiesTradesWork);

        //  Find all traders from Cambridge and sort them by name.

        List<Transaction> sortByName = transactions.stream().filter(dist -> dist.getTrader().getCity().equals("Cambridge")).
                sorted(Comparator.comparing(transaction -> transaction.getTrader().getName())).collect(Collectors.toList());
        System.out.println(sortByName);

        // Return a string of all traders’ names sorted alphabetically.

        List<String> allTraders = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().collect(Collectors.toList());
        System.out.println(allTraders);

        // Are any traders based in Milan?
        List<Transaction> anyTraderOfMilan = transactions.stream().filter(trans -> trans.getTrader().getCity().equals("Milan")).collect(Collectors.toList());
        System.out.println(anyTraderOfMilan);

        //  Print the values of all transactions from the traders living in Cambridge.

        List<Integer> allTransactionsByCambrige = transactions.stream().filter(trans -> trans.getTrader().getCity().equals("Cambridge")).
                map(Transaction::getValue).collect(Collectors.toList());
        System.out.println(allTransactionsByCambrige);

        //What’s the highest value of all the transactions?

        Optional<Integer> hightestValueTransaction = transactions.stream().map(trans -> trans.getValue()).reduce(Integer::max);
        System.out.println(hightestValueTransaction);

        //Find the transaction with the smallest value.
        Optional<Integer> smallValueTransaction = transactions.stream().map(trans -> trans.getValue()).reduce(Integer::min);
        System.out.println(smallValueTransaction);


    }
}
