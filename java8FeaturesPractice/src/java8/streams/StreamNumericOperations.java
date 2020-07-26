package java8.streams;

import java.util.Arrays;
import java.util.List;

public class StreamNumericOperations {
    public static void main(String[] args) {
        StreamNumericOperations streamNumericOperations = new StreamNumericOperations();
        streamNumericOperations.numericStreamExample1();

    }

    public void numericStreamExample1() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // calculating the total no of calaries

        int calaries = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(calaries);

        //alternative way of calculating total no of calaries

        int calaries1 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calaries1);
    }
}
