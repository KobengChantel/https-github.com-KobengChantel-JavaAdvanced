package ch10;

public class TestFormats {
  public static void main(String[] args) {
    // Use underscores in numeric literals for readability
    long myBillion = 1_000_000_000;

    // Format the number with commas separating thousands (e.g., "1,000,000,000")
    String s = String.format("%,d", myBillion);

    // Print the formatted string to the console
    System.out.println(s);
  }
}
