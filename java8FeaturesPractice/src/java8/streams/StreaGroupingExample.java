package java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreaGroupingExample {
    public static void main(String[] args) {
        StreaGroupingExample streamGroupingExample = new StreaGroupingExample();
        streamGroupingExample.countExample();

    }

    public void countExample() {
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

        // total no of Dishes
        Long totalNoOfDishes = menu.stream().collect(Collectors.counting());
        System.out.println(totalNoOfDishes);

        // total no of Dishes alternative way

        Long totalNoDishes = menu.stream().count();
        System.out.println(totalNoDishes);

        // totoal no of Calaried
        int calaried = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(calaried);

        // average of Calaries
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        // finding sum, count, max, min,average of calaried

        IntSummaryStatistics intSummaryStatisticsOfCalaried = menu.stream().
                collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatisticsOfCalaried);

        // concating all the Dished Names

        String names=menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(names);


        //mostCalarieDish from menu

        Optional<Dish> mostCalarieDish=menu.stream().collect(reducing(
                (d1,d2)-> d1.getCalories() > d2.getCalories() ? d1:d2));
        System.out.println(mostCalarieDish);

        // finding total no of calaries using collect utility
        Integer totalNoofCalaries = menu
                .stream().collect(reducing(0,Dish::getCalories,Integer::sum));
        System.out.println(totalNoofCalaries);



    }
}
