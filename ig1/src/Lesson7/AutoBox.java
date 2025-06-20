package Lesson7;

public class AutoBox {
    public static void main(String[] args) {
        //uses wrapper class Integer
        Integer intObject = new Integer(1);
        int intPrimitive = 2;

        Integer tempInteger;
        int tempPrimitive;

        //makes primitive int an Integer object
        tempInteger = new Integer(intPrimitive);
        //makes an Integer object a primitive int
        tempPrimitive = (int) intObject.intValue();

        tempInteger = intPrimitive; // Auto box
        tempPrimitive = intObject;  // Auto unbox

        System.out.println("Integer: " + tempInteger + " int: " + tempPrimitive);
    }
}
