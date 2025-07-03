package Lesson8;

import java.util.List;

/**
 * RoboCallTest06 demonstrates printing the details of a list of Person objects.
 */
public class RoboCallTest06 {
    public static void main(String[] args) {
        // Create a sample list of Person objects
        List<Person> p1 = Person.createShortList();

        // Print each Person using the overridden toString method
        p1.forEach(p -> System.out.println(p));
    }
}
