package ch1;

// This program prints the lyrics of the "Ten Green Bottles" song, counting down from 10 to 0 with correct singular/plural wording.

public class BottleSong {
  public static void main(String[] args) {
    int bottlesNum = 10;  // starting number of bottles
    String word = "bottles"; // word to use for plural or singular bottle(s)

    while (bottlesNum > 0) {

      if (bottlesNum == 1) {
        word = "bottle"; // switch to singular form when only one bottle remains
      }

      // print the repeated lines of the song with the current number of bottles
      System.out.println(bottlesNum + " green " + word + ", hanging on the wall");
      System.out.println(bottlesNum + " green " + word + ", hanging on the wall");
      System.out.println("And if one green bottle should accidentally fall,");

      bottlesNum = bottlesNum - 1; // decrement the bottle count

      // print the remaining bottles line, or no bottles if none left
      if (bottlesNum > 0) {
        System.out.println("There'll be " + bottlesNum +
                " green " + word + ", hanging on the wall");
      } else {
        System.out.println("There'll be no green bottles, hanging on the wall");
      }
    }
  }
}
