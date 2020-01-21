package com.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class CalendarData {

    private final String YEAR;
    private final String MONTH;
    private Map<String, String> eventsMap;

    public CalendarData(String forYear, String forMonth) {
        this.YEAR = forYear;
        this.MONTH = forMonth;
        this.eventsMap = ServiceUtils.getEvents(this.YEAR, this.MONTH);
    }

    public Map<String, String> getEventsMap() {
        return eventsMap;
    }

    public String getMONTH() {
        return MONTH;
    }

    public String getYEAR() {
        return YEAR;
    }
}
