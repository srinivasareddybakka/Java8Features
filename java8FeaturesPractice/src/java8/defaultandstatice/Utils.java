package java8.defaultandstatice;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(
                l -> {
                    l.setAbsoulteSize(10, 20);
                }
        );
    }
}
