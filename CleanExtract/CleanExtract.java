public class CleanExtract {
    public static String extract(String s) {

        String[] parts = s.split("\\|");

        String result = "";

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();

            int first = part.indexOf('.');
            int last = part.lastIndexOf('.');

            String extracted = "";

            if (first != -1 && last != -1 && first < last) {

                extracted = part.substring(first + 1, last).trim();
            } else if (first != -1) {

                extracted = part.substring(first + 1).trim();
            } else if (last != -1) {

                extracted = part.substring(0, last).trim();
            } else {

                extracted = part.trim();
            }

            if (!extracted.isEmpty()) {
                if (!result.isEmpty()) {
                    result += " ";
                }
                result += extracted;
            }
        }
        return result ;
    }
}
