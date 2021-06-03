import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchWithListPage extends WebPage {

    SearchWithListPage(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }
    WebElement resultsList;
    WebElement noContentMessage;

    private void init(){
        try {
            resultsList = driver.findElement(By.xpath("//div[@class=\"results\"]"));
        }catch(org.openqa.selenium.NoSuchElementException noSuchElementException){
            resultsList = null;
            noContentMessage = driver.findElement(By.xpath("//div[@id=\"search-fail\"]"));
        }
    }

}
