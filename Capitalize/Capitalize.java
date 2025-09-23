import java.io.*;
import java.nio.file.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }

        Path inputfile = Path.of(args[0]);
        Path outputfile = Path.of(args[1]);

        String content = Files.readString(inputfile);
        String[] words = content.trim().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.length() > 0) {
                words[i] = Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase();
            }
        }

        String result = String.join(" ", words);

        Files.writeString(outputfile, result);
    }
}
