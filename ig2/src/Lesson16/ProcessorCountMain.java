package Lesson16;

// This class prints out the number of available processors (CPU cores) on the system.
public class ProcessorCountMain {
    public static void main(String[] args) {
        // Counting the number of available processors
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor count: " + count);
    }
}
