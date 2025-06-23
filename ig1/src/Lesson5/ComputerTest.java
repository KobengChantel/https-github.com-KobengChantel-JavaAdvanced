package Lesson5;

// This class tests the Computer class by setting its power state and printing the state and its description.

public class ComputerTest {
    public static void main(String[] args) {
        Computer comp = new Computer();                      // Create a new Computer instance
        comp.setState(Computer.PowerState.SUSPENDED);       // Set its power state to SUSPENDED
        System.out.println("Current state: " + comp.getState());             // Print the current power state
        // description method is inside the enum
        // need to get the state first
        System.out.println("Description: " + comp.getState().getDesc());    // Print the description from the enum state
    }
}
