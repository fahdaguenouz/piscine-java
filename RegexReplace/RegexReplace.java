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
    if (parts.length != 2) return s; // invalid email

    String username = parts[0];
    String domain = parts[1];

    // --- Username obfuscation ---
    if (username.matches(".*[._-].*")) {
        // Hide everything after the first special character
        int first = username.indexOf('.');
        if (username.indexOf('_') >= 0 && username.indexOf('_') < first) first = username.indexOf('_');
        if (username.indexOf('-') >= 0 && username.indexOf('-') < first) first = username.indexOf('-');
        username = username.substring(0, first + 1) + "***";
    } else if (username.length() > 1) {
        // Hide only the last character
        username = username.substring(0, username.length() - 1) + "*";
    } else {
        username = "*";
    }

    // --- Domain obfuscation ---
    String[] domainParts = domain.split("\\.");
    if (domainParts.length == 3) {
        // third.second.top -> hide third and top
        domain = "*******." + domainParts[1] + ".***";
    } else if (domainParts.length == 2) {
        // second.top -> hide second and top if top not com/org/net
        String top = domainParts[1];
        if (top.equals("com") || top.equals("org") || top.equals("net")) {
            domain = "*******." + top;
        } else {
            domain = "*******." + "***";
        }
    }

    return username + "@" + domain;
}



}