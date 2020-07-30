package java8.optional;

public class OptionalExample1 {
    public static void main(String[] args) {
        OptionalExample1 optionalExample1 = new OptionalExample1();
        System.out.println(optionalExample1.normalWayofNullCheck(null));

    }

    // normal way of checking null pointer exception

    public String normalWayofNullCheck(Person person) {
        if (person != null) {
            Car car = person.getCar();

            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }

        }
        return "Unknown";
    }


}
