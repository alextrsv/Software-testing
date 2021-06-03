import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPage extends WebPage{

    WebElement searchLine;
    WebElement searchOptionTxt;
    WebElement searchOptionTv;
    WebElement searchOptionWeb;
    WebElement findTextBttn;
    WebElement findVideoBttn;
    WebElement findAudioBttn;
    WebElement findTVBttn;
    WebElement aboutBttn;
    WebElement blogBttn;
    WebElement donateBttn;
    WebElement topList;

    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://archive.org/");
        init();
    }

    private void init() {
        searchLine = driver.findElement(By.xpath("//input[@class=\"form-control input-sm roundbox20 js-search-bar ui-autocomplete-input\"]"));
        findTextBttn = driver.findElement(By.xpath("//a[@href=\"/details/texts\"]"));
        findVideoBttn = driver.findElement(By.xpath("//a[@href=\"/details/movies\"]"));
        findAudioBttn = driver.findElement(By.xpath("//a[@href=\"/details/audio\"]"));
        findTVBttn = driver.findElement(By.xpath("//a[@href=\"/details/tv\"]"));
        topList = driver.findElement(By.xpath("//div[@class=\"row\"]"));
        searchOptionTxt = driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"TXT\"]"));
        searchOptionTv = driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"TV\"]"));
        searchOptionWeb = driver.findElement(By.xpath("//input[@type=\"radio\"][@value=\"WEB\"]"));



        if (! (driver instanceof FirefoxDriver)) {
            WebElement subnav = expandRootElement(driver.findElement(By.xpath("//*[@id=\"topnav\"]/ia-topnav"))).findElement(By.cssSelector("desktop-subnav"));
            WebElement shadowRoot2 = expandRootElement(subnav);

            aboutBttn = shadowRoot2.findElement(By.cssSelector("ul>li:nth-child(1)>a"));
            blogBttn = shadowRoot2.findElement(By.cssSelector("ul>li:nth-child(2)>a"));
            donateBttn = shadowRoot2.findElement(By.cssSelector("ul>li:nth-child(5)>a"));
        }

    }


}
