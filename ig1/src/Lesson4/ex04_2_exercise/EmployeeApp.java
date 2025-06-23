package Lesson4.ex04_2_exercise;

// This class tests employee subclasses, demonstrates polymorphism, and prints employee information.

public class EmployeeApp {
    public static void main(String[] args) {

        // Create instances of different employee types
        Admin adm = new Admin("Dianne Jacobs", 25, 3000.00);
        Engineer eng = new Engineer("Netta Gallant", 40, 9000.00);
        Manager man = new Manager("Geroma Kayser", 31, 7500.00, "Finance");
        Director dir = new Director("Ginny Sayles", 31, 6250.00, "Marketing");

        // Casting a Director object to a Manager reference (upcasting)
        Manager man2 = (Manager) dir;

        System.out.println("---Admin---");
        System.out.println(adm.printInfo());

        System.out.println("---Engineer---");
        System.out.println(eng.printInfo());

        System.out.println("---Manager---");
        System.out.println(man.printInfo());

        // Using the casted Director as a Manager reference to print info
        System.out.println(man2.printInfo());
    }
}
