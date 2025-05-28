package Lesson5;

public class ComputerTest {
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.setState(Computer.PowerState.SUSPENDED);
        System.out.println("Current state: " + comp.getState());
        //description method is inside the enum
        //need to get the state first
        System.out.println("Description: " + comp.getState().getDesc());
    }
}
