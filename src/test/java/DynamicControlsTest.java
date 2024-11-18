import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseUI {

    private static final By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
    private static final By MESSAGE_TEXT = By.xpath("//*[@id='message']");
    private static final By CHECKBOX = By.xpath("//*[@id='checkbox']");
    private static final By ENABLE_BUTTON = By.xpath("//button[text()='Enable']");
    private static final By TEXT_INPUT = By.xpath("//input[@type='text']");

    @Test
    public void checkDynamicControls() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(REMOVE_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait.until(driver -> driver.findElement(MESSAGE_TEXT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX));

        WebElement input = driver.findElement(TEXT_INPUT);
        Assert.assertFalse(input.isEnabled());
        driver.findElement(ENABLE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(TEXT_INPUT));
    }
}
