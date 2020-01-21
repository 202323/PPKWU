package com.exercise3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Http request handler class
 */
@RestController
public class ServiceController {

    @RequestMapping("/generateMobileCalendar/{year}/{month}")
    public String generateTheCalendarFor(@PathVariable String year, @PathVariable String month) {
        CalendarData events = new CalendarData(year, month);
        new ICSGenerator(events);
        return "A calendar has been generated.";
    }
}
