package model;

import java.util.Objects;

public class HotelSearchOptions {
    private String destination;


    public HotelSearchOptions(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "HotelSearchOption{" +
                "destination='" + destination + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HotelSearchOptions that = (HotelSearchOptions) obj;
        return
                Objects.equals(destination, that.destination);
    }
}
