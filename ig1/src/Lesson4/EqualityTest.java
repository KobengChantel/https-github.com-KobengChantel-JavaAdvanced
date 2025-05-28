package Lesson4;

public class EqualityTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee(400, "Betty", "20202-785933", 6000);
        Employee emp2 = new Employee(400, "Betty", "20202-785933", 6000);
        //returns false as it checks the reference not the values
        //returns true when Employee class overrides equals method(we check values specifically)
        System.out.println(emp1.equals(emp2));

        emp1 = emp2;
        System.out.println(emp1.equals(emp2));
    }
}
