package homework.calender;

import java.time.LocalDateTime;

public class Country {
    private String countryName;
    private LocalDateTime timeOfCountry;


    public Country(String countryName, LocalDateTime timeOfCountry) {
        this.countryName = countryName;
        this.timeOfCountry = timeOfCountry;

    }


    public String getCountryName() {
        return countryName;
    }


    public LocalDateTime getTimeOfCountry() {
        return timeOfCountry;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName=" + countryName +
                ", timeOfCountry=" + timeOfCountry+
                '}';
    }
}
