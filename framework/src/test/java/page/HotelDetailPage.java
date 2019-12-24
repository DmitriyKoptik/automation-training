package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelDetailPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"summary-complete-hv\"]/span[3]")
    private WebElement priceNumber;

    @FindBy(xpath = "//*[@id=\"room-0-selection\"]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div/div[2]/div[2]/button")
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
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS2, TimeUnit.SECONDS);
        selectButton.click();
        logger.info("Go to booking page");

        return new BookingHotelPage(driver);
    }

    @Override
    public HotelDetailPage openPage() {
        return this;
    }

}
