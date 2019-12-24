package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 1;
    protected final int WAIT_TIMEOUT_SECONDS2 = 20;


    protected final Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}
