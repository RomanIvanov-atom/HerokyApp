import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseUI {

    public static final By UPLOAD_FILE_FIELD = By.xpath("//*[@id='file-upload']");
    public static final By SUBMIT_UPLOAD_BUTTON = By.xpath("//*[@id='file-submit']");
    public static final By UPLOADED_FILE_NAME = By.xpath("//*[@id='uploaded-files']");
    public static final String FILE_TO_UPLOAD_PATH = "src/main/resources/fileForUpload.txt";

    @Test
    public void checkUploadFile() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File(FILE_TO_UPLOAD_PATH);
        driver.findElement(UPLOAD_FILE_FIELD).sendKeys(file.getAbsolutePath());
        driver.findElement(SUBMIT_UPLOAD_BUTTON).click();
        Assert.assertEquals(driver.findElement(UPLOADED_FILE_NAME).getText(), "fileForUpload.txt",
                "Wrong file is uploaded or upload wasn't completed");
    }
}
