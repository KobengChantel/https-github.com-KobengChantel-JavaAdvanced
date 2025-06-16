package appB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// This test class demonstrates how to use Map methods like computeIfPresent, replaceAll, containsKey/get/put, and forEach in Java.

class MapMethodsTest {

  @Test
  void shouldOnlyAddMetricsThatWeCareAbout() {
    // Create and initialize a Map with three metrics
    Map<String, Integer> metrics = new HashMap<>();
    metrics.put("metric 1", 0);
    metrics.put("metric 2", 0);
    metrics.put("metric 3", 0);

    // Safely increment "metric 1" only if it exists
    Integer newValue = metrics.computeIfPresent("metric 1", (key, value) -> ++value);
    System.out.println("metrics = " + metrics);

    // Assertions to verify the update
    Assertions.assertEquals(1, metrics.get("metric 1"));
    Assertions.assertEquals(1, newValue);

    // Attempt to increment "metric 4", which doesn't exist — so nothing happens
    metrics.computeIfPresent("metric 4", (s, integer) -> ++integer);
    System.out.println("metrics = " + metrics);
    Assertions.assertFalse(metrics.containsKey("metric 4"));
  }

  @Test
  void shouldOnlyAddMetricsThatWeCareAboutOld() {
    // Same goal as the previous test but using traditional containsKey + get + put
    Map<String, Integer> metrics = new HashMap<>();
    metrics.put("metric 1", 0);
    metrics.put("metric 2", 0);
    metrics.put("metric 3", 0);

    String key = "metric 1";
    if (metrics.containsKey(key)) {
      Integer value = metrics.get(key);
      metrics.put(key, ++value);
    }

    System.out.println("metrics = " + metrics);
    Assertions.assertEquals(1, metrics.get("metric 1"));
  }

  @Test
  void shouldSeeWhatReplaceAllLooksLike() {
    // Initializes the map and uses replaceAll to increment all values by 1
    Map<String, Integer> metrics = new HashMap<>();
    metrics.put("metric 1", 0);
    metrics.put("metric 2", 0);
    metrics.put("metric 3", 0);

    // Applies the lambda to every entry (incrementing all values)
    metrics.replaceAll((key, value) -> ++value);

    // Check if all values were incremented correctly
    Assertions.assertEquals(1, metrics.get("metric 1"));
    Assertions.assertEquals(1, metrics.get("metric 2"));
    Assertions.assertEquals(1, metrics.get("metric 3"));
  }

  @Test
  void shouldSeeWhatForEachLooksLike() {
    // Initialize the map and use forEach to print key-value pairs
    Map<String, Integer> metrics = new HashMap<>();
    metrics.put("metric 1", 0);
    metrics.put("metric 2", 0);
    metrics.put("metric 3", 0);

    // Print each entry using forEach
    metrics.forEach((key, value) -> {
      System.out.println("key = " + key);
      System.out.println("value = " + value);
    });
  }
}
