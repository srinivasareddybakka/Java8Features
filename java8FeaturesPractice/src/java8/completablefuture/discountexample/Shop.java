package java8.completablefuture.discountexample;

import java.util.Random;

public class Shop {
    Random random = new Random();

    public Shop(String letsSaveBig) {
    }

    public String getPrice(String product) {

        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];

        return String.format(" %s:%.2f:%s", product, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
