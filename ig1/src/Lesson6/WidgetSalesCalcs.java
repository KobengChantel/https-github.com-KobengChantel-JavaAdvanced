package Lesson6;

// interfaces can be extended — WidgetSalesCalcs is a sub-interface of SalesCalcs
public interface WidgetSalesCalcs extends SalesCalcs {

  // Additional method specific to widgets with types (e.g., "Poppit", "Gadget", etc.)
  public String getWidgetType();
}
