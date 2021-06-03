import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BlogPageTest {

    static WebDriver driver;
    MainPage mainPage;
    BlogPage blogPage;
    String currentUrl;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\IT\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUpMainPage(){
        mainPage = new MainPage(driver);
    }

    @Test
    public void BlogPageIsOpenTest(){
        mainPage.blogBttn.click();
        assertEquals("Internet Archive Blogs - A blog from the team at archive.org", driver.getTitle());
    }


    @ParameterizedTest
    @CsvSource({
            "Book, 10",
            "Abby, 7",
            "Atop, 3",
    })
    public void SearchInBlogTest(String inputString, int amount){
        mainPage.blogBttn.click();
        blogPage = new BlogPage(driver, driver.getCurrentUrl());
        blogPage.searchLine.sendKeys(inputString, Keys.ENTER);
        blogPage = new BlogPage(driver, driver.getCurrentUrl());
        assertEquals(amount, blogPage.articles.size());
    }

    @ParameterizedTest
    @CsvSource({
            "0, https://www.facebook.com/login.php?skip_api_login=1&api_key=966242223397117&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fsharer%2Fsharer.php%3Fu%3Dhttps%253A%252F%252Fblog.archive.org&cancel_url=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fclose_window%2F%3Fapp_id%3D966242223397117%26connect%3D0%23_%3D_&display=popup&locale=ru_RU",
            "1, https://twitter.com/intent/tweet?url=https%3A%2F%2Fblog.archive.org&via=internetarchive&text=Getting+Started+at+the+Internet+Archive",
    })
    public void ShareTest(int index, String url){
        mainPage.blogBttn.click();
        blogPage = new BlogPage(driver, driver.getCurrentUrl());
        blogPage.socialNetWorks.get(index).click();
        driver.navigate().to(blogPage.socialNetWorks.get(index).getAttribute("href"));
        assertEquals(url, driver.getCurrentUrl());
    }
}
