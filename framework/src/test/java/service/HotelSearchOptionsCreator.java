package service;

import model.HotelSearchOptions;

public class HotelSearchOptionsCreator {
    public static final String TEST_DATA_HOTEL_SEARCH_OPTIONS_DESTINATION = "testdata.hotelSearchCriteria.destination";
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE = "testdata.hotelSearchCriteria.arrivalDate";
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE = "testdata.hotelSearchCriteria.departureDate";
    public static final String INCORRECT_DESTINATION = "testdata.hotelSearchCriteria.invalidDestination";


    public static HotelSearchOptions withCorrectSearch() {
        return new HotelSearchOptions(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_OPTIONS_DESTINATION),
                TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE,TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE);

    }

    public static HotelSearchOptions withIncorrectDestination() {
        return new HotelSearchOptions(TestDataReader.getTestData(INCORRECT_DESTINATION),
                TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE, TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE);

    }
}
