
public class StringReplace {
 public static String replace(String s, char target, char replacement) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == target) {
                result += replacement;  
            } else {
                result += letter;      
            }
        }
        return result;
    }

   
    public static String replace(String s, String target, String replacement) {
        return s.replace(target, replacement);
    }
}