package java8.streams;

import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectiongSubGroupExample {
    public static void main(String[] args) {
        CollectiongSubGroupExample collectiongSubGroupExample = new CollectiongSubGroupExample();
        collectiongSubGroupExample.SubGroupExample1();

    }

    public void SubGroupExample1() {
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

        //  total count of individual types
        Map<Dish.Type, Long> totalCountOfTypeOfDishes = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(totalCountOfTypeOfDishes);

        // highest number of calaries name of individual type
        Map<Dish.Type, Optional<Dish>> highestCalariesName = menu.stream()
                .collect(
                        groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories)))
                );
        System.out.println(highestCalariesName);

        // other way of getting higest calried name name of individual type

        Map<Dish.Type, Dish> higestCalariedName = menu.stream()
                .collect(
                        groupingBy(Dish::getType,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(higestCalariedName);

        //total no of calaries of individual type
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelType = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                }, toSet()

                        ))
                );
        System.out.println(caloricLevelType);

        // alternative of total no of calaries of individual type
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT; },
                                toCollection(HashSet::new) )));
        System.out.println(caloricLevelsByType);

    }
}
