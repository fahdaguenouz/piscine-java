import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        try (
            FileWriter writ = new FileWriter(fileName)) {
            writ.write(content);
        }
    }

    public static String getContentFile(String fileName) throws IOException {
      
        Path p = Path.of(fileName);

        String content = Files.readString(p);
        return content;

    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}