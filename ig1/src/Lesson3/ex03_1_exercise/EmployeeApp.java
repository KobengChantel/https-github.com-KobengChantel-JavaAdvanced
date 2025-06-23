package Lesson3.ex03_1_exercise;

// This program creates and displays information about different types of employees using inheritance and object-oriented principles.

public class EmployeeApp {
    public static void main(String[] args) {
        // Create an Admin object
        Admin adm = new Admin("Dianne Jacobs", 25, 3000.00);

        // Create an Engineer object
        Engineer eng = new Engineer("Netta Gallant", 40, 9000.00);

        // Create a Manager object with a department
        Manager man = new Manager("Geroma Kayser", 31, 7500.00, "Finance");

        // Create a Director object with a department
        Director dir = new Director("Ginny Sayles", 31, 6250.00, "Marketing");

        // Display admin details
        System.out.println("---Admin---");
        System.out.println(adm.getName() + " our Administrative Assistant, earns R" + adm.getSalary());

        // Display engineer details
        System.out.println("---Engineer---");
        System.out.println("Our company engineer is " + eng.getName());

        // Display manager details
        System.out.println("---Manager---");
        System.out.println(man.getName() + " is the " + man.getDeptName() + " Manager.");

        // Display director details
        System.out.println("---Director---");
        System.out.println(dir.getName() + " is the " + dir.getDeptName() + " Director.");
    }
}
