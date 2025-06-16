package appB;

import java.util.HashMap;
import java.util.Map;

// This code demonstrates different ways to retrieve or add entries in a Map and shows incrementing a value in a Map, illustrating modern and older Java idioms.

public class MapMethods {
  // Uses computeIfAbsent to get the Actions object for a user or create it if absent
  void addOrGetCustomer(String usr) {
    Map<String, Actions> custActs = new HashMap<>();
    Actions actions = custActs.computeIfAbsent(usr, name -> new Actions(name));
    // do something with actions
  }

  // Traditional way to get or create the Actions object for a user
  void addOrGetCustomerOld(String usr) {
    Map<String, Actions> custActs = new HashMap<>();
    // probably other stuff happens here...
    Actions actions = custActs.get(usr);
    if (actions == null) {
      actions = new Actions(usr);
      custActs.put(usr, actions);
    }
    // do something with actions
  }

  // Attempts to increment a metric's count if it exists in the map
  void incrementMetricWeCareAbout(String metric) {
    Map<String, Integer> metrics = new HashMap<>();
    // probably other stuff happens here...

    if (metrics.containsKey(metric)) {
      Integer integer = metrics.get(metric);
      metrics.put(metric, ++integer);
    }
  }

  // Simple inner class to hold user actions
  private class Actions {
    private String username;

    public Actions(String username) {
      this.username = username;
    }
  }
}
