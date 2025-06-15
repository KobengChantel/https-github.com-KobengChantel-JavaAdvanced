package ch12;

import java.util.List;

/**
 * This class demonstrates correct and incorrect uses of `for` loops and the `forEach()` method
 * for iterating through Java `List` collections, highlighting common mistakes like off-by-one errors,
 * misuse of array vs. List methods, and invalid loop syntax.
 */
public class Ch10c {

  // Enhanced for-loop: iterates over each color and prints it
  void forExample() {
    List<String> allColors = List.of("Red", "Blue", "Yellow");
    for (String color : allColors) {
      System.out.println(color);
    }
  }

  // Lambda-based forEach loop: prints each color
  static void forEachExample() {
    List<String> allColors = List.of("Red", "Blue", "Yellow");
    allColors.forEach(color -> System.out.println(color));
  }

  public static void main(String[] args) {
    forEachExample();
  }

  // ❌ Starts from index 1, so 1 is skipped, output: 2, 3, 4, 5
  static void badFor1() {
    List<Integer> nums = List.of(1, 2, 3, 4, 5);
    for (int i = 1; i < nums.size(); i++) {
      System.out.println(nums.get(i));
    }
  }

  // ❌ Causes ArrayIndexOutOfBoundsException because i goes up to size(), which is out of bounds
  static void badFor2() {
    List<Integer> nums = List.of(1, 2, 3, 4, 5);
    for (int i = 0; i <= nums.size(); i++) {
      System.out.println(nums.get(i)); // error at i = 5
    }
  }

  // ❌ Won’t compile: `List` does not have a `.length` property; use `.size()` instead
  static void badFor3() {
//    List<Integer> nums = List.of(1, 2, 3, 4, 5);
//    for (int i = 0; i <= nums.length; i++) {  // .length is invalid here
//      System.out.println(nums.get(i));
//    }
  }

  // ❌ Prints the whole list each time instead of individual numbers
  static void badFor4() {
    List<Integer> nums = List.of(1, 2, 3, 4, 5);
    for (Integer num : nums) {
      System.out.println(nums); // should be: System.out.println(num);
    }
  }

  // ❌ Won’t compile: "int" is a keyword, cannot be used as a variable name
  static void badFor5() {
//    List<Integer> nums = List.of(1, 2, 3, 4, 5);
//    for (Integer int : nums) {  // invalid: "int" is a reserved keyword
//      System.out.println(nums);
//    }
  }

  // ✅ Correct forEach using lambda to print each number
  static void forEach() {
    List<Integer> nums = List.of(1, 2, 3, 4, 5);
    nums.forEach(num -> System.out.println(num));
  }
}
