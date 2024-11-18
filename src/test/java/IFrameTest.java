import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseUI {

    private static final By I_FRAME = By.xpath("//*[@id='mce_0_ifr']");
    private static final By REQUIRED_TEXT = By.xpath("//*[@id='tinymce']/p");

    @Test
    public void checkIFrame() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String actualText = driver.switchTo().frame(driver.findElement(I_FRAME)).findElement(REQUIRED_TEXT).getText();
        Assert.assertEquals(actualText, "Your content goes here.", "Text in paragraph is wrong");
    }
}
