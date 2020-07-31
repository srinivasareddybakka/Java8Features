package java8.date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        PeriodExample periodExample=new PeriodExample();
        periodExample.periodExample1();

    }

    public void periodExample1() {
        Period period = Period.between(LocalDate.of(2020, 07, 11), LocalDate.now());
        System.out.println(" get Days "+period.getDays());
    }
}
