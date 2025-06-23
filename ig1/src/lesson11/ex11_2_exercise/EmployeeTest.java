package lesson11.ex11_2_exercise;

public class EmployeeTest {

    public static void main(String[] args) throws InvalidOperationException {
        Employee e1 = new Employee(0, "bob", "builder", 1250.50f);
        EmployeeImpl emp = new EmployeeImpl();
        emp.add(e1);
        Employee e2 = new Employee(1, "harry", "potter", 1250.50f);
        emp.add(e2);
        Employee e3 = new Employee(5, "harry", "potter", 1250.50f);
        emp.add(e3);
        Employee[] allEmps = emp.getAllEmployees();
        for (Employee employee : allEmps) {
            System.out.println(employee + "\n");
        }

        Employee e = emp.findById(5);
        if (e != null) {
            System.out.println(emp + "\n");
        } else {
            System.out.println("\n\nEmployee not found");
        }

        emp.delete(7);


    }


}
