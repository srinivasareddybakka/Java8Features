package java8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    public static void main(String[] args) {
        DateFormatExample dateFormatExample=new DateFormatExample();
        dateFormatExample.dateFormatExample1();

    }
    public  void dateFormatExample1(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(formatter);
        System.out.println(date1);
        System.out.println(formattedDate);
        System.out.println(date2);

    }
}
