package Lesson7;

// This program demonstrates boxing and unboxing between primitive int and the Integer wrapper class, including manual and automatic conversions.
public class AutoBox {
    public static void main(String[] args) {
        // uses wrapper class Integer
        Integer intObject = new Integer(1);
        int intPrimitive = 2;

        Integer tempInteger;
        int tempPrimitive;

        // manually boxes primitive int to Integer object
        tempInteger = new Integer(intPrimitive);
        // manually unboxes Integer object to primitive int
        tempPrimitive = (int) intObject.intValue();

        // automatic boxing: primitive int to Integer
        tempInteger = intPrimitive;
        // automatic unboxing: Integer to primitive int
        tempPrimitive = intObject;

        System.out.println("Integer: " + tempInteger + " int: " + tempPrimitive);
    }
}
