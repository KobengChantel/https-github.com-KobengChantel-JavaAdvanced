package Lesson6;

// Class representing the product "Red Paint" implementing sales calculations.

public class RedPaint implements SalesCalcs {
  private String name = "Red Paint";  // Product name
  private double salesPrice = 0;      // Price per gallon
  private double cost = 0;            // Cost per gallon
  private double gallons = 0;         // Quantity in gallons

  // Constructor initializes sales price, cost, and quantity
  public RedPaint(double salesPrice, double cost, double gallons) {
    this.salesPrice = salesPrice;
    this.cost = cost;
    this.gallons = gallons;
  }

  // Returns the product name
  @Override
  public String getName() {
    return this.name;
  }

  // Calculates total sales price based on price per gallon and gallons sold
  @Override
  public double calcSalesPrice() {
    return this.salesPrice * this.gallons;
  }

  // Calculates total cost based on cost per gallon and gallons sold
  @Override
  public double calcCost() {
    return this.cost * this.gallons;
  }

  // Calculates profit as total sales price minus total cost
  @Override
  public double calcProfit() {
    return this.calcSalesPrice() - this.calcCost();
  }
}
