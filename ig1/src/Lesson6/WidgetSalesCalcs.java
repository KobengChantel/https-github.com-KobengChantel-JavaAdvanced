package Lesson6;

//interfaces can be extended (widgetSalesCalcs is the sub-interface)
public interface WidgetSalesCalcs extends /*parent interface*/SalesCalcs{
  public String getWidgetType();
}
