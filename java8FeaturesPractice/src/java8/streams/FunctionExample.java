package java8.streams;

import java.util.function.BiFunction;

import static java8.streams.Multiplication.*;

public class FunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> product = (a, b) -> multiply(a, b);
        int pr = product.apply(11, 5);
        int a=10,b=5;
        System.out.println("Product of given number is: "+pr);
    }
}


class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}