package Lesson8;

import java.util.List;

/**
 * RoboCallTest07 demonstrates filtering a list of Person objects (ages 23 to 65)
 * and simulating phone calls to each filtered person using RoboCall05.
 */
public class RoboCallTest07 {
    public static void main(String[] args) {
        List<Person> pl = Person.createShortList();
        RoboCall05 robo = new RoboCall05();

        System.out.println("\n=== Calling all Drivers Lambda ===");
        // Filter persons aged between 23 and 65 and call each one
        pl.stream()
                .filter(p -> p.getAge() >= 23 && p.getAge() <= 65)
                .forEach(p -> robo.roboCall(p));
    }
}
