package Lesson7;

import java.util.Comparator;

// Comparator implementation to sort Student objects alphabetically by their names.
public class StudentSortName implements Comparator<Student> {

    // Compares two students by their names lexicographically
    @Override
    public int compare(Student s1, Student s2) {
        int result = s1.getName().compareTo(s2.getName());
        if (result != 0) {
            return result; // Return comparison result if names differ
        } else {
            return 0;  // Names are equal; could add further comparison if needed
        }
    }
}
