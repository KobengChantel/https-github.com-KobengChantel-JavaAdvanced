package Lesson5;

// This class demonstrates how the final keyword affects object references in Java.

public class TestFinalObject {
    public static void main(String[] args) {
        final Employee emp = new Employee(400, "Betty", "20202-785933", 6000); // emp is a final reference to an Employee object
        Employee emp2 = new Employee(151, "Tom", "444-44-4444", 8000);          // emp2 is a regular Employee reference

        emp.setEmpId(100);  // Allowed: modifying the state of the final object is okay
        System.out.println(emp);  // Prints emp details

        System.out.println(emp2); // Prints emp2 details

        // emp = emp2;          // NOT allowed: cannot reassign a final reference to point to another object
        // System.out.println(emp);
    }
}
