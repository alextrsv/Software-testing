import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class AboutPageTest {
    static WebDriver driver;
    MainPage mainPage;
    AboutPage aboutPage;
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
    public void AboutPageIsOpenTest(){
        mainPage.aboutBttn.click();
        assertEquals("Internet Archive: About IA", driver.getTitle());
    }


    @ParameterizedTest
    @CsvSource({
            "http://www.ala.org/, 0",
            "https://www.biodiversitylibrary.org/, 1",
            "https://blc.org/, 2",
            "https://califa.org/, 3",
            "https://www.clir.org/, 4",
            "https://www.cni.org/, 5",
            "https://www.diglib.org/, 6",
            "https://www.dpconline.org/, 7",
            "https://dp.la/, 8",
            "https://www.ifla.org/, 9",
    })
    public void GetPartnerPageTest(String url, int index){
        mainPage.aboutBttn.click();
        aboutPage = new AboutPage(driver, driver.getCurrentUrl());
        aboutPage.partners.get(index).click();
        assertEquals(url, driver.getCurrentUrl());
    }
}
