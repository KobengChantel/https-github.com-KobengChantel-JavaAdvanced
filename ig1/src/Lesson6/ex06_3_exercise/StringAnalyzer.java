package Lesson6.ex06_3_exercise;

// Functional interface for analyzing strings based on a condition.

@FunctionalInterface
public interface StringAnalyzer {
  // Returns true if target string satisfies the condition with searchStr
  boolean analyze(String target, String searchStr);
}
