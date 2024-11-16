import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseUI {

    private static final String EXPECTED_FILE_NAME = "bb.txt";

    @Test
    public void checkDownloadFile() throws InterruptedException {
        int fileCountBefore = FileUtils.getFileCountInDownloads(FILE_TO_DOWNLOAD_PATH);
        System.out.println("Количество файлов до скачивания: " + fileCountBefore);

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[@id='content']//a[text()='bb.txt']")).click();
        System.out.println("Скачивается файл...");
        Thread.sleep(5000);

        int fileCountAfter = FileUtils.getFileCountInDownloads(FILE_TO_DOWNLOAD_PATH);
        System.out.println("Количество файлов после скачивания: " + fileCountAfter);
        Assert.assertEquals(fileCountAfter, fileCountBefore + 1, "Файл не был скачан!");
        Assert.assertTrue(FileUtils.isFileWithSpecificNamePresent(FILE_TO_DOWNLOAD_PATH, EXPECTED_FILE_NAME),
                "Файл с ожидаемым именем не найден!");
        System.out.println("Файл успешно скачан и проверен!");

        System.out.println("Попытка удалить скачанный файл");
        if (FileUtils.deleteFile(FILE_TO_DOWNLOAD_PATH, EXPECTED_FILE_NAME)) {
            System.out.println("Файл успешно удален.");
            int fileCountAfterDelete = FileUtils.getFileCountInDownloads(FILE_TO_DOWNLOAD_PATH);
            System.out.println("Количество файлов после удаления: " + fileCountAfterDelete);
        } else {
            System.out.println("Файл не найден или не удалось удалить.");
        }
    }
}
