package java8.completablefuture.discountexample;

import static java.lang.String.format;
import static java8.completablefuture.discountexample.Shop.delay;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote productQuote) {
        System.out.println(" price before appling discount" + productQuote.getPrice());
        return productQuote.getShopName() + " price is " + Discount
                .apply(productQuote.getDiscountCode(), productQuote.getPrice());
    }

    private static String apply(Code discountCode, double price) {
        delay();
        return format(String.valueOf(price * (100 - discountCode.percentage) / 100));
    }

}
