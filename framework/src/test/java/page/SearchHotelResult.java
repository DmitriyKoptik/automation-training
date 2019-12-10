package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchHotelResult extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"img-nav-logo\"]")
    private WebElement homePageButton;

    public HotelHomePage getBack(){
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        homePageButton.click();
        return new HotelHomePage(driver);
    }


    protected SearchHotelResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected SearchHotelResult openPage() {
        return this;
    }
}
