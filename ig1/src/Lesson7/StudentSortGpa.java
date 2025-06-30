package Lesson7;

import java.util.Comparator;

// Comparator implementation to sort Student objects in descending order by their GPA.
public class StudentSortGpa implements Comparator<Student> {

    // Compares two students by GPA, returning positive if s1's GPA is less (to sort descending)
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getGpa() < s2.getGpa()) {
            return 1;  // s1 has lower GPA, so it comes after s2
        } else if (s1.getGpa() > s2.getGpa()) {
            return -1; // s1 has higher GPA, so it comes before s2
        } else {
            return 0;  // GPAs are equal
        }
    }
}
