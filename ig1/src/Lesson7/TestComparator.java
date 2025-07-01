package Lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Demonstrates sorting a list of Student objects by name and by GPA using Comparator implementations.
public class TestComparator {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(3);

        // Comparator to sort students by name
        Comparator<Student> sortName = new StudentSortName();
        // Comparator to sort students by GPA (descending)
        Comparator<Student> sortGpa = new StudentSortGpa();

        // Add students to the list
        studentList.add(new Student("Thomas Jefferson", 1111, 3.8));
        studentList.add(new Student("George Washington", 3333, 3.4));
        studentList.add(new Student("John Adams", 2222, 3.9));

        System.out.println("Sorted by Name: ");
        Collections.sort(studentList, sortName);  // Sort by name
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println("Sorted by GPA: ");
        Collections.sort(studentList, sortGpa);  // Sort by GPA descending
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
