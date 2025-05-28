package Lesson5;


public class TestFinalObject {
    public static void main(String[] args) {
        final Employee emp = new Employee(400, "Betty", "20202-785933", 6000);
        Employee emp2 = new Employee(151, "Tom", "444-44-4444", 8000);
        emp.setEmpId(100);
        System.out.println(emp);
        System.out.println(emp2);
        //emp = emp2; (can't change final object value)
        //System.out.println(emp);
    }
}
