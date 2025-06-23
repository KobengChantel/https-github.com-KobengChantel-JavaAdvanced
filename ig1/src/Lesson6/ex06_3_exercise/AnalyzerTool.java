package Lesson6.ex06_3_exercise;

// AnalyzerTool class that uses an Analyzer functional interface to find and print matching strings.

public class AnalyzerTool {

  /**
   * Iterates over the array of strings and prints those that match the condition
   * defined by the provided Analyzer implementation.
   *
   * @param strList   Array of strings to search through
   * @param searchStr String to search for
   * @param analyzer  Functional interface that defines the analyze method
   */
  public void showResult(String[] strList, String searchStr, StringAnalyzer analyzer) {
    for (String current : strList) {
      if (analyzer.analyze(current, searchStr)) {
        System.out.println("Match: " + current);
      }
    }
  }
}
