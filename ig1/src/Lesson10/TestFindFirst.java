package Lesson10;

import java.util.List;
import java.util.Optional;

public class TestFindFirst {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        //optional allows the result to be empty(can be a result or null)
        //can assign stream to a variable
        Optional<Employee> result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .findFirst();

        if(result.isPresent()) {
            result.get().print();
        }
    }
}
