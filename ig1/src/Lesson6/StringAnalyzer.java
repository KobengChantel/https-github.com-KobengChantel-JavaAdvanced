package Lesson6;

// Functional interface for analyzing whether a source string matches a search string by some criteria.

@FunctionalInterface
public interface StringAnalyzer {
  // Returns true if sourceStr meets criteria relative to searchStr
  boolean analyze(String sourceStr, String searchStr);
}
