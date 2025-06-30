package Lesson6;

// This class demonstrates how lambda expressions can be assigned to variables
// that implement a functional interface (StringAnalyzer)
public class TestAnalyzerLambdaVariables {

    // Method to search through a string array using a given StringAnalyzer strategy
    public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer){
        for(String currentStr : strList){
            // If the analyzer (lambda) returns true, it's a match
            if (analyzer.analyze(currentStr, searchStr)){
                System.out.println("Match: " + currentStr);
            }
        }
    }

    public static void main(String[] args) {
        // Sample list of strings to search through
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};
        String searchStr = "to";  // The string we're looking for

        System.out.println("Searching for: " + searchStr);

        // Assigning lambda expressions to variables implementing the functional interface
        // This one checks if the target string contains the search string
        StringAnalyzer contains = (target, srchStr) -> target.contains(srchStr);

        // This one checks if the target string starts with the search string
        StringAnalyzer startsWith = (target, srchStr) -> target.startsWith(srchStr);

        System.out.println("===Contains===");
        // Pass the 'contains' lambda to the method
        TestAnalyzer.searchArr(strList01, searchStr, contains);

        System.out.println("===Starts With===");
        // Pass the 'startsWith' lambda to the method
        TestAnalyzer.searchArr(strList01, searchStr, startsWith);
    }
}
