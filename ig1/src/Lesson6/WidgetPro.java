package Lesson6;

// WidgetPro extends Widget and implements WidgetSalesCalcs interface
public class WidgetPro extends Widget implements WidgetSalesCalcs {

  // Additional property unique to WidgetPro
  private String type;

  // Constructor passes common fields to Widget constructor and sets type
  public WidgetPro(double salesPrice, double cost, long quantity, String type) {
    super(salesPrice, cost, quantity);  // Call parent constructor (Widget)
    this.type = type;                   // Set specific property
  }

  // Getter method to return the widget type
  public String getWidgetType() {
    return type;
  }

  // Inherits calcSalesPrice(), calcCost(), calcProfit(), getName() from Widget
}
