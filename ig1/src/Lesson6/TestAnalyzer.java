package Lesson6;

// Demonstrates searching an array of strings using a StringAnalyzer implementation.

public class TestAnalyzer {

    // Searches the array and prints strings that match according to the analyzer
    public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer) {
        for (String currentStr : strList) {
            if (analyzer.analyze(currentStr, searchStr)) {
                System.out.println("Match: " + currentStr);
            }
        }
    }

    public static void main(String[] args) {
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};
        String searchStr = "to";
        System.out.println("Searching for: " + searchStr);

        System.out.println("===Contains===");
        // Using an anonymous inner class to implement StringAnalyzer
        TestAnalyzer.searchArr(strList01, searchStr,
                new StringAnalyzer() {
                    @Override
                    public boolean analyze(String sourceStr, String searchStr) {
                        return sourceStr.contains(searchStr);
                    }
                }
        );
    }
}
