package homework.calender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        UserCalendar userCalendar=new UserCalendar();

        userCalendar.addEventsWithTimeZones("111","UTC");
        userCalendar.addEventsWithTimeZones("2222","GMT+10");
        userCalendar.addEventsWithTimeZones("2222","US/Pacific");

        userCalendar.addEventsByDate("3333",2019,04,10);
        userCalendar.addEventsByDate("3333",2019,03,5);
        userCalendar.removeEvent("3333");
        userCalendar.printEvents();

        userCalendar.addCountries();
        userCalendar.printInformationAboutCountry();

        System.out.println("Search country:");
        userCalendar.searchCountryByName("qqqqq");
        System.out.println("Get time to New Year:");
        userCalendar.getTimeToNewYear();

        System.out.println("Get Future Data:");
        System.out.println(userCalendar.getFutureDay(20));

        userCalendar.getTimeToNextDay(LocalDate.of(2020,1,2));
        System.out.println("Get data format:");
        userCalendar.getDataFormat("yyyy-MM-dd, HH:mm:ss");

    }
}
