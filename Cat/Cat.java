import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length==0){
            System.out.println("");
            return ;
        }
         Path filePath = Path.of(args[0]);
        try {
            String content = Files.readString(filePath);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}