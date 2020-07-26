package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MapExample1 {
    public static void main(String[] args) {
        MapExample1 mapExample1 = new MapExample1();
        mapExample1.mapExample1();
        mapExample1.mapExample2();
        mapExample1.mapExample3();

    }

    public void mapExample1() {

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

        List<String> getDishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(getDishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordsLength = words.stream().map(String::length).collect(toList());
        System.out.println(wordsLength);

        List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(dishNameLengths);
    }

    public void mapExample2() {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<String> list = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(list);
    }

    public void mapExample3(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        
    }
}
