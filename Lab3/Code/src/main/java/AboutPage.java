import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AboutPage extends WebPage {

    AboutPage(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }

    List<WebElement> partners;



    private void init(){
        try {
            partners = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/p[14]/a[*]"));
        }catch(org.openqa.selenium.NoSuchElementException noSuchElementException){
            System.out.println("some troubles...");
        }
    }
}
