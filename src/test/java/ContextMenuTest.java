import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContextMenuTest extends BaseUI {

    private static final By AREA_FOR_RIGHT_CLICK = By.xpath("//*[@id='hot-spot']");

    @Test
    public void checkContextMenuTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(AREA_FOR_RIGHT_CLICK)).perform();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu", "There is no required text in alert");
        driver.switchTo().alert().accept();
    }
}
