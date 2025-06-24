package Lesson8;

import java.util.List;

public class RoboCallTest06 {
    public static void main(String[] args) {
        List<Person> p1 = Person.createShortList();

        p1.forEach(p -> System.out.println(p));
    }
}
