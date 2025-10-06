import java.util.regex.Pattern;

public class RegexMatch {

    public static boolean containsOnlyAlpha(String s) {
        if (s == null) {
            return false; 
        }
        return s.matches("^[a-zA-Z]*$");
    }

    public static boolean startWithLetterAndEndWithNumber(String s) {
        if (s == null) {
            return false; 
        }
        return s.matches("^[a-zA-Z].*[0-9]$");
    }
    
    public static boolean containsAtLeast3SuccessiveA(String s) {
        if (s == null) {
            return false; 
        }
        return s.matches(".*AAA.*");
    }
}