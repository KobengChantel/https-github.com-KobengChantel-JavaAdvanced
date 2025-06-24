package Lesson6;

// Interface defining sales calculations and reporting for products.

public interface SalesCalcs {
  // Static constant for report title
  public static final String reportTitle = "\n==Static List Report==";

  // Method to get product name
  public String getName();

  // Calculate total sales price
  public double calcSalesPrice();

  // Calculate total cost
  public double calcCost();

  // Calculate total profit
  public double calcProfit();

  // Static method to print reports for an array of SalesCalcs items
  public static void printItemArray(SalesCalcs[] items) {
    System.out.println(reportTitle);
    for (SalesCalcs item : items) {
      System.out.println("--" + item.getName() + " Report--");
      System.out.println("Sales Price: " + item.calcSalesPrice());
      System.out.println("Cost: " + item.calcCost());
      System.out.println("Profit: " + item.calcProfit());
    }
  }

  // Default method to print a report for this particular item
  public default void printItemReport() {
    System.out.println("--" + this.getName() + " Report--");
    System.out.println("Sales Price: " + this.calcSalesPrice());
    System.out.println("Cost: " + this.calcCost());
    System.out.println("Profit: " + this.calcProfit());
  }
}
