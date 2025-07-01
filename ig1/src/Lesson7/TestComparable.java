package Lesson7;

import java.util.Set;
import java.util.TreeSet;

// Demonstrates using ComparableStudent objects in a TreeSet, which sorts students by name automatically due to Comparable implementation.
public class TestComparable {
    public static void main(String[] args) {
        Set<ComparableStudent> studentList = new TreeSet<>();

        // Adding ComparableStudent objects; TreeSet uses compareTo to keep them sorted by name
        studentList.add(new ComparableStudent("Thomas Jefferson", 1111, 3.8));
        studentList.add(new ComparableStudent("John Adams", 2222, 3.9));
        studentList.add(new ComparableStudent("George Washington", 3333, 3.4));
        studentList.add(new ComparableStudent("John Adams", 4444, 3.0)); // Duplicate name handled by compareTo

        // Print sorted students by name
        for (ComparableStudent student : studentList) {
            System.out.println(student);
        }

        /*
        // Alternative approach using a List and Collections.sort():
        List<ComparableStudent> studentList = new ArrayList<>();
        studentList.add(new ComparableStudent("Thomas Jefferson", 1111, 3.8));
        studentList.add(new ComparableStudent("John Adams", 2222, 3.9));
        studentList.add(new ComparableStudent("John Adams", 4444, 3.0));
        studentList.add(new ComparableStudent("George Washington", 3333, 3.4));
        Collections.sort(studentList);
        for (ComparableStudent student : studentList) {
            System.out.println(student);
        }
        */
    }
}
