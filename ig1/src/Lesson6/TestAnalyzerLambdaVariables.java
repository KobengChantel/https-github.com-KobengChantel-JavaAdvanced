package Lesson6;

public class TestAnalyzerLambdaVariables {
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

        StringAnalyzer contains = (target, srchStr) -> target.contains(srchStr);
        StringAnalyzer startsWith = (target, srchStr) -> target.startsWith(srchStr);

        System.out.println("===Contains===");
        TestAnalyzer.searchArr(strList01, searchStr, contains);;

        System.out.println("===Starts With===");
        TestAnalyzer.searchArr(strList01, searchStr, startsWith); ;
    }
}
