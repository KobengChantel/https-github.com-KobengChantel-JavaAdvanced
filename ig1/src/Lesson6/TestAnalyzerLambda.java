package Lesson6;

public class TestAnalyzerLambda {
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

        System.out.println("===Contains===");
        TestAnalyzer.searchArr(strList01, searchStr,
                //third argument is a LAMBDA EXPRESSION (tests functional interface)
                (target,srchStr) -> target.contains(srchStr));
        ;

        System.out.println("===Starts With===");
        TestAnalyzer.searchArr(strList01, searchStr,
                //third argument is a LAMBDA EXPRESSION (tests functional interface)
                (target,srchStr) -> target.startsWith(srchStr));
        ;
    }
}
