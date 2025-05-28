package Lesson3;

public class ImmutabilityTest {
    public static void main(String[] args) {

        //if there's a constructor
        Employee emp = new Employee(1, "Jada", "12345", 4000.0);
        System.out.println(emp.getName() + "'s current salary R" + emp.getSalary());
        emp.raiseSalary(5000.00);
        System.out.println(emp.getName() + "'s increased salary R" + emp.getSalary());
        emp.changeName("Hazel");

    }
}
