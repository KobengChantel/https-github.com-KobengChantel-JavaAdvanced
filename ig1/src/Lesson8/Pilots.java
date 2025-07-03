package Lesson8;

import java.util.function.Predicate;

/**
 * Predicate implementation to test if a Person qualifies as a pilot
 * based on age between 23 and 65 inclusive.
 *
 * @author oracle
 */
public class Pilots implements Predicate<Person> {

    @Override
    public boolean test(Person p){
        // Return true if person's age is between 23 and 65 inclusive
        return p.getAge() >= 23 && p.getAge() <= 65;
    }
}
