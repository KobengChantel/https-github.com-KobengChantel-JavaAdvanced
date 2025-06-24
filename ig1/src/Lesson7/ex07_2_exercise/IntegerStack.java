package Lesson7.ex07_2_exercise;

import java.util.ArrayDeque;
import java.util.Deque;

// This class implements a simple integer stack using a deque, supporting push, pop, and peek operations with output demonstrating stack behavior.
public class IntegerStack {

    private Deque<Integer> data = new ArrayDeque<Integer>();

    // Adds an element to the top of the stack
    public void push(Integer e) {
        data.addFirst(e);
    }

    // Removes and returns the top element of the stack; prints a warning if stack is empty
    public Integer pop() {
        if (data.isEmpty()) {
            System.out.println("Stack is empty");
        }
        return data.removeFirst();
    }

    // Returns the top element without removing it
    public Integer peek() {
        return data.peekFirst();
    }

    // Returns the string representation of the stack contents
    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();

        // Push integers 0 to 4 onto the stack
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("After pushing 5 elements: " + stack);

        // Pop the top element and display the stack
        int e = stack.pop();
        System.out.println("Popped element: " + e);
        System.out.println("After popping 1 element: " + stack);

        // Peek at the top element without removing it and display the stack
        int top = stack.peek();
        System.out.println("Peeked element: " + top);
        System.out.println("After peeking 1 element: " + stack);
    }
}
