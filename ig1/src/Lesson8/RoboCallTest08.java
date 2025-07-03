package Lesson8;

import java.util.List;
import java.util.function.Predicate;

/**
 * RoboCallTest08 demonstrates using a Predicate<Person> to filter a list and simulate phone calls via RoboCall05.
 */
public class RoboCallTest08 {
    public static void main(String[] args) {
        List<Person> pl = Person.createShortList();
        RoboCall05 robo = new RoboCall05();

        // Predicate to select all pilots (ages between 23 and 65 inclusive)
        Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        System.out.println("\n=== Calling all Drivers Lambda ===");
        // Filter the list using the predicate and call each filtered person
        pl.stream()
                .filter(allPilots)
                .forEach(p -> robo.roboCall(p));
    }
}
