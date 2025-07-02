package Lesson6;

public class TestSales {
  public static void main(String[] args) {
    // Create a CrushedRock object using the CrushedRock class reference
    CrushedRock rock1 = new CrushedRock(12, 10, 50);

    // Create another CrushedRock object but assign it to a SalesCalcs interface reference
    SalesCalcs rock2 = new CrushedRock(12, 10, 50);

    // Call the calcSalesPrice method on both
    System.out.println("Sales Price: " + rock1.calcSalesPrice());  // Calls method via concrete class
    System.out.println("Sales Price: " + rock2.calcSalesPrice());  // Calls method via interface

    // Create an array of SalesCalcs to hold various items
    SalesCalcs[] itemList = new SalesCalcs[5];

    // Populate the array with objects of different classes implementing SalesCalcs
    itemList[0] = new CrushedRock(12.0, 10.0, 50.0);
    itemList[1] = new CrushedRock(8.0, 6.0, 10.0);
    itemList[2] = new RedPaint(10.0, 8.0, 25.0);
    itemList[3] = new Widget(6.0, 5.0, 10);
    itemList[4] = new Widget(14.0, 12.0, 20);

    // Print a simple header
    System.out.println("==Sales Report==");

    // Call a method that processes and prints the array of items (polymorphic behavior)
    SalesCalcs.printItemArray(itemList);
  }
}
