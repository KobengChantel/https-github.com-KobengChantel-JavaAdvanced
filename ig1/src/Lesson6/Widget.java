package Lesson6;

// Widget class implements the SalesCalcs interface
public class Widget implements SalesCalcs {

  // Instance variables
  private String name = "Widget";     // Default name
  private double salesPrice = 0;      // Price per unit
  private double cost = 0;            // Cost per unit
  private long quantity = 0;          // Number of units sold

  // Constructor to initialize the Widget's values
  public Widget(double salesPrice, double cost, long quantity) {
    this.salesPrice = salesPrice;
    this.cost = cost;
    this.quantity = quantity;
  }

  // Return the name of the item
  @Override
  public String getName() {
    return this.name;
  }

  // Calculate and return total sales revenue
  @Override
  public double calcSalesPrice() {
    return this.salesPrice * this.quantity;
  }

  // Calculate and return total cost
  @Override
  public double calcCost() {
    return this.cost * this.quantity;
  }

  // Calculate and return profit (sales - cost)
  @Override
  public double calcProfit() {
    return this.calcSalesPrice() - this.calcCost();
  }
}
