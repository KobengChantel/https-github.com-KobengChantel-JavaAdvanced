package Lesson6;

// This class demonstrates the use of lambda expressions to implement a functional interface
public class TestAnalyzerLambda {

    // This method takes an array of strings, a search string, and a StringAnalyzer implementation (via lambda)
    public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer){
        // Loop through each string in the list
        for(String currentStr : strList){
            // Use the analyze method (implemented by lambda) to check for a match
            if (analyzer.analyze(currentStr, searchStr)){
                System.out.println("Match: " + currentStr);  // Print the string if it matches the condition
            }
        }
    }

    public static void main(String[] args) {
        // Define an array of sample strings
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};
        String searchStr = "to";  // Define the search string

        System.out.println("Searching for: " + searchStr);

        System.out.println("===Contains===");
        // Pass a lambda expression that checks if the string contains the search string
        TestAnalyzer.searchArr(strList01, searchStr,
                (target, srchStr) -> target.contains(srchStr)
        );

        System.out.println("===Starts With===");
        // Pass a lambda expression that checks if the string starts with the search string
        TestAnalyzer.searchArr(strList01, searchStr,
                (target, srchStr) -> target.startsWith(srchStr)
        );
    }
}
