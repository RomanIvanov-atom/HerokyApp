import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTyposTest extends BaseUI {
    @Test
    public void checkTypos() {
        //предположим, что по требованиям опечатка может появляться не чаще 3 раз из 10
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement typoText;
        int typoCount = 0;
        for (int i = 0; i < 10; i++) {
            typoText = driver.findElement(By.xpath("//*[@id='content']//p[2]"));
            if (typoText.getText().contains("won,t"))
                typoCount++;
            driver.navigate().refresh();
        }
        Assert.assertTrue(typoCount <= 3, "Typo was found more than 3 times in 10 tries, " +
                "actual typos count = " + typoCount);
    }
}
