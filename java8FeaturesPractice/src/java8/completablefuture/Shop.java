package java8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    Random random = new Random();

    public Future<Double> getPriceAsync(String product) {
       /* CompletableFuture completableFuture = new CompletableFuture();
        new Thread(
                () -> {
                    try {
                        double price = calculatePrice(product);
                        completableFuture.complete(price);
                    } catch (Exception e) {
                        completableFuture.completeExceptionally(e);
                    }

                }
        ).start();
        return completableFuture;
*/


        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);

    }

    private static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
