package Lesson4.ex04_1_exercise;

// This class tests various employee types by creating their objects and printing their details using the printInfo method.

public class EmployeeApp {
    public static void main(String[] args) {
        // Create an Admin object
        Admin adm = new Admin("Dianne Jacobs", 25, 3000.00);

        // Create an Engineer object
        Engineer eng = new Engineer("Netta Gallant", 40, 9000.00);

        // Create a Manager object with department
        Manager man = new Manager("Geroma Kayser", 31, 7500.00, "Finance");

        // Create a Director object with department
        Director dir = new Director("Ginny Sayles", 31, 6250.00, "Marketing");

        // Print Admin info
        System.out.println("---Admin---");
        System.out.println(adm.printInfo());

        // Print Engineer info
        System.out.println("---Engineer---");
        System.out.println(eng.printInfo());

        // Print Manager info
        System.out.println("---Manager---");
        System.out.println(man.printInfo());

        // Print Director info
        System.out.println("---Director---");
        System.out.println(dir.printInfo());
    }
}
