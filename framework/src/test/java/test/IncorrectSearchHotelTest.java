package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;

import static util.StringUtils.CITY_NAME_ALERT_TEXT;
import static util.StringUtils.DATA_INPUT_ALERT_TEXT;

public class IncorrectSearchHotelTest extends CommonCondition  {

    @Test
    public void IncorrectDestinationName(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withIncorrectDestination();
        String alertMessage = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination())
                .submitInvalidHotelSearch()
                .invalidSearchAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }

    @Test
    public void MakeReservationWithNoInfo(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String alertText = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination())
                .submitHotelSearch()
                .redirectToHotelDetailPage()
                .redirectToBookingHotelPage()
                .invalidDataInput();
        Assert.assertEquals(DATA_INPUT_ALERT_TEXT, alertText);
    }
}
