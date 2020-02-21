package homework.calender;

import java.time.LocalDateTime;

public class Event {
    private String nameOfEvent;
    private LocalDateTime timeOfEvent;//LocalDate or LocalDateTime

    public Event(String nameOfEvent, LocalDateTime timeOfEvent) {
        this.nameOfEvent = nameOfEvent;
        this.timeOfEvent = timeOfEvent;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "nameOfEvent='" + nameOfEvent + '\'' +
                ", timeOfEvent='" + timeOfEvent.getDayOfMonth() + "." + timeOfEvent.getMonthValue() + "." +
                timeOfEvent.getYear() +" -- "+timeOfEvent.getHour()+":"+timeOfEvent.getMinute()+
                ":"+timeOfEvent.getSecond()+ '\'' +
                '}';
    }
}
