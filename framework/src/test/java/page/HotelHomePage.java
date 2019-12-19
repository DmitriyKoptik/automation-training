package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelHomePage extends AbstractPage{

    private static final String HOTEL_HOMEPAGE_URL = "https://www.bestwestern.com/en_US.html";

    @FindBy(xpath = "//input[@id ='destination-input']")
    private WebElement destinationsInput;

    @FindBy(xpath = "//*[@id='btn-modify-stay-update']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='check-res-mover']")
    private WebElement checkReservationsButton;

    @FindBy(xpath = "//*[@id=\"google-suggestions-not-found\"]/li")
    private WebElement alertMessage;

    @FindBy(xpath = "//*[@id=\"recent-searches-list\"]/li[1]")
    private WebElement suggestionMessage;

    @FindBy(className = "//*[@id='language-mover']")
    private WebElement currentPageLang;

    @FindBy(className = "//*[@id='language-dropdown']")
    private WebElement italianPageLang;

    @FindBy(className = "//*[@id=\"language-dropdown\"]/option[4]")
    private WebElement chooseItalian;

    @FindBy(className = "//*[@id='btn-language-submit']")
    private WebElement changeLanguage;

    @FindBy(xpath = "//*[@class='heroHeader']")
    private WebElement heroHeader;

    private By userRegistrationForm = By.id("check-res-by-confirmation-form");

    public HotelHomePage searchForHotels(String destinations, String checkIn, String checkOut) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return this;
    }

    public SearchHotelResult submitHotelSearch() {
        searchButton.click();
        logger.info("Redirect to page with search results");

        return new SearchHotelResult(driver);
    }

    public HotelHomePage checkReservations() {
        checkReservationsButton.click();
        logger.info("Redirect to page with search results");

        return this;
    }

    public boolean isRegistrationFormExists() {
        logger.info("Getting user registration form");

        return driver.findElements(userRegistrationForm).size() == 0;
    }

    public String destinationSuggestion(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return suggestionMessage.getText();
    }

    public HotelHomePage changeSystemLang() {
        currentPageLang.click();
        logger.info("Open language selection section");

        italianPageLang.click();
        chooseItalian.click();
        logger.info("Choose Italian language as default");

        changeLanguage.click();

        return new HotelHomePage(driver);
    }

    public HotelHomePage refreshPage() {
        driver.navigate().refresh();
        logger.info("Refresh page");

        return this;
    }

    public String getUpdatedMainHeroBanner() {
        logger.info("Getting value from main-hero banner on home page");

        return heroHeader.getText();
    }

    public HotelHomePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver,this);
    }

    public HotelHomePage submitInvalidHotelSearch() {
        searchButton.click();
        logger.info("Redirect to page with search results");

        return new HotelHomePage(driver);
    }

    public String invalidSearchAlertMessage(){
        logger.info("Checking alert message");

        return alertMessage.getAttribute("innerHTML");
    }

    @Override
    public HotelHomePage openPage()
    {
        driver.get(HOTEL_HOMEPAGE_URL);
        return this;
    }
}
