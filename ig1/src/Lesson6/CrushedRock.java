package Lesson6;

// Class representing a product "Crushed Rock" implementing sales calculations.

public class CrushedRock implements SalesCalcs {
  private String name = "Crushed Rock";  // Product name
  private double salesPrice = 0;          // Price per pound
  private double cost = 0;                // Cost per pound
  private double weight = 0;              // Weight in pounds

  // Constructor initializes price, cost, and weight
  public CrushedRock(double salesPrice, double cost, double weight) {
    this.salesPrice = salesPrice;
    this.cost = cost;
    this.weight = weight;
  }

  // Returns the product name
  @Override
  public String getName() {
    return this.name;
  }

  // Calculates total sales price based on price per pound and weight
  @Override
  public double calcSalesPrice() {
    return this.salesPrice * this.weight;
  }

  // Calculates total cost based on cost per pound and weight
  @Override
  public double calcCost() {
    return this.cost * this.weight;
  }

  // Calculates profit as sales price minus cost
  @Override
  public double calcProfit() {
    return this.calcSalesPrice() - this.calcCost();
  }
}
