package Lesson6;

public class TestWidgetPro {
    public static void main(String[] args) {
        WidgetPro wp = new WidgetPro(700.0,180.0,300L,"Poppit");
        System.out.println(wp.getWidgetType());
        System.out.println("Profit: " + wp.calcProfit());

    }
}
