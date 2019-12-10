package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;

import static util.StringUtils.CITY_NAME_ALERT_TEXT;

public class IncorrectSearchHotels extends CommonCondition  {

    @Test
    public void IncorrectDestinationName(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withIncorrectDestination();
        String alertMessage = new HotelHomePage(driver)
                .openPage()
                .invalidSearch(hotelSearchOptions.getDestination())
                .invalidSearchAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }
}
