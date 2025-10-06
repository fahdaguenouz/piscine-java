import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("(\\d+)(cm|€)(?!\\S)", "$1");
    }

public static String obfuscateEmail(String s) {
    if (s == null) return null;

    String[] parts = s.split("@");
    if (parts.length != 2) return s;

    String username = parts[0];
    String domain = parts[1];

    // --- Username ---
    if (username.length() > 1) {
        username = username.substring(0, username.length() - 1) + "*";
    } else {
        username = "*";
    }

    // --- Domain ---
    if (domain.matches("\\w+\\.\\w+\\.\\w+")) {
        // three parts
        domain = domain.replaceAll("^(\\w+)\\.(\\w+)\\.(\\w+)$", "*******.$2.***");
    } else if (domain.matches("\\w+\\.\\w+")) {
        // two parts
        domain = domain.replaceAll("^(\\w+)\\.(\\w+)$", "*******.***");
    }

    return username + "@" + domain;
}


}