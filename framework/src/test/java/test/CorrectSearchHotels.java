package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;

import static util.StringUtils.RECENT_SEARCH;

public class CorrectSearchHotels extends CommonCondition {


    @Test
    public void checkSuggestionList(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String  message = new HotelHomePage(driver)
                .openPage()
                .validSearch(hotelSearchOptions.getDestination())
                .getBack()
                .destinationSuggestion();
        Assert.assertEquals(RECENT_SEARCH,message);
    }
}
