import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File doc = new File("documents");
        return dive(doc, fileName);
    }

    private static String dive(File folder, String fileName) {
        if (!folder.exists() || !folder.isDirectory()) {
            return null;
        }
        File[] subfiles = folder.listFiles();
        if (subfiles == null) {
            return null;
        }
        for (File file : subfiles) {
            if (file.isDirectory()) {
                String found = dive(file, fileName);
                if (found != null) {
                    return found;
                }
            } else if (file.isFile() && file.getName().equals(fileName)) {
                return file.getPath();
            }
        }
        return null;
    }
}