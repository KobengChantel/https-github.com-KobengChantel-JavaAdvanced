package Lesson6;

public class TestAnalyzer {
    public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer){
        for(String currentStr:strList){
            if (analyzer.analyze(currentStr, searchStr)){
                System.out.println("Match: " + currentStr);
            }
        }
    }

    public static void main(String[] args) {
        String[] strList01 =
                {"tomorrow","toto","to","timbukto","the","hello","heat"};
        String searchStr = "to";
        System.out.println("Searching for: " + searchStr);

        // Call concrete class that implments StringAnalyzer


        System.out.println("===Contains===");
        TestAnalyzer.searchArr(strList01, searchStr,
                //third argument is an anonymous inner class (tests functional interface)
                new StringAnalyzer() {
            @Override
            public boolean analyze(String sourceStr, String searchStr) {
                return sourceStr.contains(searchStr);
            }
        });
    }
}
