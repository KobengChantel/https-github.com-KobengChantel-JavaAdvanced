package ch7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// This test class creates a Wolf object, calls its behaviors, and verifies the object is not null.
class WolfTest {

  @Test
  void createWolf() {
    // Instantiate a new Wolf object
    Wolf w = new Wolf();

    // Call Wolf's specific behavior methods
    w.makeNoise();
    w.roam();
    w.eat();
    w.sleep();

    // Assert that the Wolf object was successfully created and is not null
    assertNotNull(w);
  }
}
