package java8.completablefuture.discountexample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DiscountExample {

    Shop myFav1 = new Shop("My Fav1");
    Shop myFav2 = new Shop("My Fav2");

    List<Shop> shops = (List<Shop>) Arrays.asList(myFav1, myFav2);

    public static void main(String[] args) {

        DiscountExample discountExample = new DiscountExample();
        System.out.println(" using normal streams ");
        System.out.println(" System time before calling findPrice method" + System.currentTimeMillis());
        System.out.println(discountExample.findPrices("fav"));
        System.out.println(" System time after calling findPrice method" + System.currentTimeMillis());

        System.out.println(" using normal Completable future ");
        System.out.println(" System time before calling findPricesUsingCompletable method" + System.currentTimeMillis());
        System.out.println(discountExample.findPricesUsingCompletable("fav"));
        System.out.println(" System time after calling findPricesUsingCompletable method" + System.currentTimeMillis());


    }

    public List<String> findPrices(String product) {

        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());

    }

    // finding the Price using completableFuture

    public List<String> findPricesUsingCompletable(String product) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<CompletableFuture<String>> findprices = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executorService))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executorService)
                ))
                .collect(Collectors.toList());

        return findprices.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    
}
