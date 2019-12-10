package service;

import model.HotelSearchOptions;

public class HotelSearchOptionsCreator {
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION = "testdata.hotelSearchCriteria.destination";
    public static final String INCORRECT_DESTINATION = "dajfkladsjfl";


    public static HotelSearchOptions withCorrectSearch() {
        return new HotelSearchOptions(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION));

    }

    public static HotelSearchOptions withIncorrectDestination() {
        return new HotelSearchOptions(TestDataReader.getTestData(INCORRECT_DESTINATION));

    }
}
