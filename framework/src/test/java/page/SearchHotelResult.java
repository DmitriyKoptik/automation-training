package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelResult extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"img-nav-logo\"]")
    private WebElement homePageButton;

    @FindBy(xpath = "//*[@id=\"city-state-33133\"]")
    private WebElement destinationName;

    @FindBy(xpath = "//*[@id=\"hotel-name-33133\"]")
    private WebElement hotelName;

    @FindBy(xpath = "//*[@id=\"mapViewMapColumn\"]")
    private WebElement hotelNameOnMap;

    @FindBy(xpath = "//*[@id=\"hotel-search-result-list\"]/div[20]/div[1]/div[2]/div[4]/a")
    private WebElement showDetails;

    @FindBy(xpath = "//*[@id=\"hotel-search-result-list\"]/div[20]/div[1]/div[2]/div[4]/p[2]")
    private WebElement priceNumber;

    @FindBy(xpath = "//*[@id=\"btn-modify-stay\"]")
    private WebElement changeSearch;

    @FindBy(xpath = "//*[@id=\"destination-input\"]")
    private WebElement destinationInput;

    @FindBy(xpath = "//*[@id=\"btn-modify-stay-update\"]")
    private WebElement submitChanges;


    public SearchHotelResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public HotelHomePage redirectToHotelHomePage() {
        homePageButton.click();
        logger.info("Redirecting to home page");

        return new HotelHomePage(driver);
    }

    public HotelDetailPage redirectToHotelDetailPage() {
        showDetails.click();
        logger.info("Redirect to page with hotel info");

        return new HotelDetailPage(driver);
    }

    public String getDestination() {
        logger.info("Getting destination name");

        return destinationName.getText();
    }

    public String getPriceFromSearchResult() {
        logger.info("Getting price from search results page");

        return priceNumber.getText();
    }

    public SearchHotelResult changeDestination(String destination){
        changeSearch.click();
        destinationInput.click();
        destinationInput.sendKeys(destination);
        submitChanges.click();
        logger.info("Changing and submitting new destination");
        return this;
    }

    public boolean rightDestinationIsPinnedOnMap() {
        boolean equality;
        logger.info("Checking equality of Hotels on List and on Map");
        equality = hotelName.getText() == hotelNameOnMap.getText();
        return equality;
    }

    @Override
    public SearchHotelResult openPage() {
        return this;
    }
}
