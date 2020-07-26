package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample1 {
    public static void main(String[] args) {

        FilterExample1 filterExample1 = new FilterExample1();
        filterExample1.filterExample1();
        filterExample1.filterExample2();

    }

    // stream operation to get the vegetains Dishes
    public void filterExample1() {

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
        List<Dish> vegetarianDishes = new ArrayList<>();
        List<Dish> nonVegDishes = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            } else {
                nonVegDishes.add(dish);
            }

        }
        menu.stream().filter(Dish::isVegetarian).forEach(System.out::println);
    }

    // filter operation to get the data based on condition
    public void filterExample2() {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320).collect(Collectors.toList());
        System.out.println(filteredMenu);

        List<Dish> limitedMenu = specialMenu.stream().filter(dish -> dish.getCalories() > 300).limit(2).collect(Collectors.toList());
        System.out.println(limitedMenu);

        List<Dish> limitedmenuSkip = specialMenu.stream().filter(dish -> dish.getCalories() > 300).skip(2).collect(Collectors.toList());
        System.out.println(limitedmenuSkip);

        List<Dish> dishes = specialMenu.stream().filter(dish -> dish.getType() == Dish.Type.OTHER).limit(2).collect(Collectors.toList());
        System.out.println(dishes);
    }


}
