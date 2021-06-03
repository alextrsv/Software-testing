import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTest {


    @Test
    public void testTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\IT\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://archive.org/");
        WebElement searchLine = driver.findElement(By.xpath("//input[@class=\"form-control input-sm roundbox20 js-search-bar ui-autocomplete-input\"]"));
        searchLine.click();

        WebElement radioBtn1 = driver.findElement(By.xpath("//*[@id=\"search_options\"]/fieldset/label[5]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);

        searchLine.sendKeys("https://ru.wikipedia.org/wiki/Википедия");
        searchLine.sendKeys(Keys.ENTER);



    }



    

}
