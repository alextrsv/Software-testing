import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlogPage extends WebPage {

    BlogPage(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }

    WebElement searchLine;
    List<WebElement> articles;
    List<WebElement> socialNetWorks;


    private void init(){
        try {
          searchLine = driver.findElement(By.xpath("//*[@id=\"s\"]"));
          articles = driver.findElements(By.xpath("//article"));
          socialNetWorks = driver.findElements(By.xpath("//a[@class=\"shareitem\"]"));
        }catch(org.openqa.selenium.NoSuchElementException noSuchElementException){
            System.out.println("some troubles...");
        }
    }
}
