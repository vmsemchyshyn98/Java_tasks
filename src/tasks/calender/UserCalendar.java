package homework.calender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserCalendar {


    private List<Event> listofEvents;
    private LinkedList<Country> listOfCountries;

    public UserCalendar() {
        this.listofEvents = new LinkedList<>();
        this.listOfCountries = new LinkedList<>();
    }


    void addEventsWithTimeZones(String nameOfEvent, String timeZon) {
        listofEvents.add(new Event(nameOfEvent, LocalDateTime.now(ZoneId.of(timeZon))));
    }

    void addEventsByDate(String nameOfEvent, int year, int month, int day) {
        listofEvents.add(new Event(nameOfEvent, LocalDateTime.of(year, month, day, 00, 00)));
    }


    void removeEvent(String nameOfEvent) {
        listofEvents.removeIf(event -> event.getNameOfEvent().equals(nameOfEvent));
    }

    void printEvents() {
        for (Event event : listofEvents) {
            System.out.println(event);
        }
    }

    void printInformationAboutCountry() {
        for (Country country : listOfCountries) {
            System.out.println(country.toString());
        }
    }


    void addCountries() {
        listOfCountries.add(new Country("qqqqq", LocalDateTime.now(ZoneId.of("Asia/Singapore"))));
        listOfCountries.add(new Country("vvvvv", LocalDateTime.now(ZoneId.of("America/New_York"))));
    }

    public void searchCountryByName(String nameOfCountry) {
        for (Country country : listOfCountries) {
            if (nameOfCountry.equals(country.getCountryName())) {
                System.out.println(country.toString());
            }
        }
    }


    LocalDateTime getFutureDay(int amount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusDays(amount);
        return localDateTime;
    }


    LocalDateTime getFutureMonth(int amount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusMonths(amount);
        return localDateTime;
    }

    LocalDateTime getFutureYear(int amount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusYears(amount);
        return localDateTime;
    }


    public void getTimeToNewYear() {
        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.lastDayOfYear()); //???
        LocalDate localDateNow = LocalDate.now();
        int yearsLeft = localDate.getYear() - localDateNow.getYear();
        int monthLeft = localDate.getMonthValue() - localDateNow.getMonthValue();
        int daysLeft = localDate.getDayOfMonth() - localDateNow.getDayOfMonth();
        System.out.println(daysLeft+":"+monthLeft+":"+yearsLeft);

    }


    public void getTimeToNextDay(LocalDate end) {
        LocalDate start = LocalDate.now();
        Period period = Period.between(start, end);
        System.out.println(period.getYears() + ":" + period.getMonths() + ":" + period.getDays());
    }


    void getDataFormat(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date localDate = new Date();
        System.out.println(simpleDateFormat.format(localDate));
    }

}
