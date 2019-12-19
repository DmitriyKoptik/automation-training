package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingHotelPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"reservation-submit-button\"]")
    private WebElement makeReservation;

    @FindBy(xpath = "//*[@id=\"confirm-error-container\"]/div/div")
    private WebElement alertText;

    private By guestInfo = By.id("guest-info-information-panel");

    public BookingHotelPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }

    public boolean isGuestInfoExists() {
        logger.info("Getting guest information input table");

        return driver.findElements(guestInfo).size() == 0;
    }

    public String invalidDataInput() {
        makeReservation.click();
        logger.info("Cheching if error message has appeared");

        return alertText.getText();
    }

    @Override
    public BookingHotelPage openPage() {
        return this;
    }
}
