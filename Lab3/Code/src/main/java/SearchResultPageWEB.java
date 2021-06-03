import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v84.page.Page;

public class SearchResultPageWEB extends WebPage {
    SearchResultPageWEB(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }
    WebElement timeLine;
    WebElement calendar;
    WebElement noContentMessage;

    private void init(){
        try {
            timeLine = driver.findElement(By.xpath("//*[@id=\"wm-ipp-sparkline\"]/canvas"));
            calendar = driver.findElement(By.xpath("//div[@class=\"calendar-grid\"]"));
        }catch(org.openqa.selenium.NoSuchElementException noSuchElementException){
            timeLine = null;
            calendar = null;
            noContentMessage = driver.findElement(By.xpath("//div[@class=\"error error-border\"]"));
        }
    }

}
