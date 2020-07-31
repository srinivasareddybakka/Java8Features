package java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DatePackage {
    public static void main(String[] args) {
        DatePackage datePackage = new DatePackage();
        datePackage.dateExample1();

    }

    public void dateExample1() {
        LocalDate localDate = LocalDate.of(2020, 07, 30);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int date = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int lengthMonth = localDate.lengthOfMonth();
        boolean leap = localDate.isLeapYear();
        System.out.println(" year :" + year);
        System.out.println(" Month :" + month);
        System.out.println(" date :" + date);
        System.out.println(" dayOfWeek :" + dayOfWeek);
        System.out.println(" lengthMonth :" + lengthMonth);
        System.out.println(" leap :" + leap);

        LocalDate currentdate = LocalDate.now();
        int currentyear = currentdate.getYear();
        Month currentmonth = currentdate.getMonth();
        int currentdate1 = currentdate.getDayOfMonth();
        DayOfWeek currentdayOfWeek = currentdate.getDayOfWeek();
        int currentlengthMonth = currentdate.lengthOfMonth();
        boolean currentleap = currentdate.isLeapYear();
        System.out.println(" currentyear :" + currentyear);
        System.out.println(" currentmonth :" + currentmonth);
        System.out.println(" currentdate1 :" + currentdate1);
        System.out.println(" currentdayOfWeek :" + currentdayOfWeek);
        System.out.println(" currentlengthMonth :" + currentlengthMonth);
        System.out.println(" currentleap :" + currentleap);


    }
}
