import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length==0){
            return ;
        }
         Path filePath = Path.of(args[0]);
        try {
           byte[] content = Files.readAllBytes(filePath);
            System.out.write(content);
        } catch (IOException e) {
            System.err.println( e.getMessage());
        }
    }
}