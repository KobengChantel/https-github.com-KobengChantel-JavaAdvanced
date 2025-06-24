package Lesson6.ex06_3_exercise;

// Demonstrates usage of AnalyzerTool with various lambda expressions for string analysis.

public class LambdaTest {
  public static void main(String[] args) {
    String[] strList01 = {
            "tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"
    };

    AnalyzerTool stringTool = new AnalyzerTool();
    String searchStr = "to";

    System.out.println("Searching for: " + searchStr);

    System.out.println("==Contains==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.contains(s));  // Checks if string contains searchStr

    System.out.println("==Starts With==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.startsWith(s));  // Checks if string starts with searchStr

    System.out.println("==Equals==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.equals(s));  // Checks if string equals searchStr

    System.out.println("==Ends With==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.endsWith(s));  // Checks if string ends with searchStr

    System.out.println("==Less than 5==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.contains(s) && t.length() < 5);  // Contains and length < 5

    System.out.println("==Greater than 5==");
    stringTool.showResult(strList01, searchStr,
            (t, s) -> t.contains(s) && t.length() > 5);  // Contains and length > 5
  }
}
