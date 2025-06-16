package appB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// This class tests the behavior of the TestMe class and demonstrates how to disable a test using @Disabled.

class TestMeTest {

  @Test
  void shouldReturnAMessage() {
    // given – expected value to compare with actual output
    String expectedMessage = "The message";

    // when – create an instance of TestMe with the expected message
    TestMe testMe = new TestMe(expectedMessage);

    // then – assert that getMessage() returns the correct message
    Assertions.assertEquals(expectedMessage, testMe.getMessage());
  }

  @Test
  @Disabled("This test isn't finished")
  void thisTestIsForIgnoring() {
    // This test is disabled and will be skipped when the test suite runs
    Assertions.fail("Fails on purpose");
  }

}
