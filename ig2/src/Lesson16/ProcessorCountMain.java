package Lesson16;

public class ProcessorCountMain {
    public static void main(String[] args) {
        //counting the numbers of processor
        int count = Runtime.getRunTime().availableProcessors();
        System.out.println("Processor count: " + count);
    }
}
