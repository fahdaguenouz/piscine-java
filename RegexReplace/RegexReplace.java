import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        if (s == null) {
            return null; 
        }
          return s.replaceAll("\\b(\\d+)(cm|€)(?![²])\\s?", "$1");
    }

    public static String obfuscateEmail(String s) {
        if (s == null) {
            return null; 
        }

        // Split email into username and domain
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s; // Return unchanged if not a valid email format
        }
        String username = parts[0];
        String domain = parts[1];

        // Obfuscate username
        if (username.matches(".*[-._].*")) {
            // Hide character after -, ., or _
            username = username.replaceAll("([-._])(.)", "$1*");
        } else if (username.length() > 3) {
            // Hide 3 characters if length > 3
            if (username.length() >= 6) {
                username = username.substring(0, username.length() - 3) + "***";
            } else {
                username = username.substring(0, username.length() - 3) + "***";
            }
        }

        // Obfuscate domain
        if (domain.matches("\\w+\\.\\w+\\.\\w+")) {
            // Format: third.second.top -> hide third and top
            domain = domain.replaceAll("^(\\w+)\\.(\\w+)\\.(\\w+)$", "*******.$2.*******");
        } else if (domain.matches("\\w+\\.\\w+")) {
            // Format: second.top -> check if top is com, org, net
            if (!domain.matches("\\w+\\.(com|org|net)")) {
                domain = domain.replaceAll("^(\\w+)\\.(\\w+)$", "*******.**");
            } else {
                domain = domain.replaceAll("^(\\w+)\\.(\\w+)$", "*******.$2");
            }
        }

        return username + "@" + domain;
    }
}