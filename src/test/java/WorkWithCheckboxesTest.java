import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WorkWithCheckboxesTest extends BaseUI {
    @Test
    public void checkCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(checkboxes.get(0).isSelected(), "1st checkbox is selected");

        checkboxes.get(0).click();
        softAssert.assertTrue(checkboxes.get(0).isSelected(), "1st checkbox is not selected");

        softAssert.assertTrue(checkboxes.get(1).isSelected(), "2nd checkbox is not selected");

        checkboxes.get(1).click();
        softAssert.assertFalse(checkboxes.get(1).isSelected(), "2nd checkbox is selected");
        softAssert.assertAll();
    }
}
