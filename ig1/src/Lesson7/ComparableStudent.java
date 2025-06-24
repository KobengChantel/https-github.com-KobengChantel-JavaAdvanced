package Lesson7;

// A student class that implements Comparable to allow sorting by student name in alphabetical order.
public class ComparableStudent implements Comparable<ComparableStudent> {

    private String name;
    private long id = 0;
    private double gpa = 0.0;

    // Constructor to initialize name, id, and GPA
    public ComparableStudent(String name, long id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Getter for id
    public long getId() {
        return this.id;
    }

    // Getter for GPA
    public double getGpa() {
        return this.gpa;
    }

    // Returns a string representation of the student
    @Override
    public String toString() {
        return "Name: " + this.name + "  ID: " + this.id
                + "  GPA:" + this.gpa;
    }

    // Compares students based on their names lexicographically for sorting
    @Override
    public int compareTo(ComparableStudent s) {
        int result = this.name.compareTo(s.getName());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
