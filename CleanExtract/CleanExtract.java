public class CleanExtract {
    public static String extract(String s) {

        String[] parts = s.split("\\|");

        String result = "";

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();

            int first = part.indexOf('.');
            int last = part.lastIndexOf('.');

            String word = "";

            if (first != -1 && last != -1 && first < last) {

                word = part.substring(first + 1, last).trim();
            } else if (first != -1) {

                word = part.substring(first + 1).trim();
            } else if (last != -1) {

                word = part.substring(0, last).trim();
            } else {

                word = part.trim();
            }

            if (!word.isEmpty()) {
                if (!result.isEmpty()) {
                    result += " ";
                }
                result += word;
            }
        }
        return result ;
    }
}
