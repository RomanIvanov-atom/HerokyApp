import java.io.File;

public class FileUtils {

    public static int getFileCountInDownloads (String downloadDir) {
        File downloadDirectory = new File(downloadDir);
        File[] files = downloadDirectory.listFiles();
        return files != null ? files.length : 0;
    }

    public static boolean isFileWithSpecificNamePresent(String downloadDir, String fileName) {
        File file = new File(downloadDir, fileName);
        return file.exists();
    }

    public static boolean deleteFile(String downloadDir, String fileName) {
        File file = new File(downloadDir, fileName);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}