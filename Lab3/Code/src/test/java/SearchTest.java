import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    static WebDriver driver;
    MainPage mainPage;
    SearchResultPageWEB searchResultPageWEB;
    SearchResultPageTEXT searchResultPageTEXT;
    SearchResultPageTV searchResultPageTV;
    SearchWithListPage searchWithListPage;
    String currentUrl;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\IT\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "E:\\IT\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeEach
    void setUpMainPage(){
       mainPage = new MainPage(driver);
    }

    @Test
    public void test0SearchInTopSizeNotZero(){
        List<WebElement> topElements =mainPage.topList.findElements(By.xpath("//div[@class=\"item-ia collection-ia\"]"));
        assertTrue(topElements.size() != 0);
    }



    // WEB SEARCH TEST-----------------------------------------------------------------------------


    @ParameterizedTest
    @ValueSource(strings = {"https://www.oracle.com/ru/index.html","https://archive.org/", "https://ru.wikipedia.org/wiki/Анива_(маяк)",
            "https://ru.wikipedia.org/wiki/Заглавная_страница"})
    public void WebBrouseIsOpenTest(String url) throws InterruptedException {
        setUpSearchResultPage("WEB", url);
        assertEquals("Wayback Machine", driver.getTitle());
    }


    @ParameterizedTest
    @ValueSource(strings = {"https://www.oracle.com/ru/index.html","https://archive.org/", "https://ru.wikipedia.org/wiki/Анива_(маяк)",
            "https://ru.wikipedia.org/wiki/Саров", "https://telepedia.fandom.com/ru/wiki/Канал-16", "https://vk.com/cramelx"})
    public void WebBrouseTestTimeLineISNotNull(String url) throws InterruptedException {
        setUpSearchResultPage("WEB", url);

        try {
            assertNotNull(searchResultPageWEB.timeLine);
        }catch (org.opentest4j.AssertionFailedError assertionFailedError){
            assertNotNull(searchResultPageWEB.noContentMessage);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://www.oracle.com/ru/index.html","https://archive.org/", "https://ru.wikipedia.org/wiki/Анива_(маяк)",
            "https://ru.wikipedia.org/wiki/Саров", "https://telepedia.fandom.com/ru/wiki/Канал-16", "https://vk.com/cramelx"})
    public void WebBrouseTestCalendarINotNull(String url) throws InterruptedException {
        setUpSearchResultPage("WEB", url);
        try {
            assertNotNull(searchResultPageWEB.calendar);
        }catch (org.opentest4j.AssertionFailedError assertionFailedError){
            assertNotNull(searchResultPageWEB.noContentMessage);
        }
    }



   //TEXT SEARCH TESTS========================================================================================

    //title test
    @ParameterizedTest
    @ValueSource(strings = {"London", "Daniel Kiz", "holly"})
    public void TextBroseResultPageIsOpenTest(String inputString) throws InterruptedException {
        setUpSearchResultPage("TEXT", inputString);

        assertEquals("Internet Archive Search: " + inputString, driver.getTitle());
    }

    //List not null test
    @ParameterizedTest
    @ValueSource(strings = {"London", "Daniel Kiz", "holly", "@#$@", "959595DDD"})
    public void TextBrouseTestResultListIsNotNull(String inputString) throws InterruptedException {
        setUpSearchResultPage("TEXT", inputString);
        try {
            assertNotNull(searchResultPageTEXT.resultsList);
        }catch (org.opentest4j.AssertionFailedError assertionFailedError){
            assertNotNull(searchResultPageTEXT.noContentMessage);
        }
    }


    //TV SEARCH TEST==============================================================================================================

    //title test
    @ParameterizedTest
    @ValueSource(strings = {"London", "holly"})
    public void TVBroseResultPageIsOpenTest(String inputString) throws InterruptedException {
        setUpSearchResultPage("TV", inputString);
        assertEquals("Internet Archive TV NEWS : Search Captions. Borrow Broadcasts", driver.getTitle());
    }

    //List not null test
    @ParameterizedTest
    @ValueSource(strings = {"London", "holly", "@#$@", "959595DDD"})
    public void TVBroseTestResultListIsNotNull(String inputString) throws InterruptedException {
        setUpSearchResultPage("TV", inputString);
        try {
            assertNotNull(searchResultPageTV.resultsList);
        }catch (org.opentest4j.AssertionFailedError assertionFailedError){
            assertNotNull(searchResultPageTV.noContentMessage);
        }
    }


    //TEXT SEARCH WITH LIST TEST=======================================================================================================

    //title test
    @ParameterizedTest
    @CsvSource({
            "L_TEXT, Free Books : Download & Streaming : eBooks and Texts : Internet Archive",
            "L_VIDEO, Download & Streaming : Moving Image Archive : Internet Archive",
            "L_AUDIO, Download & Streaming : Audio Archive : Internet Archive",
    })
    public void ListBroseResultPageIsOpenTest(String searchType, String expectedTitle) throws InterruptedException {
        setUpSearchResultPage(searchType, "");
        assertEquals(expectedTitle, driver.getTitle());
    }


    @ParameterizedTest
    @ValueSource(strings = {"L_TEXT", "L_VIDEO", "L_AUDIO", "L_TV"})
    public void TEXTBroseTestResultListIsNotNull(String searchType) throws InterruptedException {
        setUpSearchResultPage(searchType, "");
        assertTrue(searchWithListPage.resultsList.findElements(By.xpath("//div[@class=\"item-ia collection-ia\"]")).size() > 0);
    }




    // others methods=============================================================================================================

    void getNewSearchPage(String inputString) throws InterruptedException {
        mainPage.searchLine.sendKeys(inputString);
        mainPage.searchLine.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        currentUrl = driver.getCurrentUrl();
    };

    void getNewSearchWithListPage(WebElement bttn){
        bttn.click();
        currentUrl = driver.getCurrentUrl();
    }


    public void setUpSearchResultPage(String searchType, String inputString) throws InterruptedException {
        mainPage.searchLine.click();

        switch (searchType){
            case "WEB":
                ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",mainPage.searchOptionWeb);
                getNewSearchPage(inputString);
                searchResultPageWEB = new SearchResultPageWEB(driver, currentUrl);
                break;
            case "TEXT":
                ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",mainPage.searchOptionTxt);
                getNewSearchPage(inputString);
                searchResultPageTEXT = new SearchResultPageTEXT(driver, currentUrl);
                break;
            case "TV":
                ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",mainPage.searchOptionTv);
                getNewSearchPage(inputString);
                searchResultPageTV = new SearchResultPageTV(driver, currentUrl);
                break;
            default:
                switch (searchType) {
                    case "L_TEXT":
                        getNewSearchWithListPage(mainPage.findTextBttn);
                        break;
                    case "L_VIDEO":
                        getNewSearchWithListPage(mainPage.findVideoBttn);
                        break;
                    case "L_AUDIO":
                        getNewSearchWithListPage(mainPage.findAudioBttn);
                        break;
                    case "L_TV":
                        getNewSearchWithListPage(mainPage.findTVBttn);
                        break;
                }
                searchWithListPage = new SearchWithListPage(driver, currentUrl);
                break;
        }

    }




}