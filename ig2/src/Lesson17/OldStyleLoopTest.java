package Lesson17;

import java.util.List;

public class OldStyleLoopTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double sum = 0;

        for(Employee e:eList){
            //filtering using an if statement
            if(e.getState().equals("CO") &&
                    e.getRole().equals(Role.EXECUTIVE)){
                e.printSummary();
                sum += e.getSalary();
            }
        }
        //formatted print
        System.out.printf("Total CO Executive Pay: $%,9.2f %n", sum);
    }
}
