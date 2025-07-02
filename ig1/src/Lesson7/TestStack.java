package Lesson7;

import java.util.ArrayDeque;
import java.util.Deque;

// Demonstrates stack behavior (LIFO) using a Deque with push and pop operations.
public class TestStack {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        // Last In First Out (LIFO) behavior

        // Push elements onto the stack
        stack.push("one");
        stack.push("two");
        stack.push("three");

        // Print current stack contents (top element first)
        System.out.println(stack);

        // Pop and print all elements from the stack until empty
        int size = stack.size() - 1;
        while (size >= 0) {
            System.out.println(stack.pop());
            size--;
        }
    }
}
