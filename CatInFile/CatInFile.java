import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
 if (args.length !=1){
            return ;
        }
        String filename= args[0];
        Path path= Path.of(filename);
        try {
            byte[] content = System.in.readAllBytes();
            Files.write(path,content);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } 
    }
}   