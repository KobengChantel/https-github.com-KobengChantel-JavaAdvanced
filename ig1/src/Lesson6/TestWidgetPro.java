package Lesson6;

public class TestWidgetPro {
    public static void main(String[] args) {
        // Create an instance of WidgetPro using the constructor with parameters:
        // salesPrice = 700.0, cost = 180.0, unitsSold = 300, widgetType = "Poppit"
        WidgetPro wp = new WidgetPro(700.0, 180.0, 300L, "Poppit");

        // Print the widget type
        System.out.println(wp.getWidgetType());

        // Calculate and print the profit using calcProfit()
        System.out.println("Profit: " + wp.calcProfit());
    }
}
