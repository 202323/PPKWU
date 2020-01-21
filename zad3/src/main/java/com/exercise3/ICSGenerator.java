package com.exercise3;
import net.fortuna.ical4j.model.Calendar;

public class ICSGenerator {

    public ICSGenerator(CalendarData calendarData) {
        Calendar calendar = ServiceUtils.createCalendar();
        ServiceUtils.populateCalendarWithEvents(calendarData.getEventsMap(), calendarData.getMONTH(), calendarData.getYEAR(), calendar);
        ServiceUtils.generateICSFromCalendar(calendarData.getYEAR(), calendarData.getMONTH(), calendar);
    }
}
