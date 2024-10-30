package DummiesBook.Book5.chapter2_RegularExpression;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class DroidPattern {
    public static void main(String[] args) {}
        private static Pattern droidPattern;
        private static boolean validDroidName(String droid)
        {
            if (droidPattern == null)
            {
                String regex = "(\\w\\d-\\w\\d)|"
                        + "(\\w-\\d\\w\\w)";
                droidPattern = Pattern.compile(regex);
            }
            Matcher m = droidPattern.matcher(droid);
            return m.matches();

    }
}
