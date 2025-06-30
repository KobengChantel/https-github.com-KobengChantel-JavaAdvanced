package Lesson7;

// A simple Student class with fields for name, ID, and GPA, including getters and a string representation.
public class Student {

    private String name;
    private long id = 0;
    private double gpa = 0.0;

    // Constructor to initialize name, id, and GPA
    public Student(String name, long id, double gpa) {
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
}
