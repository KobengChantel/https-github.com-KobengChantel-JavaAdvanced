package Lesson4.ex04_2_exercise;

public class Engineer extends Employee2 {
    Engineer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void engineerMethod(){
        System.out.println("Method specific to Engineer class");
    }
}
