package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortCircutExamples {
    public static void main(String[] args) {
        ShortCircutExamples shortCircutExamples = new ShortCircutExamples();
        shortCircutExamples.findAnyExample();
        shortCircutExamples.findFirstExample();

    }

    public void findAnyExample() {
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

        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));
    }

    public void findFirstExample() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = integerList.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst();
        System.out.println(firstSquareDivisibleByThree);
    }
}
