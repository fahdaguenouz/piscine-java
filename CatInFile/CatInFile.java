import java.io.*;
import java.nio.file.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return; 
        }

        String filename = args[0];

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = Files.newBufferedWriter(Path.of(filename))
        ) {
            int c;
            while ((c = reader.read()) != -1) {  
                writer.write(c);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
