package java8.streams;

import java.util.HashMap;
import java.util.Map;

public class ImprovedMapExample {
    public static void main(String[] args) {
        ImprovedMapExample improvedMapExample=new ImprovedMapExample();
        improvedMapExample.Map1Example();

    }

    public void Map1Example() {

        Map<String, String> map = new HashMap<>();
        map.put("Sri", "Srini");
        map.put("N", "Narendra");

        // normal way of iterating the map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String name1 = entry.getKey();
            String name2 = entry.getValue();
            System.out.println("Firstname " + name1 + " lastname" + name2);
        }

        // using java 8
        map.forEach((name1, name2) -> System.out.println("Firstname " + name1 + " lastname" + name2));


    }
}
