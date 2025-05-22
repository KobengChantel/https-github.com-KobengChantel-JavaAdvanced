package Lesson4;

public class OverrideTest {
    public static void main(String[] args) {
        Manager ngr = new Manager(151, "Tom", "444-44-4444", 8000, "admin");
        Employee emp = new Employee( 400, "Betty", "20202-785933", 6000);

        System.out.println("Type Manager\n" + ngr.getDetails());
        System.out.println();
        System.out.println("Type Employee\n" + emp.getDetails());
    }
}
