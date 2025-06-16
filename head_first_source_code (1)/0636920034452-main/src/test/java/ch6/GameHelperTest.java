package ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// This test class verifies the conversion between character and integer representations, coordinate translations,
// and placement validation for a grid-based game managed by GameHelper.

class GameHelperTest {

  @Test
  void shouldGetCharAsIntValue() {
    // 'a' character ASCII value is 97
    char a = 'a';
    assertEquals(97, a);
  }

  @Test
  void shouldConvertIntToCharA() {
    // 0 + 97 = 'a', converting column index to corresponding char
    int columnIndex = 0;
    assertEquals('a', columnIndex + 97);
  }

  @Test
  void shouldConvertIntToCharG() {
    // 6 + 97 = 'g', converting column index to corresponding char
    int columnIndex = 6;
    assertEquals('g', columnIndex + 97);
  }

  @Test
  void shouldConvertIndexLocationToAlphaCoords() {
    // Convert grid index to alphanumeric coordinates, e.g., 26 -> "f3"
    GameHelper gameHelper = new GameHelper();
    assertEquals("f3", gameHelper.getAlphaCoordsFromIndex(26));
    assertEquals("f6", gameHelper.getAlphaCoordsFromIndex(47));
  }

  @Test
  void shouldNotLetStartupGoOverRightEdge() {
    // Validate horizontal placement does not overflow right edge of grid
    GameHelper gameHelper = new GameHelper();
    assertFalse(gameHelper.startupFits(new int[]{26, 27, 28}, GameHelper.HORIZONTAL_INCREMENT));
  }

  @Test
  void shouldAllowVerticalStartups() {
    // Validate vertical placement fits within grid bounds
    GameHelper gameHelper = new GameHelper();
    assertTrue(gameHelper.startupFits(new int[]{26, 33, 40}, GameHelper.VERTICAL_INCREMENT));
  }

  @Test
  void shouldNotLetStartupGoOverBottom() {
    // Validate vertical placement does not overflow bottom of grid
    GameHelper gameHelper = new GameHelper();
    assertFalse(gameHelper.startupFits(new int[]{47, 54, 61}, GameHelper.VERTICAL_INCREMENT));
  }

  @Test
  void shouldBeAbleToPlaceHorizontalIntoEmptyGridStartingFromValidLocation() {
    // Confirm horizontal startup coords are available in an empty grid
    GameHelper gameHelper = new GameHelper();
    int[] startupCoords = new int[]{0, 1, 2};
    boolean success = gameHelper.coordsAvailable(startupCoords);
    assertTrue(success);
    assertArrayEquals(new int[]{0, 1, 2}, startupCoords);
  }

  @Test
  void shouldBeAbleToPlaceVerticalIntoEmptyGridStartingFromValidLocation() {
    // Confirm vertical startup coords are available in an empty grid
    GameHelper gameHelper = new GameHelper();
    boolean success = gameHelper.coordsAvailable(new int[]{0, 7, 14});
    assertTrue(success);
  }

  @Test
  void shouldNotBeAbleToPlaceHorizontalIntoGridAtSameLocationAsExisting() {
    // Save horizontal position and check that overlapping coords are not available
    GameHelper gameHelper = new GameHelper();
    gameHelper.savePositionToGrid(new int[]{8, 9, 10}); // occupies positions starting at B1
    System.out.println(gameHelper);
    boolean success = gameHelper.coordsAvailable(new int[]{9, 10, 11}); // overlaps with saved position
    System.out.println(gameHelper);
    assertFalse(success);
  }

  @Test
  void shouldNotBeAbleToPlaceVerticalIntoGridAtSameLocationAsExisting() {
    // Save horizontal position and check vertical coords overlapping it are rejected
    GameHelper gameHelper = new GameHelper();
    gameHelper.savePositionToGrid(new int[]{8, 9, 10}); // occupies positions starting at B1
    System.out.println(gameHelper);
    int[] startupCoords = new int[]{1, 9, 16}; // overlaps at position 9 (A1 vertical)
    boolean success = gameHelper.coordsAvailable(startupCoords);
    System.out.println(gameHelper);
    assertFalse(success);
  }

  @Test
  void shouldTurnIndexIntoAlphaCoords() {
    // Reconfirm converting index 26 to "f3"
    GameHelper gameHelper = new GameHelper();
    assertEquals("f3", gameHelper.getAlphaCoordsFromIndex(26));
  }
}
