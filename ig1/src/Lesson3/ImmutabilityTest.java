package Lesson3;

public class ImmutabilityTest {
    public static void main(String[] args) {

        //if there's a constructor
        Employee emp = new Employee(1, "Chantel", "12345", 4000.00 );
        System.out.println(emp.getName() + " 'S current currency R" + emp.getSalary());
    emp.raiseSalary(5000.00);
        System.out.println(emp.getName() + " 'S current currency R" + emp.getSalary());
        emp.changeName("Melly");
        System.out.println(emp.getName() + "is the employee's new name");
    }
}
