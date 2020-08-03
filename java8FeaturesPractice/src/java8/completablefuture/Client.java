package java8.completablefuture;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Shop shop = new Shop();
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my faviourate product");
        long invocationTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        // do some more tasks , like querying other shops
        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println(" do something else");
    }
}
