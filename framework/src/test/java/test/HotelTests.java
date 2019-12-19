package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;
import static util.StringUtils.RECENT_SEARCH;
import static util.StringUtils.ITALIAN_BANNER_CONTENT;
import static util.StringUtils.CORRECT_CITY_NAME;
import static util.StringUtils.NEW_DESTINATION;

public class HotelTests extends CommonCondition {

    @Test
    public void destinationValidityInSearchResult(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String destination = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .getDestination();

        Assert.assertEquals(CORRECT_CITY_NAME, destination);
    }

    @Test
    public void registrationFormAppearsForUnregisteredUser() {
        boolean hasFormAppeared = new HotelHomePage(driver)
                .openPage()
                .checkReservations()
                .isRegistrationFormExists();

        Assert.assertFalse(hasFormAppeared);
    }

    @Test
    public void checkSuggestionListAfterSearch(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String  message = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .redirectToHotelHomePage()
                .destinationSuggestion();

        Assert.assertEquals(RECENT_SEARCH, message);
    }

    @Test
    public void chooseMainPageLanguageStoresInCookies() {
        String bannerContent = new HotelHomePage(driver)
                .openPage()
                .changeSystemLang()
                .refreshPage()
                .getUpdatedMainHeroBanner();

        Assert.assertEquals(ITALIAN_BANNER_CONTENT, bannerContent);
    }

    @Test
    public void changeDestinationInSearchResults() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String changedDestination = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .changeDestination(hotelSearchOptions.getNewDestination())
                .getDestination();

        Assert.assertEquals(NEW_DESTINATION, changedDestination);
    }

    @Test
    public void rightDestinationIsPointedOnAMap() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        boolean destinationOnMapEquals= new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .rightDestinationIsPinnedOnMap();

        Assert.assertTrue(destinationOnMapEquals);
    }

    @Test
    public void priceOfTheHotelAfterSearchingAreTheSameAsOnTheHotelPage() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String priceAmountInSearchResult = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .getPriceFromSearchResult();

        String pointsAmountInHotelDetail = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .redirectToHotelDetailPage()
                .getPriceFromHotelDetail();

        Assert.assertEquals(priceAmountInSearchResult, pointsAmountInHotelDetail);
    }

    @Test
    public void availabilityOfGuestInfoInputFieldForUnregistredUsers() {
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        boolean hasGuestInfoInputFieldAppeared = new HotelHomePage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(), hotelSearchOptions.getCheckIn(), hotelSearchOptions.getCheckOut())
                .submitHotelSearch()
                .redirectToHotelDetailPage()
                .redirectToBookingHotelPage()
                .isGuestInfoExists();

        Assert.assertFalse(hasGuestInfoInputFieldAppeared);
    }

}
