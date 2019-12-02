package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import java.lang.*;

public class HotelHomePage extends AbstractPage{

    private static final String HOTEL_HOMEPAGE_URL = "https://www.bestwestern.com/en_US.html";

    @FindBy(xpath = "//input[@id ='destination-input']")
    private WebElement inputPlace;

    @FindBy(xpath = "//*[@id='btn-modify-stay-update']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class ='form-control searchDates no-spin hasDatepicker']")
    private WebElement arrivalDateSpan;

    @FindBy(xpath = "//*[@id=\"google-suggestions-not-found\"]/li")
    private WebElement alertMessage;

    @FindBy(xpath = "//*[@id=\"destination-input\"]")
    private WebElement suggestionMessage;


   public HotelHomePage invalidSearch(String destination){
       initDataSearch(destination);
       return new HotelHomePage(driver);

   }
    public SearchHotelResult validSearch(String destination){
        initDataSearch(destination);
        return new SearchHotelResult(driver);
    }

    public void initDataSearch(String destination){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputPlace.sendKeys(destination);
        searchButton.click();
    }

    public String invalidSearchAlertMessage(){
        return alertMessage.getAttribute("innerHTML");
    }

    public String destinationSuggestion(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return suggestionMessage.getText();
    }

    public HotelHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public HotelHomePage openPage()
    {
        driver.get(HOTEL_HOMEPAGE_URL);
        return this;
    }
}
