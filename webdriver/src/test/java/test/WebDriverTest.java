package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HotelHomePage;

public class WebDriverTest {
    private final static String INCORRECT_CITY_NAME = "ghghghawq1221";
    private final static String CITY_NAME_ALERT_TEXT = "\n" +
            "                                No places found for the term&nbsp;<span id=\"searched-termn\">" + INCORRECT_CITY_NAME +  "</span>\n" +
            "                            ";
    private final static String RECENT_SEARCH = "";
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
        public void setUpBrowser(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dantes\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }


    @Test
    public void incorrectDestinationName(){
        String alertMessage = new HotelHomePage(driver)
                .openPage()
                .invalidSearch(INCORRECT_CITY_NAME)
                .invalidSearchAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }


    @Test
    public void checkSuggestionList(){
        String  message = new HotelHomePage(driver)
                .openPage()
                .validSearch("Alabama, USA")
                .getBack()
                .destinationSuggestion();
        Assert.assertEquals(message,RECENT_SEARCH);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;
    }


}
