package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class PartitionExample {
    public static void main(String[] args) {
        PartitionExample  partitionExample=new PartitionExample();
        partitionExample.partitionExample1();

    }

    public void partitionExample1() {
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


        // getting partition of dishes
        Map<Boolean, List<Dish>> partionDishes = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian)
                );
        System.out.println(partionDishes);
        List<Dish> vegmenu=partionDishes.get(true);
        System.out.println(vegmenu);

        // alternative of getting partion of Dishes
        List<Dish> vegmenu1=menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegmenu1);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);


        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }
}
