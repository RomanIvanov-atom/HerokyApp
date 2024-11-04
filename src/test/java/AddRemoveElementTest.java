import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddRemoveElementTest extends BaseUI {
    @Test
    public void checkAddRemoveElement() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        List<WebElement> deletesButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        softAssert.assertEquals(deletesButtons.size(), 2, "Найдено не 2 кнопки 'Удалить'");

        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        deletesButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        softAssert.assertEquals(deletesButtons.size(), 1, "Найдено не 1 кнопка 'Удалить'");

        softAssert.assertAll();
    }
}
