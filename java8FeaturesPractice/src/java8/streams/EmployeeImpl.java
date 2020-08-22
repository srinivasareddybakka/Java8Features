package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeImpl {
    public static void main(String[] args) {
        Address addr1 = new Address("Banglore", 560100);
        Address addr2 = new Address("Hyderabad", 580100);
        Address addr3 = new Address("Delhi", 360500);
        List<Employee> employeeList = Arrays.asList(
                new Employee("a", 25000, addr1),
                new Employee("b", 10000, addr2),
                new Employee("c", 45000, addr3)
        );
        
        employeeList.sort((add1,add2)->add1.getAddress().getPincode()-add2.getAddress().getPincode());
        System.out.println(employeeList);

        employeeList.stream().sorted((add1,add2)->add1.getAddress().getPincode()-add2.getAddress().getPincode());
        System.out.println(employeeList);

        Optional<Employee> employeelIst=employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println(employeelIst);

    }
}
