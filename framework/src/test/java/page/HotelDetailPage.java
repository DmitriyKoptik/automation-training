package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"summary-complete-hv\"]/span[3]")
    private WebElement priceNumber;

    @FindBy(xpath = "//*[@id=\"room-0-selection\"]")
    private WebElement selectButton;

    public HotelDetailPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }

    public String getPriceFromHotelDetail() {
        logger.info("Getting price from hotel detail page");

        return priceNumber.getText();
    }

    public BookingHotelPage redirectToBookingHotelPage() {
        selectButton.click();
        logger.info("Go to booking page");

        return new BookingHotelPage(driver);
    }

    @Override
    public HotelDetailPage openPage() {
        return this;
    }

}
