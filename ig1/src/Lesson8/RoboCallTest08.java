package Lesson8;

import java.util.List;
import java.util.function.Predicate;

public class RoboCallTest08 {
    public static void main(String[] args) {
        List<Person> pl = Person.createShortList();
        RoboCall05 robo = new RoboCall05();

        //Predicates - passed into filter method
        Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        System.out.println("\n===Calling all Drivers Lambda===");
        pl.stream()
                //filter ages between 23 and 65
                .filter(allPilots)
                .forEach(p-> robo.roboCall(p));
    }
}
