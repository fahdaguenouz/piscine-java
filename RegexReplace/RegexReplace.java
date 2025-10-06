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

    // Obfuscate username
    if (username.matches(".*[-._].*")) {
        int first = Math.min(
            username.indexOf('.') >= 0 ? username.indexOf('.') : Integer.MAX_VALUE,
            Math.min(
                username.indexOf('-') >= 0 ? username.indexOf('-') : Integer.MAX_VALUE,
                username.indexOf('_') >= 0 ? username.indexOf('_') : Integer.MAX_VALUE
            )
        );
        username = username.substring(0, first + 1) + "***";
    } else if (username.length() > 3) {
        username = username.substring(0, username.length() - 3) + "***";
    }

    // Obfuscate domain
    if (domain.matches("\\w+\\.\\w+\\.\\w+")) {
        domain = domain.replaceAll("^(\\w+)\\.(\\w+)\\.(\\w+)$", "*******.$2.*******");
    } else if (domain.matches("\\w+\\.\\w+")) {
        if (!domain.matches("\\w+\\.(com|org|net)")) {
            domain = domain.replaceAll("^(\\w+)\\.(\\w+)$", "*******.**");
        } else {
            domain = domain.replaceAll("^(\\w+)\\.(\\w+)$", "*******.$2");
        }
    }

    return username + "@" + domain;
}



}