import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkWithInputTest extends BaseUI {
    @Test
    public void checkInputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        SoftAssert softAssert = new SoftAssert();
        input.sendKeys("abc");
        softAssert.assertFalse(input.getText().contains("abc"), "Digit input contains non-digit text");

        input.sendKeys("123");
        softAssert.assertTrue(input.getAttribute("value").contains("123"), "Digits are not entered in input");

        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertTrue(input.getAttribute("value").contains("125"), "Digit has not been increased");

        input.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertTrue(input.getAttribute("value").contains("124"), "Digit has not been decreased");
        softAssert.assertAll();
    }
}
